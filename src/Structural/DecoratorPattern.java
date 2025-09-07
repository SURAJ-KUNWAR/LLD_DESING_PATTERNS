package Structural;


// component which will be decorated
interface Coffee{
     String getDescription() ;
     int getCost();
}

//concrete class cofee
class SimpleCoffee implements Coffee{

    @Override
    public String getDescription() {
        return "Simple Cofee";
    }

    @Override
    public int getCost() {
        return 10;
    }
}

//Base Decorator
abstract class CoffeeDecorator implements Coffee{
    protected Coffee inner;
    CoffeeDecorator(Coffee inner){
        this.inner = inner;
    }

    public abstract String getDescription();
    public abstract int getCost();
}

//Milk Decorator

class MilkDecorator extends CoffeeDecorator{

    MilkDecorator(Coffee inner){
        super(inner);
    }
    @Override
    public String getDescription() {
        return inner.getDescription() + "milk";
    }

    @Override
    public int getCost() {
        return inner.getCost() + 5;
    }
}

class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee inner){
        super(inner);
    }
    @Override
    public String getDescription() {
        return inner.getDescription() + "sugar";
    }

    @Override
    public int getCost() {
        return inner.getCost() + 2;
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new SugarDecorator(coffee);
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getCost());
        System.out.println(coffee.getDescription());


    }
}
