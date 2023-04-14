package l7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class e2 {

    /**
     * Вариант 1. Задача 6.
     * После каждого слова текста, заканчивающегося заданной подстрокой, вставить указанное слово. 
     */
    public static void main(String[] args) {
        String text = readFile("l7/sometext.txt");
        String subs = "lorem";
        String word = "IPSUM!!";

        String result = text.replaceAll("(?i)("+subs+")\\b", "$1 "+word);

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
