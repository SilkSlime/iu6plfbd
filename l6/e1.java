package l6;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class e1 {
    
    /**
     * Вариант 1. Задача 5.
     * Умножить два многочлена заданной степени, если коэффициенты многочленов хранятся в различных списках.
     */
    public static void main(String[] args) {
        // Создаем два списка со случайными числами - коэффициентами многочленов
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            list1.add(random.nextInt(10));
            list2.add(random.nextInt(10));
        }

        // Выводим многочлены
        System.out.println("Многочлен 1: " + list1);
        System.out.println("Многочлен 2: " + list2);

        // Умножаем многочлены
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (i + j >= result.size()) {
                    result.add(list1.get(i) * list2.get(j));
                } else {
                    result.set(i + j, result.get(i + j) + list1.get(i) * list2.get(j));
                }
            }
        }

        // Выводим результат
        System.out.println("Результат: " + result);

        // Пример (2x^4 + 7x^3 + 2x^2 + 2x + 1)*(2x^4 + 2x^3 + 6x^2 + 6x + 7) = 4x^8 + 18x^7 + 30x^6 + 62x^5 + 74x^4 + 75x^3 + 32x^2 + 20x + 7

    }
}