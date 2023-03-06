package l4;

import java.util.ArrayList;
import java.util.List;

public class e2 {
    
    /**
     * Вариант 1. Задача 6.
     * Создать класс Shop (магазин) с внутренним классом,
     * с помощью объектов которого можно хранить информацию
     * об отделах, товарах и услуг. 
     */

    public static void main(String[] args) {
        Shop shop = new Shop("My Shop");
        shop.addDepartment("Electronics");
        shop.addDepartment("Clothing");

        Shop.Department electronics = shop.getDepartment("Electronics");
        electronics.addProduct("TV", 1000);
        electronics.addProduct("Laptop", 800);

        Shop.Department clothing = shop.getDepartment("Clothing");
        clothing.addProduct("Shirt", 50);
        clothing.addProduct("Jeans", 70);

        System.out.println("Welcome to "+shop.getName()+"!");
        System.out.println("Products in Electronics:");
        for (Shop.Department.Product product : electronics.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        System.out.println("\nProducts in Clothing:");
        for (Shop.Department.Product product : clothing.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
}

class Shop {

    private String name;
    private List<Department> departments;

    public Shop(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDepartment(String name) {
        Department department = new Department(name);
        departments.add(department);
    }

    public Department getDepartment(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    public class Department {
        private String name;
        private List<Product> products;

        public Department(String name) {
            this.name = name;
            this.products = new ArrayList<>();
        }

        public void addProduct(String name, double price) {
            Product product = new Product(name, price);
            products.add(product);
        }

        public Product getProduct(String name) {
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    return product;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }

        public List<Product> getProducts() {
            return products;
        }

        public class Product {
            private String name;
            private double price;

            public Product(String name, double price) {
                this.name = name;
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public double getPrice() {
                return price;
            }
        }
    }
}