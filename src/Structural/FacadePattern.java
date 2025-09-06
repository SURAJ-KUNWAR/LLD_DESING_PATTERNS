package Structural;

class ValidateCustomer{
    public void customerValidated(){
        System.out.println("customerValidated");
    }
}
class TaxService{
    public void computeTax(){
        System.out.println("computeTax");
    }
}

class PaymentService{
    public void paymentValidated(){
        System.out.println("paymentValidated");
    }
}
class InvoiceService{
    public void generateInvoice(){
        System.out.println("Invoice generated");
    }
}
 class NotifcationService{
    public void notifyCustomer(){
        System.out.println("notify Customer");
    }
 }

 class BillingFacade{
    ValidateCustomer validateCustomer = new ValidateCustomer();
    TaxService taxService = new TaxService();
    PaymentService paymentService = new PaymentService();
    InvoiceService invoiceService = new InvoiceService();
    NotifcationService notifcationService = new NotifcationService();

    public void chargeAndInvoice(){
        validateCustomer.customerValidated();
        taxService.computeTax();
        paymentService.paymentValidated();
        invoiceService.generateInvoice();
        notifcationService.notifyCustomer();
        System.out.println("charge and invoice successfull");
    }
 }
public class FacadePattern {
    public static void main(String[] args) {
        BillingFacade billingFacade = new BillingFacade();
        billingFacade.chargeAndInvoice();
    }
}
