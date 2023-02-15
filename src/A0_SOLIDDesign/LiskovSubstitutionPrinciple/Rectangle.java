package A0_SOLIDDesign.LiskovSubstitutionPrinciple;

public class Rectangle {
    protected int width, height;

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return "Rectangle { " +
                "width=" + width +
                ", height=" + height +
                "}";
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
