package l5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class e8 {

    /**
     * Вариант 4. Задача 6.
     * При выполнении для вывода результатов создавать
     * новую директорию и файл средствами класса File.
     * 
     * Из файла удалить все слова, содержащие от трех
     * до пяти символов, но при этом из каждой строки
     * должно быть удалено только максимальное четное
     * количество таких слов.
     */

    public static void main(String[] args) {
        // Входной и выходной файлы
        String inputFileName = "l5/e8_in.txt";
        String outputFileName = "l5/e8_out.txt";

        try {
            File inputFile = new File(inputFileName);
            File outputFile = new File(outputFileName);

            // Создаем директорию для выходного файла, если она не существует
            File outputDir = outputFile.getParentFile();
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }
            
            // Создаем объекты для чтения и записи (буферизованные потоки)
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        
            String line;
            // Читаем построчно
            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на слова по пробелам и табуляциям (или любым другим пробельным символом)
                String[] words = line.split("\\s+");

                // Считаем количество слов, которые стоит удалить
                int countToDelete = 0;
                for (String word : words) {
                    if (word.length() >= 3 && word.length() <= 5) {
                        countToDelete++;
                    }
                }
                // Удаляем только максимальное четное количество слов
                countToDelete = countToDelete % 2 == 0 ? countToDelete : countToDelete - 1;

                // Удаляем слова
                int deleted = 0;
                // Проходим по всем словам в строке и удаляем нужное количество слов
                for (int i = 0; i < words.length && deleted < countToDelete; i++) {
                    String word = words[i];
                    if (word.length() >= 3 && word.length() <= 5) {
                        // Маркируем слово для удаления (присваиваем null)
                        words[i] = null;
                        deleted++;
                    }
                }

                // Записываем строку в выходной файл
                for (String word : words) {
                    if (word != null) {
                        writer.write(word + " ");
                    }
                }
                writer.write("\n");
            }
            // Закрываем потоки
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}