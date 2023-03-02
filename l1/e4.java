package l1;

import java.util.Scanner;
import java.util.Arrays;

public class e4 {

    /**
     * Вариант 2. Задача 2.
     * Ввести с консоли n целых чисел и поместить их в массив.
     * На консоль вывести наибольшее и наименьшее число.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.printf("Введите %d целых чисел:\n", n);
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число: " + max);
    }
}
