package l2;

import java.util.Random;
import java.util.Scanner;

public class e4 {

    /**
     * Вариант 2. Задача 6.
     * Ввести с консоли n – размерность матрицы a[n][n].
     * Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
     * Вычислить норму матрицы.
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
        
        int norm = matrixNorm(a);
        System.out.println("Норма матрицы: " + norm);
    }
    
    public static int matrixNorm(int[][] a) {
        int n = a.length;
        int norm = 0;
        
        for (int j = 0; j < n; j++) {
            int columnSum = 0;
            for (int i = 0; i < n; i++) {
                columnSum += Math.abs(a[i][j]);
            }
            norm = Math.max(norm, columnSum);
        }
        
        return norm;
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