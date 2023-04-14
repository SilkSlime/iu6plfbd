package l7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class e4 {

    /**
     * Вариант 2. Задача 6.
     * Напечатать без повторения слова текста, у которых первая и последняя буквы совпадают. 
     */
    public static void main(String[] args) {
        String text = readFile("l7/sometext.txt");
        String[] words = text.split("[^a-zA-Z]+");

        // Регекс выражение для проверки одинаковости первой и последней буквы
        // При этом учитывается одинаковость первой и последней буквы в слове:
        // начало строки - ^
        // один любой символ (как первая группа символов) - (.)
        // любое количество любых символов - (.*)
        // первая группа символов - (\\1)
        // конец строки - $
        String regex = "^(.)(.*)(\\1)$";

        // Сет для хранения уникальных слов
        HashSet<String> uniqueWords = new HashSet<>();
        
        for (String word : words) {
            if (word.matches(regex)) {
                uniqueWords.add(word);
            }
        }

        System.out.println("Уникальные слова, у которых первая и последняя буквы совпадают:");
        for (String word : uniqueWords) {
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
