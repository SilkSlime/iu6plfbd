package l7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class e3 {

    /**
     * Вариант 2. Задача 5.
     * В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой. 
     */
    public static void main(String[] args) {
        String text = readFile("l7/sometext.txt");
        // Разделитель - любой символ, кроме буквы
        String words[] = text.split("[^a-zA-Z]+");

        int count = 0;
        for (String word : words) {
            // Объяснение шалона:
            // ^ - начало строки
            // [aeiouyAEIOUY] - любая гласная буква
            // .* - любое количество любых символов
            // [aeiouyAEIOUY]$ - любая гласная буква в конце строки
            if (word.matches("^[aeiouyAEIOUY].*[aeiouyAEIOUY]$")) {
                count++;
                // System.out.println(word);
            }
        }
        
        System.out.println("Количество слов, начинающихся и заканчивающихся гласной буквой: " + count);
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
