package l8;

import java.util.Random;

public class Bank {
    // Общая для потоков переменная
    private int balance = 0;

    // Метод, который вызывается потоком для пополнения счета
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ". Balance is now " + balance + ".");
    }

    // Метод, который вызывается потоком для снятия денег со счета
    public synchronized void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Not enough funds to withdraw " + amount + ". Balance is " + balance + ".");
        } else {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". Balance is now " + balance + ".");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Создаем 10 потоков, которые будут пополнять счет
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Random random = new Random();
                int amount = random.nextInt(100);
                bank.deposit(amount);
            }).start();
        }

        // Создаем 10 потоков, которые будут снимать деньги со счета
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Random random = new Random();
                int amount = random.nextInt(100);
                bank.withdraw(amount);
            }).start();
        }
    }
}
