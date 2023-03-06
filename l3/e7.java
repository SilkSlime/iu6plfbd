package l3;

import java.util.ArrayList;

public class e7 {
    
    /**
     * Вариант 4. Задача 5.
     * Построить модель программной системы.
     * Система Библиотека. Читатель оформляет Заказ на Книгу. Система осуществляет поиск в Каталоге.
     * Библиотекарь выдает Читателю Книгу на абонемент или в читальный зал.
     * При невозвращении Книги Читателем он может быть занесен Администратором в «черный список».
     */

    public static void main(String[] args) {
        Book book1 = new Book("Java Programming");
        Book book2 = new Book("Database Management");
        Reader reader1 = new Reader("Alice");
        Reader reader2 = new Reader("Bob");
        Librarian librarian = new Librarian();
        Administrator administrator = new Administrator();

        // Test issuing a book for subscription
        librarian.issueBook(book1, reader1, true);

        // Test issuing a book for reading room
        librarian.issueBook(book2, reader2, false);

        // Test returning a book
        librarian.returnBook(book2, reader2);

        // Test blacklisting a reader
        administrator.blacklistReader(reader1);

        // Test preventing a blacklisted reader from issuing a book
        if (!administrator.isReaderBlacklisted(reader1)) {
            librarian.issueBook(book1, reader1, false);
        } else {
            System.out.println("[MAIN] " + reader1.getName() + " is blacklisted");
        }
    
        // Test returning a book to the library from blacklisted reader
        librarian.returnBook(book1, reader1);
    }
}


class Reader {
    private String name;
    private ArrayList<Order> orders;

    public Reader(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Book book, boolean forSubscription) {
        Order order = new Order(book, forSubscription);
        orders.add(order);
        System.out.println("[REDR] Order placed by " + name + " for book " + book.getTitle() + " (" + (forSubscription ? "subscription" : "reading room") + ")");
    }

    public void returnBook(Book book) {
        for (Order order : orders) {
            if (order.getBook() == book) {
                orders.remove(order);
                System.out.println("[REDR] "+ name + " returned book " + book.getTitle());
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}

class Book {
    private String title;
    private boolean available;

    public Book(String title) {
        this.title = title;
        this.available = true;
    }

    public void issue(boolean forSubscription) {
        if (available) {
            available = false;
            System.out.println("[BOOK] Book '" + title + "' issued " + (forSubscription ? "for subscription" : "for reading room"));
        } else {
            System.out.println("[BOOK] Book '" + title + "' not available");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println("[BOOK] Book '" + title + "' returned");
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }
}

class Order {
    private Book book;
    private boolean forSubscription;

    public Order(Book book, boolean forSubscription) {
        this.book = book;
        this.forSubscription = forSubscription;
    }

    public Book getBook() {
        return book;
    }

    public boolean isForSubscription() {
        return forSubscription;
    }
}

class Librarian {
    public void issueBook(Book book, Reader reader, boolean forSubscription) {
        book.issue(forSubscription);
        reader.placeOrder(book, forSubscription);
    }

    public void returnBook(Book book, Reader reader) {
        book.returnBook();
        reader.returnBook(book);
    }
}

class Administrator {
    private ArrayList<Reader> blacklistedReaders;

    public Administrator() {
        this.blacklistedReaders = new ArrayList<>();
    }

    public void blacklistReader(Reader reader) {
        blacklistedReaders.add(reader);
        System.out.println("[ADMN] " + reader.getName() + " blacklisted");
    }

    public boolean isReaderBlacklisted(Reader reader) {
        return blacklistedReaders.contains(reader);
    }
}