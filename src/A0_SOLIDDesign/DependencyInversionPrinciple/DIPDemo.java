package A0_SOLIDDesign.DependencyInversionPrinciple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream()
                .filter(x -> x.getValue0().name.equals("John") &&
                        x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}

class Research {
    public Research(Relationships relationships) {
        List<Person> children = relationships.findAllChildrenOf("John");
        for (Person p : children) {
            System.out.println("John has a child called : " + p.getName());
        }

    }
}

class Demo {
    public static void main(String[] args) {
        Person john = new Person("John");
        Person chris = new Person("Chris");
        Person matt = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(john, chris);
        relationships.addParentAndChild(john, matt);

        Research research = new Research(relationships);

    }
}
