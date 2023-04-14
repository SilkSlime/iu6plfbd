package l7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class e5 {

    /**
     * Вариант 3. Задача 5.
     * В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения. 
     */
    public static void main(String[] args) {
        String text = readFile("l7/sometext.txt");
        // Разделитель - знаки конца предложения
        String sentences[] = text.split("[.!?]+");

        String result = "";

        for (String sentence : sentences) {
            String[] words = sentence.trim().split("[^a-zA-Z]+");
            if (words.length == 0) {
                continue;
            } else if (words.length == 1 && words[0].equals("")) {
                continue;
            }

            String temp = words[0];
            words[0] = words[words.length-1];
            words[words.length-1] = temp;

            // rebuild sentence
            String newSentence = "";
            for (String word : words) {
                newSentence += word + " ";
            }
            newSentence = newSentence.trim();
            result += newSentence + ". ";
        }
        
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
