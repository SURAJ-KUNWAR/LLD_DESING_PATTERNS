package Creational.AbstractFactory;

public class MacOsFactory implements GuiFactory{
    @Override
    public Button createButton() {
       return new MacOsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOsCheckBox();
    }
}
