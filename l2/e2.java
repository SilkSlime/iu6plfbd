package l2;

import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class e2 {
    
    /**
     * Вариант 1. Задача 6.
     * Ввести n слов с консоли. Найти слово, символы в котором идут в строгом порядке возрастания их кодов.
     * Если таких слов несколько, найти первое из них.
     */

    public static void main(String[] args) {
        String firstAscendingWord = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();

        System.out.printf("Введите %d слов:\n", n);
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            boolean isAscending = true;
            for (int j = 1; j < word.length(); j++) {
                if (word.charAt(j) <= word.charAt(j - 1)) {
                    isAscending = false;
                    break;
                }
            }
            if (isAscending && firstAscendingWord == null) {
                firstAscendingWord = word;
            }
        }
        scanner.close();

        if (firstAscendingWord != null) {
            System.out.println("Слово с символами в порядке возрастания: " + firstAscendingWord);
        } else {
            System.out.println("Нет слов с символами в порядке возрастания");
        }

        
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
}
