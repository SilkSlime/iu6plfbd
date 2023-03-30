package l6;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;


public class e3 {
        
    /**
     * Вариант 2. Задача 5.
     * Во входном файле расположены два набора положительных чисел;
     * между наборами стоит отрицательное число. Построить два
     * списка C1 и С2, элементы которых содержат соответственно
     * числа 1-го и 2-го набора таким образом, чтобы внутри одного
     * списка числа были упорядочены по возрастанию. Затем
     * объединить списки C1 и С2 в один упорядоченный список,
     * изменяя только значения полей ссылочного типа.
     */
     public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("l6/e3.txt"));
        
        List<Integer> c1 = new ArrayList<Integer>();
        List<Integer> c2 = new ArrayList<Integer>();

        // Разделяем числа на две группы
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num < 0) {
                break;
            }
            c1.add(num);
        }
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num < 0) {
                break;
            }
            c2.add(num);
        }

        // Сортируем списки по возрастанию
        Collections.sort(c1);
        Collections.sort(c2);

        // Объединяем списки
        List<Integer> combinedList = new ArrayList<>(c1);
        combinedList.addAll(c2);

        // Сортируем объединенный список
        Collections.sort(combinedList);

        // Выводим результат
        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);
        System.out.println("Combined: " + combinedList);
    }
 }