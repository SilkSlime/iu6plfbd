package l9;

import java.util.Arrays;
import java.util.Collection;

public class e4 {
    /**
     * Вариант 2. Задача 2.
     * Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
     * Задана коллекция:
     * (Класс People: имя и возраст)
     * Collection<People> peoples = Arrays.asList(
     * new People("Ivan", 16),
     * new People("Petr", 23),
     * new People("Maria", 42)
     * );
     * Отсортировать по имени в обратном алфавитном порядке.
     */
    public static void main(String[] args) {
        // Объявляем коллекуию пиплов
        Collection<People> peoples = Arrays.asList(
                new People("Ivan", 16),
                new People("Petr", 23),
                new People("Maria", 42));

        // Сортируем по имени в обратном алфавитном порядке через Stream API
        peoples.stream().sorted((p1, p2) -> p2.getName().compareTo(p1.getName())).forEach(System.out::println);

    }
}

// Класс People
class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Оверрайд для строкового представления объекта
    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
