package l1;

public class e1 {

    /**
     * Вариант 1. Задача 3.
     * Создать приложение, выводящее n строк с переходом и без перехода на новую строку.
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Принимается только 1 аргумент, получено: " + args.length);
            return;
        }
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Принимается только целочисленный аргумент");
            return;
        }

        System.out.println("Печать строк без переноса:");
        for (int i = 0; i < n; i++) {
            System.out.print("Это строка!");
        }
        System.out.println("\n\nПечать строк c переносом:");
        for (int i = 0; i < n; i++) {
            System.out.println("Это строка!");
        }
    }
}