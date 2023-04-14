package l9;

import java.util.ArrayList;
import java.util.List;

public class e3 {
    /**
     * Вариант 2. Задача 1.
     * Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
     * Задана коллекция строк. Отсортировать значения по алфавиту и убрать повторы.
     */
    public static void main(String[] args) {
        // Обявляем коллекцию строк
        List<String> list = new ArrayList<String>();
        list.add("lorem");
        list.add("ipsum");
        list.add("dolor");
        list.add("sit");
        list.add("amet");
        list.add("sit");
        list.add("amet");

        // Сортируем значения по алфавиту и убираем повторы
        list.stream().sorted().distinct().forEach(System.out::println);
    }

}
