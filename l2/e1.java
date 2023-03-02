package l2;

import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class e1 {
    
    /**
     * Вариант 1. Задача 5.
     * Ввести n слов с консоли. Найти количество слов, содержащих только символы латинского алфавита,
     * а среди них – количество слов с равным числом гласных и согласных букв.
     */

    public static void main(String[] args) {
        int latinWordsCount = 0;
        int equalVowelsConsonantsCount = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();


        System.out.printf("Введите %d слов:\n", n);
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            if (isLatin(word)) {
                latinWordsCount++;
                if (hasEqualVowelsConsonants(word)) {
                    equalVowelsConsonantsCount++;
                }
            }
        }
        scanner.close();


        System.out.println("Число слов только с латинскими буквами: " + latinWordsCount);
        System.out.println("Число слов только с латинскими буквами, которые имеют равное число гласных и согласных: " + equalVowelsConsonantsCount);


        System.out.println("Разработчик: Панфилкин А.М.");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 17);
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 39);
        cal.set(Calendar.SECOND, 0);
        
        Date taskDate = cal.getTime();
        System.out.println("Дата получения задания: " + taskDate.toString());
        Date currentDate = new Date();
        System.out.println("Дата сдачи задания: " + currentDate.toString());

    }

    private static boolean isLatin(String word) {
        return word.matches("[a-zA-Z]+");
    }

    private static boolean hasEqualVowelsConsonants(String word) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }
        return vowelCount == consonantCount;
    }
}
