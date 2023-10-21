package com.company;
import static com.company.creational.prototype.PrototypeFactory.CardType.AMEX;
import static com.company.creational.prototype.PrototypeFactory.CardType.VISA;
import com.company.behavioral.chainofresponsability.Black.*;
import com.company.behavioral.chainofresponsability.Tarjeta;
import com.company.behavioral.command.CreditCard;
import com.company.behavioral.command.CreditCardActivateCommand;
import com.company.behavioral.command.CreditCardDesactivateCommand;
import com.company.behavioral.command.CreditCardInvoker;
import com.company.behavioral.interpreter.AnExpression;
import com.company.behavioral.interpreter.Expression;
import com.company.behavioral.interpreter.OrExpression;
import com.company.behavioral.interpreter.TerminalExpression;
import com.company.behavioral.iterator.CardIterator;
import com.company.behavioral.iterator.CardList;
import com.company.behavioral.iterator.Iterator;
import com.company.behavioral.iterator.List;
import com.company.behavioral.mediator.ConcreteColleage1;
import com.company.behavioral.mediator.ConcreteColleage2;
import com.company.behavioral.mediator.ConcreteMediator;
import com.company.behavioral.memento.Article;
import com.company.behavioral.memento.ArticleMemento;
import com.company.behavioral.memento.Carataker;
import com.company.behavioral.observer.Coche;
import com.company.behavioral.observer.MessagePublisher;
import com.company.behavioral.observer.Peaton;
import com.company.behavioral.observer.Semaforo;
import com.company.behavioral.status.MobileAlertStateContext;
import com.company.behavioral.status.Silent;
import com.company.behavioral.status.Vibration;
import com.company.behavioral.strategy.CapitalStrategyTextFormatter;
import com.company.behavioral.strategy.Context;
import com.company.behavioral.strategy.LoverStrategyTestFormatter;
import com.company.behavioral.templatemethod.Paypa;
import com.company.behavioral.templatemethod.Visa;
import com.company.behavioral.visitor.*;
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
        //testCommand();
        //testIterator();
        //testmediator();
        //testMemento();
        //testObserver();
        //testState();
        //testInterpreter();
        //testStrategy();
        //testTemplateMethod();
        //testVisitor();
        testAdapter();


    }

    private static void testAdapter() {
        com.company.structural.adapter.CreditCard creditCard = new com.company.structural.adapter.CreditCard();
        creditCard.pay("classic");
        creditCard.pay("gold");
        creditCard.pay("black");
        creditCard.pay("silver");
    }

    private static void testVisitor() {
        OfertaElement ofertaElement = new OfertaGasolina();
        ofertaElement.accept(new BlackCreditCardVisitor());
        ofertaElement = new OfertaVuelos();
        ofertaElement.accept(new ClassicCreditCardVisitor());
    }

    private static void testTemplateMethod() {
        com.company.behavioral.templatemethod.Payment payment = new Visa();
        payment.makePayment();

        payment = new Paypa();
        payment.makePayment();
    }

    private static void testStrategy() {
        Context context = new Context( new CapitalStrategyTextFormatter());
        context.publishText("Este texto sera convertido a MAYUSCULAS a través del algoritmo");

        context = new Context(new LoverStrategyTestFormatter());
        context.publishText("Este texto SERA CONVERTIDO a MINUSCULAS a través del algoritmo");
    }

    private static void testInterpreter() {
        Expression cero = new TerminalExpression("0");
        Expression uno = new TerminalExpression("1");

        Expression containBoolean = new OrExpression(cero, uno);
        Expression containOneAndCero = new AnExpression(cero, uno);

        System.out.println(containBoolean.interpret("cero"));
        System.out.println(containBoolean.interpret("0"));

        System.out.println(containOneAndCero.interpret("0"));
        System.out.println(containOneAndCero.interpret("0,1"));

    }

    private static void testState() {
        MobileAlertStateContext context = new MobileAlertStateContext();
        context.alert();
        context.alert();
        context.setState(new Vibration());
        context.alert();
        context.alert();
        context.setState((new Silent()));
        context.alert();
        context.alert();
    }

    private static void testObserver() {
        Coche coche = new Coche();
        Peaton peaton = new Peaton();
        MessagePublisher messagePublisher = new MessagePublisher();

        messagePublisher.attach(coche);
        messagePublisher.attach(peaton);
        messagePublisher.notifyUpdate(new Semaforo("ROJO_COCHE"));
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        messagePublisher.notifyUpdate(new Semaforo("VERDE_COCHE"));

    }

    private static void testMemento() {
        Carataker carataker = new Carataker();
        Article article = new Article("Adriana", "Memento es una pelicula");
        article.setText(article.getText() + "de Nolan");
        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());
        article.setText(article.getText() + "protagonizada por Guy Pearce");
        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());

        article.setText(article.getText() + "y Leonardo DiCaprio");
        System.out.println(article.getText());

        ArticleMemento memento1 = carataker.getMemento(0);
        ArticleMemento memento2 = carataker.getMemento(1);

        article.restoreMemento(memento1);
        System.out.println(article.getText());

        article.restoreMemento(memento2);
        System.out.println(article.getText());

        article.setText(article.getText() + "del año");

    }

    private static void testmediator() {
        ConcreteMediator mediator= new ConcreteMediator();
        ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
        ConcreteColleage2 user2 = new ConcreteColleage2(mediator);

        mediator.setUser1(user1);
        mediator.setUser2(user2);

        user1.send("Hola soy user1");
        user2.send("Hola user1, soy user2");
    }

    private static void testIterator() {
        com.company.behavioral.iterator.Card[] cards = new com.company.behavioral.iterator.Card[5];
        cards[0] = new com.company.behavioral.iterator.Card("VISA");
        cards[1] = new com.company.behavioral.iterator.Card("AMEX");
        cards[2] = new com.company.behavioral.iterator.Card("MASTER CARD");
        cards[3] = new com.company.behavioral.iterator.Card("GOOGLE CARD");
        cards[4] = new com.company.behavioral.iterator.Card("APPLE CARD");

        List lista = new CardList(cards);
        Iterator iterator = lista.iterator();
        while (iterator.hasNext()){
            com.company.behavioral.iterator.Card tarjeta = (com.company.behavioral.iterator.Card)iterator.next();
            System.out.println(tarjeta.getType());
        }

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