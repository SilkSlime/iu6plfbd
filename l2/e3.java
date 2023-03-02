package l2;

import java.util.Random;
import java.util.Scanner;

public class e3 {

    /**
     * Вариант 2. Задача 5.
     * Ввести с консоли n – размерность матрицы a[n][n].
     * Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
     * Транспонировать квадратную матрицу.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int n = scanner.nextInt();
        scanner.close();
        int[][] a = new int[n][n];
        
        Random random = new Random();
        int range = n * 2 + 1;
        int min = -n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextInt(range) + min;
            }
        }
        
        System.out.println("Полученная матрица:");
        printMatrix(a);
        
        transpose(a);
        
        System.out.println("Транспонированная матрица:");
        printMatrix(a);
    }
    
    public static void transpose(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }
    
    public static void printMatrix(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
    }
}