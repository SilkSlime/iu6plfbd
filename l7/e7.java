package l7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class e7 {

    /**
     * Вариант 4. Задача 5.
     * Заменить все одинаковые рядом стоящие символы в тексте одним символом.
     */
    public static void main(String[] args) {
        String text = readFile("l7/sometext.txt");
        
        // Заменить все одинаковые рядом стоящие символы в тексте одним символом.
        String result = text.replaceAll("(.)\\1+", "$1");
        System.out.println(result);

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
