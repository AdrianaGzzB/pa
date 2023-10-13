package com.company;
import static com.company.creational.prototype.PrototypeFactory.CardType.AMEX;
import static com.company.creational.prototype.PrototypeFactory.CardType.VISA;
import com.company.behavioral.chainofresponsability.Black.*;
import com.company.behavioral.chainofresponsability.Tarjeta;
import com.company.behavioral.command.CreditCard;
import com.company.behavioral.command.CreditCardActivateCommand;
import com.company.behavioral.command.CreditCardDesactivateCommand;
import com.company.behavioral.command.CreditCardInvoker;
import com.company.creational.abstractFactory.AbstractFactory;
import com.company.creational.abstractFactory.Card;
import com.company.creational.abstractFactory.FactoryProvider;
import com.company.creational.abstractFactory.PaymentMethod;
import com.company.creational.factorymethod.Payment;
import com.company.creational.factorymethod.PaymentFactory;
import com.company.creational.factorymethod.TypePayment;
import com.company.creational.prototype.PrototypeCard;
import com.company.creational.prototype.PrototypeFactory;

public class Main {
    public static void main(String[] args) {
        //CREACIONALES
        //testFactoryMethod();
        //testAbstractFactory();
        //testBuilder();
        //testPrototype();
        //testSinglenton();

        //BEHAVIORAL(COMPORTAMIENTO)
        //testChainOfResponsability();
        testCommand();
    }

    private static void testCommand() {
        CreditCard creditCard = new CreditCard();
        CreditCard creditCardDesactivate= new CreditCard();
        CreditCardInvoker invoker =new CreditCardInvoker();
        invoker.setCommand(new CreditCardActivateCommand(creditCard));
        invoker.run();
        System.out.println("----------------");
        invoker.setCommand(new CreditCardDesactivateCommand(creditCardDesactivate));
        invoker.run();
    }

    private static void testChainOfResponsability(){
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.crediCardRequest(200000);
    }
    private static void testSinglenton(){
        com.company.creational.singlenton.Card.getINSTANCE().setCardNumber("1234 5678 9123 1234");
        System.out.println(com.company.creational.singlenton.Card.getINSTANCE().getCardNumber());
    }

    private static void testPrototype(){
        PrototypeFactory.loadCard();
        try {
            PrototypeCard visa = PrototypeFactory.getInstance(VISA);
            visa.getCard();
            PrototypeCard amex = PrototypeFactory.getInstance(AMEX);
            amex.getCard();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

    private static void testBuilder(){
        com.company.creational.builder.Card card = new com.company.creational.builder.Card.CardBuilder("VISA",
                "0000 2222 0000 VISA")
                .name("Adriana")
                .expires(2030)
                .credit(true).build();
        System.out.println(card);
        com.company.creational.builder.Card card2 = new com.company.creational.builder.Card.CardBuilder("AMEX",
                "0000 3333 0000 0000")
                .build();
        System.out.println(card2);
    }
    private static void testFactoryMethod(){
        Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
    }

    private static void testAbstractFactory(){
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        Card tarjeta = (Card) abstractFactory.create("VISA");
        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("DEBIT");
        System.out.println("Una tarjeta de tipo: " + tarjeta.getCardType() + "con el metodo de pago: " + paymentMethod.doPayment());
    }
}