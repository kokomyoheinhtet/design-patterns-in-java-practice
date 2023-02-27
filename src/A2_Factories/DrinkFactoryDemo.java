package A2_Factories;


import org.javatuples.Pair;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

interface IHotDrink {
    void consume();
}

class Coffee implements IHotDrink {
    @Override
    public void consume() {
        System.out.println("This coffee is super");
    }
}

class Tea implements IHotDrink {
    @Override
    public void consume() {
        System.out.println("This Tea is unbelievable");
    }
}

interface IHotDrinkFactory {
    IHotDrink prepare(int amount);
}

class TeaFactory implements IHotDrinkFactory {
    @Override
    public IHotDrink prepare(int amount) {
        System.out.println("Put " + amount + "ml of tea.");
        return new Tea();
    }
}

class CoffeeFactory implements IHotDrinkFactory {
    @Override
    public IHotDrink prepare(int amount) {
        System.out.println("Add " + amount + "g of coffee");
        return new Coffee();
    }
}

class HotDrinkMachine {
    public enum AvailableDrink {
        COFFEE, TEA

    }

    private Map<AvailableDrink, IHotDrinkFactory> factories = new HashMap<>();

    private List<Pair<String, IHotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() throws Exception {
        //option 1: use an enum
        for (AvailableDrink drink : AvailableDrink.values()) {
            String s = drink.toString();
            String factoryName = "" + Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
            Class<?> factory = Class.forName("A2_Factories." + factoryName + "Factory");
            factories.put(drink, (IHotDrinkFactory) factory.getDeclaredConstructor().newInstance());
        }

        //option 2: find all implementors of IHotDrinkFactory

        Set<Class<? extends IHotDrinkFactory>> types =
                new Reflections(new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forPackage("A2_Factories"))).getSubTypesOf(IHotDrinkFactory.class);
        for (Class<? extends IHotDrinkFactory> type : types) {
            namedFactories.add(new Pair<>(
                    type.getSimpleName().replace("Factory", ""),
                    type.getDeclaredConstructor().newInstance()
            ));
        }
    }

    public IHotDrink makeDrink() throws IOException {
        System.out.println("Ava. drinks");
        for (int i = 0; i < namedFactories.size(); ++i) {
            Pair<String, IHotDrinkFactory> item = namedFactories.get(i);
            System.out.println(i + ": " + item.getValue0());
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s;
            int i, amount;
            if ((s = reader.readLine()) != null
                    && (i = Integer.parseInt(s)) >= 0
                    && i < namedFactories.size()) {
                System.out.println("Specify amount: ");
                s = reader.readLine();
                if (s != null
                        && (amount = Integer.parseInt(s)) > 0) {
                    return namedFactories.get(i).getValue1().prepare(amount);
                }
            }
            System.out.println("Incorrect input, try again.");
        }
    }

    public IHotDrink makeDrink(AvailableDrink drink, int amount) {
        return ((IHotDrinkFactory) factories.get(drink)).prepare(amount);
    }
}

public class DrinkFactoryDemo {
    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();
        IHotDrink tea = machine.makeDrink(HotDrinkMachine.AvailableDrink.TEA, 200);
        tea.consume();

        IHotDrink drink = machine.makeDrink();
        drink.consume();
    }
}
