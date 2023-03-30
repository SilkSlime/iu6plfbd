package l6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class e4 {
        
    /**
     * Вариант 2. Задача 6.
     * На плоскости задано N точек. Вывести в файл описания
     * всех прямых, которые проходят более чем через одну
     * точку из заданных. Для каждой прямой указать, через
     * сколько точек она проходит. Использовать класс HashMap.
     */
    public static void main(String[] args) {
        // Создаем список точек
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(5, 6));
        points.add(new Point(7, 8));

        points.add(new Point(1, 3));
        points.add(new Point(2, 4));

        points.add(new Point(1, 4));
        points.add(new Point(2, 3));
        points.add(new Point(3, 2));
        
        // Создаем хэш-таблицу для хранения прямых и количества точек, через которые они проходят
        Map<Line, ArrayList<Point>> linePoints = new HashMap<Line, ArrayList<Point>>();

        // Добавляем все возможные прямые в хэш-таблицу
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                // Проверка на совпадение точек
                if (points.get(i).equals(points.get(j))) {
                    continue;
                }
                // Создаем прямую
                Line line = new Line(points.get(i), points.get(j));
                // Проверяем, есть ли прямая в хэш-таблице
                if (!linePoints.containsKey(line)) {
                    // Если нет, добавляем прямую в хэш-таблицу
                    linePoints.put(line, new ArrayList<Point>());
                    // Добавляем в список точек
                    linePoints.get(line).add(points.get(i));
                    linePoints.get(line).add(points.get(j));
                } else {
                    // Если есть, проверяем, есть ли в списке точек текущая точка
                    if (!linePoints.get(line).contains(points.get(i))) {
                        linePoints.get(line).add(points.get(i));
                    }
                    if (!linePoints.get(line).contains(points.get(j))) {
                        linePoints.get(line).add(points.get(j));
                    }
                }
            }
        }

        // Выводим результат в файл e4.txt в папке l6
        try {
            java.io.FileWriter fw = new java.io.FileWriter("l6/e4.txt");
            // Перебираем все прямые
            for (Map.Entry<Line, ArrayList<Point>> entry : linePoints.entrySet()) {
                // Если точек больше 2, выводим прямую и количество точек, через которые она проходит
                if (entry.getValue().size() > 2) {
                    fw.write(entry.getKey().toString() + " passes through " + entry.getValue().size() + " points.\n");
                }
            }
            // Закрываем файл
            fw.close();
        } catch (Exception e) {
            // Выводим сообщение об ошибке если что-то пошло не так, хах :)
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
 }

// Класс Point для хранения координат точки 
class Point {
    private double x;
    private double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Класс Line для хранения прямой
class Line {
    // Прямая задается уравнением y = slope * x + yIntercept
    // где slope - коэффициент наклона, yIntercept - y-сдвиг
    private double slope;
    private double yIntercept;
    
    public Line(Point p1, Point p2) {
        if (p1.getX() == p2.getX()) {
            // Вертикальная прямая: бесконечный коэффициент наклона, используем x-сдвиг как y-сдвиг
            slope = Double.POSITIVE_INFINITY;
            yIntercept = p1.getX();
        } else {
            // Не вертикальная прямая: вычисляем коэффициент наклона и y-сдвиг
            slope = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
            yIntercept = p1.getY() - slope * p1.getX();
        }
    }
    
    public double getSlope() {
        return slope;
    }
    
    public double getYIntercept() {
        return yIntercept;
    }
    
    public String toString() {
        if (slope == Double.POSITIVE_INFINITY) {
            return "x = " + yIntercept;
        } else {
            return "y = " + slope + "x + " + yIntercept;
        }
    }
    
    // Переопределяем методы equals и hashCode для корректной работы хэш-таблицы
    public boolean equals(Object other) {
        if (other instanceof Line) {
            Line otherLine = (Line) other;
            return slope == otherLine.getSlope() && yIntercept == otherLine.getYIntercept();
        } else {
            return false;
        }
    }
    
    public int hashCode() {
        return Double.hashCode(slope) ^ Double.hashCode(yIntercept);
    }
}