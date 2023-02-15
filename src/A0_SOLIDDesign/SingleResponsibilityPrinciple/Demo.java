package A0_SOLIDDesign.SingleResponsibilityPrinciple;


public class Demo {

    public static void main(String[] args) throws Exception {
        Journal journal = new Journal();
        journal.addEntries("I ate wat thar dote htoe yesterday");
        journal.addEntries("I have no idea what to eat today");
        System.out.println(journal);

        Persistence persistence = new Persistence();
        String filename = "./tmp/firstJ.txt";
        persistence.saveToFile(journal, filename, true);
    }
}
