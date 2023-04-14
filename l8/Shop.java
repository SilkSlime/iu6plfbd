package l8;

import java.util.Random;

public class Shop {
    private int stock;

    public Shop(int initialStock) {
        stock = initialStock;
    }

    // Вызывается производителем
    public synchronized void receiveGoods(int quantity) {
        stock += quantity;
        System.out.println(Thread.currentThread().getName() + " received " + quantity + " goods. Stock: " + stock);
        // notifyAll - пробуждает все потоки, которые ждут этого объекта
        notifyAll();
    }

    // Вызывается покупателем
    public synchronized void buyGoods(int quantity) {
        while (stock < quantity) {
            try {
                System.out.println(Thread.currentThread().getName() + " wants to buy " + quantity + " goods but stock is " + stock + ". Waiting for more goods to arrive.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stock -= quantity;
        System.out.println(Thread.currentThread().getName() + " bought " + quantity + " goods. Stock: " + stock);
    }

    public static void main(String[] args) {
        // Создаем магазин с начальным запасом 10 товаров
        Shop shop = new Shop(10);

        // Создаем производителя и покупателей
        Manufacturer manufacturer = new Manufacturer(shop);
        Thread manufacturerThread = new Thread(manufacturer);

        // Запускаем производителя
        manufacturerThread.start();

        // Запускаем покупателей
        Buyer buyer1 = new Buyer(shop, 5);
        Thread buyer1Thread = new Thread(buyer1);
        buyer1Thread.start();

        Buyer buyer2 = new Buyer(shop, 7);
        Thread buyer2Thread = new Thread(buyer2);
        buyer2Thread.start();
    }

    // implements Runnable - означает, что класс реализует интерфейс Runnable
    // Runnable - интерфейс, который содержит метод run()
    // run() - метод, который будет выполняться в отдельном потоке
    private static class Manufacturer implements Runnable {
        private Shop shop;
        private Random random;

        public Manufacturer(Shop shop) {
            this.shop = shop;
            random = new Random();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int quantity = random.nextInt(10) + 1;
                    Thread.sleep(2000);
                    shop.receiveGoods(quantity);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Buyer implements Runnable {
        private Shop shop;
        private int quantity;

        public Buyer(Shop shop, int quantity) {
            this.shop = shop;
            this.quantity = quantity;
        }

        @Override
        public void run() {
            while (true) {
                shop.buyGoods(quantity);
                try {
                    Thread.sleep(1000); // simulate shopping time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
