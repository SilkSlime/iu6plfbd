package l1;

import java.util.Scanner;

public class e2 {

    /**
     * Вариант 1. Задача 4.
     * Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом.
     */
    public static void main(String[] args) throws Exception {
        String password = "artem";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите пароль: ");
        String inputPassword = scanner.nextLine();
        scanner.close();

        if (inputPassword.equals(password)) {
            System.out.println("Пароль верен!");
        } else {
            System.out.println("Неверный пароль!");
        }
        
    }
}
