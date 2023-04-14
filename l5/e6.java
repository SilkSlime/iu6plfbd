package l5;

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;



public class e6 {
    
    /**
     * Вариант 3. Задача 6.
     * Требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
     * При этом могут рассматриваться два варианта:
     *     - каждая строка состоит из одного слова; 
     *     - каждая строка состоит из нескольких слов
     * 
     * В каждой строке стихотворения Анны Ахматовой подсчитать
     * частоту повторяемости каждого слова из заданного списка и
     * вывести эти слова в порядке возрастания частоты повторяемости. 
     */

    public static void main(String[] args) {
        // Обратный индекс "слово"-"количество"
        HashMap<String, Integer> index = new HashMap<String, Integer>();


        // Читаем строки из файла
        String inputFileName = "l5/e6.txt";

        try {
            // Так как в файле русские буквы, то используем FileReader с параметром "UTF-8"
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName), "UTF-8"));
            // BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на слова c разделителем - любое количество пробелов
                String[] words = line.split("\\s+");

                // Для каждого слова
                for (String word : words) {
                    // Приводим слово к нижнему регистру и убираем знаки препинания

                    word = word.toLowerCase().replaceAll("[^a-zа-я]", "");
                    // Если слово пустое, то пропускаем его
                    if (word.isEmpty()) {
                        continue;
                    }

                    // Если слово уже есть в индексе, то увеличиваем счетчик
                    if (index.containsKey(word)) {
                        index.put(word, index.get(word) + 1);
                    } else {
                        // Иначе добавляем слово в индекс со значением 1
                        index.put(word, 1);
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
            return;
        }

        // Выводим индекс в порядке убывания частоты
        index.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(System.out::println);

    }
}