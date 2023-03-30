package l6;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class e2 {
    
    /**
     * Вариант 1. Задача 6.
     * Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные – в начало этого списка. 
     */
    public static void main(String[] args) {
        // Создаем список со случайными числами
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(20) - 10);
        }
        System.out.println("Исходный список: " + list);

        // Переставляем отрицательные элементы в конец, а положительные – в начало списка
        // Для этого можно просто отсортировать список
        Collections.sort(list);
        System.out.println("Итоговый список: " + list);
    }
 }