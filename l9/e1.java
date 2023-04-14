package l9;

import java.util.ArrayList;
import java.util.List;

public class e1 {
    /**
     * Вариант 1. Задача 1.
     * Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
     * Задана коллекция строк. Вернуть последний элемент и третий элемент коллекции.
     */
    public static void main(String[] args) {
        // Обявляем коллекцию строк
        List<String> list = new ArrayList<String>();
        list.add("lorem");
        list.add("ipsum");
        list.add("dolor");
        list.add("sit");
        list.add("amet");

        // Выводим последний элемент коллекции через Stream API
        System.out.println(list.stream().skip(list.size() - 1).findFirst().get());

        // Выводим третий элемент коллекции через Stream API
        System.out.println(list.stream().skip(2).findFirst().get());
    }
}
