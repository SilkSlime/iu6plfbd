package l4;



public class e4 {
    
    /**
     * Вариант 2. Задача 6.
     * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов:
     * interface Корабль <- abstract class Военный Корабль <- class Авианосец
     */

    public static void main(String[] args) {
        // Example of polymorphism
        Ship ship = new AircraftCarrier();
        ship.sail();
        
        // Example of inheritance
        Warship warship = new AircraftCarrier();
        warship.sail();
        warship.attack();
    }
}

// Ship interface
interface Ship {
    void sail();
}

// Warship abstract class that implements Ship interface
abstract class Warship implements Ship {
    public void sail() {
        System.out.println("Sailing from a warship.");
    }
    
    // Abstract method for attacking
    abstract void attack();
}

// AircraftCarrier class that extends Warship
class AircraftCarrier extends Warship {
    public void attack() {
        System.out.println("Attacking from an aircraft carrier.");
    }
}