package org.example;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class Main {
    public static void main(String[] args) {
        // Грузим файл из resources/rotten_tomatoes_movies.csv
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config("spark.master", "local")
                .getOrCreate();
        // Создаем датасет из csv файла
        Dataset<Row> df = spark.read().option("header","true").csv("src/main/resources/rotten_tomatoes_movies.csv");
        // Создаем временную таблицу rtm
        df.createOrReplaceTempView("rtm");
        // Заголовки в csv файле:
        // id,title,audienceScore,tomatoMeter,rating,ratingContents,releaseDateTheaters,releaseDateStreaming,runtimeMinutes,genre,originalLanguage,director,writer,boxOffice,distributor,soundMix
        // Используем SQL и .show() для 10 примеров выборки и аггрегации
        // Example 1: Выбрать все фильмы с рейтингом > 4
        spark.sql("SELECT * FROM rtm WHERE rating = 5 AND tomatoMeter = 100").show();
        // Example 2: Выбрать все фильмы с рейтингом > 4 и рейтингом критиков > 90
        spark.sql("SELECT * FROM rtm WHERE rating = 5 AND tomatoMeter = 100 AND audienceScore = 100").show();
        // Example 3: Выбрать все фильмы с жанром "Comedy"
        spark.sql("SELECT * FROM rtm WHERE genre LIKE '%Comedy%'").show();
        // Example 4: Аггрегировать по жанрам и посчитать количество фильмов в каждом жанре. Сортировать по убыванию
        spark.sql("SELECT genre, COUNT(*) FROM rtm GROUP BY genre ORDER BY COUNT(*) DESC").show();
        // Example 5: Вывести жанры 10 самых плохих фильмов
        spark.sql("SELECT genre FROM rtm ORDER BY tomatoMeter ASC LIMIT 10").show();
        // Example 6: Вывести средний рейтинг фильмов по жанрам
        spark.sql("SELECT genre, AVG(tomatoMeter) FROM rtm GROUP BY genre ORDER BY AVG(tomatoMeter) DESC").show();
        // Example 7: Вывести средний рейтинг фильмов по жанрам, у которых рейтинг критиков > 90
        spark.sql("SELECT genre, AVG(tomatoMeter) FROM rtm WHERE tomatoMeter > 90 GROUP BY genre ORDER BY AVG(tomatoMeter) DESC").show();
        // Example 8: Вывести количество фильмов по годам (использовать из releaseDateTheaters первые 4 символа)
        spark.sql("SELECT SUBSTRING(releaseDateTheaters, 1, 4) AS year, COUNT(*) FROM rtm GROUP BY year ORDER BY year").show();
        // Example 9: Вывести года по убыванию среднего рейтинга фильмов
        spark.sql("SELECT SUBSTRING(releaseDateTheaters, 1, 4) AS year, AVG(tomatoMeter) FROM rtm GROUP BY year ORDER BY AVG(tomatoMeter) DESC").show();
        // Example 10: Вывести количество фильмов по годам и жанрам
        spark.sql("SELECT SUBSTRING(releaseDateTheaters, 1, 4) AS year, genre, COUNT(*) FROM rtm GROUP BY year, genre ORDER BY year, genre").show();


    }
}