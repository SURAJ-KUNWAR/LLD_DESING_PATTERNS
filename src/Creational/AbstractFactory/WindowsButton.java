package Creational.AbstractFactory;

public class WindowsButton implements Button {
    @Override
    public void draw() {
        System.out.println("Windows Button");
    }
}
