package l7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class e8 {

    /**
     * Вариант 4. Задача 5.
     * Вывести в заданном тексте все слова, расположив их в алфавитном порядке.
     */
    public static void main(String[] args) {
        String text = readFile("l7/sometext.txt");
        // Разбить по всем символам, кроме букв и цифр
        String[] words = text.split("[^a-zA-Z0-9]+");

        // Сделать уникальными
        // words = Arrays.stream(words).distinct().toArray(String[]::new);

        // Сортировка через библиотеку Arrays
        Arrays.sort(words);

        // Вывод
        for (String word : words) {
            System.out.println(word);
        }
        
    }

    public static String readFile(String filename) {
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                text += line+'\n';
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return text;
    }
}
