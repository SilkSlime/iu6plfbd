package l7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class e1 {

    /**
     * Вариант 1. Задача 5.
     * В тексте после k-го символа вставить заданную подстроку.
     */
    public static void main(String[] args) {
        String text = readFile("l7/sometext.txt");
        String subs = "-=-Hello, world!-=-";
        int k = 5;
        String result = text.substring(0, k) + subs + text.substring(k);
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
