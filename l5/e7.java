package l5;

// import ArrayList
import java.util.ArrayList;
import java.util.List;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class e7 {

    /**
     * Вариант 4. Задача 5.
     * При выполнении для вывода результатов создавать
     * новую директорию и файл средствами класса File.
     * 
     * Файл содержит символы, слова, целые числа и
     * числа с плавающей запятой. Определить все
     * данные, тип которых вводится из командной строки.
     */

    public static void main(String[] args) {
        // Check count of arguments
        if (args.length != 1) {
            System.out.println("Usage: programm <type>");
            System.out.println("Where <type> is one of the following:");
            System.out.println("    char");
            System.out.println("    word");
            System.out.println("    int");
            System.out.println("    float");
            return;
        }
        // check type and create arraylist "values "of selected type
        String type = args[0];
        List<?> values;

        if (type.equals("char")) {
            values = new ArrayList<Character>();
        } else if (type.equals("word")) {
            values = new ArrayList<String>();
        } else if (type.equals("int")) {
            values = new ArrayList<Integer>();
        } else if (type.equals("float")) {
            values = new ArrayList<Float>();
        } else {
            System.out.println("Unknown type: " + type);
            return;
        }

        // Входной и выходной файлы
        String inputFileName = "l5/e7.txt";

        try {
            File inputFile = new File(inputFileName);

            // Создаем объект для чтения (буферизованные потоки)
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Чтение по строкам
            String line;
            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на слова с разделителем - любой пробельный символ
                String[] words = line.split("\\s+");
                // Перебираем слова
                for (String word : words) {
                    if (type.equals("char")) {
                        if (word.length() == 1) {
                            ((ArrayList<Character>) values).add(word.charAt(0));
                        }
                    } else if (type.equals("word")) {
                        ((ArrayList<String>) values).add(word);
                    } else if (type.equals("int")) {
                        if (word.matches("\\d+")) {
                            ((ArrayList<Integer>) values).add(Integer.parseInt(word));
                        }
                    } else if (type.equals("float")) {
                        if (word.matches("\\d+\\.\\d+")) {
                            ((ArrayList<Float>) values).add(Float.parseFloat(word));
                        }
                    }
                }
            }

            // Выводим результат
            System.out.println("Values of type " + type + ":");
            for (Object value : values) {
                System.out.println(value);
            }

            // Закрываем потоки
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}