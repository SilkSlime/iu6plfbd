package l3;

import java.util.ArrayList;
import java.util.List;

public class e8 {
    
    /**
     * Вариант 4. Задача 6.
     * Построить модель программной системы.
     * Система Конструкторское бюро. Заказчик представляет Техническое Задание (ТЗ)
     * на проектирование многоэтажного Дома. Конструктор регистрирует ТЗ, определяет
     * стоимость проектирования и строительства, выставляет Заказчику Счет за
     * проектирование и создает Бригаду Конструкторов для выполнения Проекта. 
     */

     public static void main(String[] args) {
        // Заказчик и Конструктор
        Customer customer = new Customer("John");
        Constructor constructor = new Constructor("ABC Construction");

        // Техническое задание на проектирование многоэтажного дома 
        TermsOfReference tor = new TermsOfReference("Multi-storey building", 10, 1000);

        // Конструктор регистрирует ТЗ
        constructor.registerTOR(tor);

        // Конструктор определяет стоимость проектирования и строительства, выставляет Заказчику Счет за проектирование
        Invoice invoice = constructor.issueInvoice(customer, constructor.calculateCost(tor));

        // Конструктор создает Бригаду Конструкторов для выполнения Проекта
        List<Constructor> brigade = constructor.createBrigade(tor);

        // Заказчик, Конструктор, Техническое задание, Счет
        System.out.println(customer);
        System.out.println(constructor);
        System.out.println(tor);
        System.out.println(invoice);

        // Бригада Конструкторов
        for (Constructor member : brigade) {
            System.out.println(member);
        }
    }
}

class Customer {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Constructor {
    private final String name;
    private final List<TermsOfReference> registeredTORs;

    public Constructor(String name) {
        this.name = name;
        this.registeredTORs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void registerTOR(TermsOfReference tor) {
        registeredTORs.add(tor);
    }

    public int calculateCost(TermsOfReference tor) {
        // Конструктор определяет стоимость проектирования и строительства
        return tor.getNumberOfFloors() * tor.getArea() * 100;
    }

    public Invoice issueInvoice(Customer customer, int amount) {
        // Конструктор выставляет Заказчику Счет за проектирование
        return new Invoice(customer, this, amount);
    }

    public List<Constructor> createBrigade(TermsOfReference tor) {
        // Create a brigade of constructors to carry out the project
        // Конструктор создает Бригаду Конструкторов для выполнения Проекта
        List<Constructor> brigade = new ArrayList<>();
        for (int i = 0; i < tor.getNumberOfFloors(); i++) {
            brigade.add(new Constructor(name + " " + (i+1)));
        }
        return brigade;
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "name='" + name + '\'' +
                '}';
    }
}

class TermsOfReference {
    private final String name;
    private final int numberOfFloors;
    private final int area;

    public TermsOfReference(String name, int numberOfFloors, int area) {
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "TermsOfReference{" +
                "name='" + name + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", area=" + area +
                '}';
    }
}

class Invoice {
    private final Customer customer;
    private final Constructor constructor;
    private final int amount;

    public Invoice(Customer customer, Constructor constructor, int amount) {
        this.customer = customer;
        this.constructor = constructor;
        this.amount = amount;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public Constructor getConstructor() {
        return constructor;
    }
    
    public int getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer.getName() +
                ", constructor=" + constructor.getName() +
                ", amount=" + amount +
                '}';
    }
}