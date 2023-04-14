package l5;

public class e1 {
    
    /**
     * Из 3й лабы. Вариант 1. Задача 5.
     * Определить класс Матрица размерности (m x n). Класс должен содержать
     * несколько конструкторов. Объявить массив объектов. Передать объекты
     * в метод, меняющий местами строки с максимальным и минимальным элементами
     * k-го столбца. Создать метод, который изменяет i-ю матрицу путем
     * возведения ее в квадрат.
     * 
     * Выполнить задание контролируя состояние потоков ввода/вывода.
     * При возникновении ошибок, связанных с корректностью выполнения
     * математических операций, генерировать и обрабатывать исключительные
     * ситуации. Предусмотреть обработку исключений, возникающих при
     * нехватке памяти, отсутствии требуемой записи (объекта) в файле,
     * недопустимом значении поля и т.д.
     */

    public static void main(String[] args) {
        // Define an array of matrixes and fill it using constructors
        Matrix[] matrixes = new Matrix[3];
        matrixes[0] = new Matrix(3, 3);
        matrixes[1] = new Matrix(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        matrixes[2] = new Matrix(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        matrixes[1].print();
        System.out.println();

        // Change rows with max and min elements of k-th column
        matrixes[1].changeRowsMinMaxOfK(1);
        matrixes[1].print();
        System.out.println();

        // Change i-th matrix by squaring it
        matrixes[1].square(1, matrixes);        
        matrixes[1].print();
        System.out.println();

    }
}

// Define class Matrix with size (m x n) and two constructors
class Matrix {
    private int m;
    private int n;
    private int[][] matrix;
    
    public Matrix(int m, int n) {
        // Выбрасываем исклчение, если размерность матрицы меньше 1
        if (m < 1 || n < 1) {
            throw new IllegalArgumentException("Matrix size must be greater than 1");
        }

        this.m = m;
        this.n = n;
        matrix = new int[m][n];
    }
    
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
    }

    // Method for printing matrix using System.out.println()
    public void print() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                System.out.printf("%4d", this.matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    // Method for changing rows with max and min elements of k-th column
    public void changeRowsMinMaxOfK(int k) {
        // Выбрасываем исклчение, если k больше размерности матрицы или меньше 0
        if (k > this.n || k < 0) {
            throw new IllegalArgumentException("k must be less than matrix size and greater than 0");
        }
        int max = matrix[0][k];
        int min = matrix[0][k];
        int maxRow = 0;
        int minRow = 0;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][k] > max) {
                max = matrix[i][k];
                maxRow = i;
            }
            if (matrix[i][k] < min) {
                min = matrix[i][k];
                minRow = i;
            }
        }
        
        int[] temp = matrix[maxRow];
        matrix[maxRow] = matrix[minRow];
        matrix[minRow] = temp;
    }
    
    // Method for changing i-th matrix by squaring it
    public void square(int i, Matrix[] matrixes) {
        // Выбрасываем исклчение, если i больше размерности массива или меньше 0
        if (i > matrixes.length || i < 0) {
            throw new IllegalArgumentException("i must be less than matrixes array size and greater than 0");
        }
        int[][] temp = matrixes[i].matrix;
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                temp[j][k] *= temp[j][k];
            }
        }
        matrixes[i].matrix = temp;
    }

}
