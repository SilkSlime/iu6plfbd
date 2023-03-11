package l5;

public class e3 {
    
    /**
     * Из 3й лабы. Вариант 2. Задача 5.
     * Создать класс
     * Bookk: id, Название, Автор(ы), Издательство, Год издания, Количество страниц, Цена, Переплет.
     * Создать массив объектов. Вывести:
     * a) список книг заданного автора;
     * b) список книг, выпущенных заданным издательством;
     * c) список книг, выпущенных после заданного года.
     * Определить конструкторы и методы setТип(), getТип(), toString().
     * Определить дополнительно методы в классе, создающем массив объектов.
     * Задать критерий выбора данных и вывести эти данные на консоль. 
     * 
     * Выполнить задание, реализуя собственные обработчики исключений и исключения ввода/вывода
     */

    public static void main(String[] args) {
        // Define an array of 5 books and fill it with different data (differe authors, publishers, years, etc.)
        Bookk[] books = new Bookk[5];
        books[0] = new Bookk(1, "Bookk1", new String[] {"Author1", "Author2"}, "Publisher1", 2000, 100, 10.0, "Hardcover");
        books[1] = new Bookk(2, "Bookk2", new String[] {"Author1", "Author3"}, "Publisher2", 2001, 200, 20.0, "Hardcover");
        books[2] = new Bookk(3, "Bookk3", new String[] {"Author2", "Author3"}, "Publisher3", 2002, 300, 30.0, "Hardcover");
        books[3] = new Bookk(4, "Bookk4", new String[] {"Author1", "Author2"}, "Publisher4", 2003, 400, 40.0, "Hardcover");
        books[4] = new Bookk(5, "Bookk5", new String[] {"Author1", "Author3"}, "Publisher5", 2004, 500, 50.0, "Hardcover");

        // Print all books
        System.out.println("All books:");
        for (Bookk book : books) {
            System.out.println(book);
        }

        // Print books by author
        System.out.println("Bookks by Author1:");
        for (Bookk book : books) {
            for (String author : book.getAuthors()) {
                if (author.equals("Author1")) {
                    System.out.println(book);
                }
            }
        }

        // Print books by publisher
        System.out.println("Bookks by Publisher1:");
        for (Bookk book : books) {
            if (book.getPublisher().equals("Publisher1")) {
                System.out.println(book);
            }
        }

        // Print books after year
        System.out.println("Bookks after 2002:");
        for (Bookk book : books) {
            if (book.getYear() > 2002) {
                System.out.println(book);
            }
        }
    }
}

class Bookk {
    private int id;
    private String name;
    private String[] authors;
    private String publisher;
    private int year;
    private int pages;
    private double price;
    private String binding;

    public Bookk(int id, String name, String[] authors, String publisher, int year, int pages, double price, String binding) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.binding = binding;
    }

    // method to create array of books with random data and random authors
    public static Bookk[] createRandomBookks(int count) {
        Bookk[] books = new Bookk[count];
        for (int i = 0; i < count; i++) {
            books[i] = new Bookk(i, "Bookk" + i, new String[] {"Author" + (int) (Math.random() * 10), "Author" + (int) (Math.random() * 10)}, "Publisher" + (int) (Math.random() * 10), (int) (Math.random() * 100), (int) (Math.random() * 1000), Math.random() * 100, "Hardcover");
        }
        return books;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
    
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    // Override toString() method to print the object
    @Override
    public String toString() {
        String authors = "";
        // join all authors in one string without last comma
        for (int i = 0; i < this.authors.length; i++) {
            if (i == this.authors.length - 1) {
                authors += this.authors[i];
            } else {
                authors += this.authors[i] + ", ";
            }
        }
        return name + " by " + authors + " published by " + publisher + " in " + year + " with " + pages + " pages, " + price + " rub. and " + binding + " binding.";
    }

}
