package Behavioural;

interface PaymentStrategy{
    void pay();
}

class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("Cash Payment");
    }
}

class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("UPI Payment");
    }
}
class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("Card Payment");
    }
}
class ShoppingCart{
    PaymentStrategy paymentStrategy;
    public ShoppingCart(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(){
        paymentStrategy.pay();
    }
}
public class StrategyPattern {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart(new CashPaymentStrategy());
        shoppingCart.pay();
        shoppingCart.setPaymentStrategy(new UPIPaymentStrategy());
        shoppingCart.pay();
    }
}
