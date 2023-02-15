package A0_SOLIDDesign.LiskovSubstitutionPrinciple;

public class LSPDemo {
    public static void main(String[] args) {
        Rectangle square = RectangleFactory.newSquare(5);
        System.out.println(square.getArea());
        Rectangle rectangle = RectangleFactory.newRectangle(4, 2);
        System.out.println(rectangle.getArea());
    }
}
