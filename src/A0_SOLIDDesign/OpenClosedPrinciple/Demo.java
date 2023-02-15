package A0_SOLIDDesign.OpenClosedPrinciple;

import java.util.List;

public class Demo {
    private static void print(String name, String message) {
        System.out.println(" - " + name + " " + message);
    }

    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();

        System.out.println("Green Old");
        pf.filterByColor(products, Color.GREEN).forEach(p -> print(p.name, "is green"));

        BetterFilter betterFilter = new BetterFilter();

        System.out.println("Green New");
        betterFilter.filter(products, new ColorSpecification(Color.GREEN)).forEach(p -> print(p.name, "is green"));
        System.out.println("Blue New");
        betterFilter.filter(products, new ColorSpecification(Color.BLUE)).forEach(p -> print(p.name, "is blue"));

        betterFilter.filter(products, new AndSpecification<>(
                new ColorSpecification(Color.GREEN),
                new SizeSpecification(Size.SMALL)
        )).forEach(p -> print(p.name, "is green n small"));
    }
}
