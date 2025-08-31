package Creational.SimpleFactory;

public class client {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("Circle");
        circle.draw();
    }
}
