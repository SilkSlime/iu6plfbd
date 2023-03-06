package l4;



public class e3 {
    
    /**
     * Вариант 2. Задача 5.
     * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов:
     * interface Mobile <- abstract class Siemens Mobile <- class Model
     */

    public static void main(String[] args) {
        // Example of polymorphism
        Mobile mobile = new Model();
        mobile.call();
        mobile.text();

        // Example of inheritance
        SiemensMobile siemensMobile = new Model();
        siemensMobile.call();
        siemensMobile.sendSMS();
    }
}

interface Mobile {
    void call();
    void text();
}

// Siemens Mobile abstract class
abstract class SiemensMobile implements Mobile {
    public void call() {
        System.out.println("Calling from a Siemens mobile.");
    }
    
    // Abstract method for texting
    abstract void sendSMS();
}

// Model class that extends SiemensMobile
class Model extends SiemensMobile {
    public void text() {
        System.out.println("Sending text message from Model.");
    }
    
    // Implementation of sendSMS method
    public void sendSMS() {
        System.out.println("Sending SMS from Model.");
    }
}