package l9;

import java.util.ArrayList;
import java.util.List;

public class e2 {
    /**
     * Вариант 1. Задача 2.
     * Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
     * Задана коллекция строк. Вернуть первый элемент коллекции, а также
     * существуют ли все совпадения с шаблоном. Шаблон можно выбрать произвольно.  
     */
    public static void main(String[] args) {
          // Обявляем коллекцию строк
        List<String> list = new ArrayList<String>();
        list.add("loremor");
        list.add("ipsumor");
        list.add("dolor");
        list.add("molor");
        list.add("color");
        list.add("sitor");
        list.add("ametor");

        // Выводим первый элемент коллекции через Stream API
        System.out.println(list.stream().findFirst().get());

        // Шаблон для слов, которые оканчиваются на "olor"
        String pattern = ".*or";

        // Проверяем, существуют ли все совпадения с шаблоном без использования циклов и условий
        System.out.println(list.stream().allMatch(s -> s.matches(pattern)));
    }
}
