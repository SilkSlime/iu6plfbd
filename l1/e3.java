package l1;

import java.util.Scanner;

public class e3 {

    /**
     * Вариант 2. Задача 1.
     * Ввести с консоли n целых чисел и поместить их в массив.
     * На консоль вывести четные и нечетные числа.
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

        System.out.println("Нечетные числа:");
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        System.out.println("Четные числа:");
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
