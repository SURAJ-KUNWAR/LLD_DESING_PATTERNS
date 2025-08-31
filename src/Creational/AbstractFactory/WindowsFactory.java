package Creational.AbstractFactory;

public class WindowsFactory implements GuiFactory {
    @Override
    public Button createButton() {
       return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WIndowsCheckBox();
    }
}
