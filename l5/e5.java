package l5;

import java.util.Scanner;

public class e5 {
    
    /**
     * Вариант 3. Задача 5.
     * Требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
     * При этом могут рассматриваться два варианта:
     *     - каждая строка состоит из одного слова; 
     *     - каждая строка состоит из нескольких слов
     * 
     * Найти в строке наибольшее число цифр, идущих подряд. 
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Количество цифр подряд
        int count = 0;
        // Максимальное количество цифр подряд
        int maxCount = 0;

        // Читаем строки из консоли пока не встретим пустую строку
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            

            // Разбиваем строку на слова c разделителем - любое количество пробелов
            String[] words = line.split("\\s+");

            for (String word : words) {
                
                // Для каждого символа в слове
                for (int i = 0; i < word.length(); i++) {
                    // Если символ - цифра, то увеличиваем счетчик
                    if (Character.isDigit(word.charAt(i))) {
                        count++;
                    } else {
                        // Иначе обнуляем счетчик
                        count = 0;
                    }

                    // Если счетчик больше максимального, то обновляем максимальный
                    if (count > maxCount) {
                        maxCount = count;
                    }
                }
            }

            // Выводим максимальное значение
            System.out.println("Max digits len: " + maxCount);
            maxCount = 0;
            count = 0;
        }


        
        
    }
}