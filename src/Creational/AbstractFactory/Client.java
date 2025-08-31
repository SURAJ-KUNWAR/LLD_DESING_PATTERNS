package Creational.AbstractFactory;

public class Client {
    public static void main(String[] args) {
        GuiFactory windowsfactory = new WindowsFactory();
        GuiFactory macosFactory = new MacOsFactory();

        // see here we created 4 things right ?
        // windows btn , windows chckbox , macos btn , macos checkbox
        //but we creatred only two factory , if this was
        //factory method than we would have ended up with 4 facoty
        //classes
       Button btnWin =  windowsfactory.createButton();
       Checkbox chckWin = windowsfactory.createCheckbox();

        Button btnMacOs = macosFactory.createButton();
        Checkbox chckMacOs = macosFactory.createCheckbox();
    }
}
