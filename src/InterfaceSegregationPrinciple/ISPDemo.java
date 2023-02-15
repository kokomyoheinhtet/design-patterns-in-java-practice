package InterfaceSegregationPrinciple;

public class ISPDemo {
}

class Document {
}

interface Machine {
    void print(Document d);

    void fax(Document d) throws Exception;

    void scan(Document d) throws Exception;
}

class MultiFunctionPrinter implements Machine {

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) throws Exception {
        throw new Exception();
    }

    @Override
    public void scan(Document d) throws Exception {
        throw new Exception();
    }
}

interface Printer {
    void print(Document d) throws Exception;
}

interface IScanner {
    void scan(Document d) throws Exception;
}

class JustAPrinter implements Printer {

    @Override
    public void print(Document d) throws Exception {

    }
}

class Photocopier implements Printer, IScanner {

    @Override
    public void print(Document d) throws Exception {

    }

    @Override
    public void scan(Document d) throws Exception {

    }
}

interface MultifunctionDevice extends Printer, IScanner {
}

class MultifunctionMachine implements MultifunctionDevice {

    private Printer printer;
    private IScanner scanner;

    public MultifunctionMachine(Printer printer, IScanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) throws Exception {
        printer.print(d);
    }

    @Override
    public void scan(Document d) throws Exception {
        scanner.scan(d);
    }
}