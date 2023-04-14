package l7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class e6 {

    /**
     * Вариант 3. Задача 6.
     * В предложении из n слов первое слово поставить на место второго, второе – на место третьего, и т.д., (n-1)-е слово – на место n-го, n-е слово поставить на место первого. В исходном и преобразованном предложениях между словами должны быть или один пробел, или знак препинания и один пробел. 
     */
    public static void main(String[] args) {
        String text = readFile("l7/sometext.txt");
        // Разбить по пробельным символам
        String[] words = text.split("\\s+");
        // Циклический сдвиг массива на 1 элемент вправо
        String[] newWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            newWords[(i+1)%words.length] = words[i];
        }
        // Собрать строку из массива
        String result = String.join(" ", newWords);
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
