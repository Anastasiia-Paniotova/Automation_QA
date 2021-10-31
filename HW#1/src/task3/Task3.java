package task3;

import java.util.Scanner;

import java.io.BufferedReader;

// 3 задача
// В некоторой школе занятия начинаются в 9:00. Продолжительность урока — 45 минут, после 1-го, 3-го, 5-го и т.д. уроков перемена 5 минут,
// а после 2-го, 4-го, 6-го и т.д. — 15 минут. Определите, когда заканчивается указанный урок. Данные вводятся с консоли
//
//Входные данные: Дан номер урока (число от 1 до 10).
//Выходные данные: Выведите два целых числа: время окончания урока в часах и минутах.
//
//При решении этой задачи нельзя пользоваться циклами и условными инструкциями!!!!!


public class Task3 {
    public void run(BufferedReader reader) {

        System.out.println("Number of the lesson: ");
        Scanner input = new Scanner(System.in);
        int lessonNumber = input.nextInt();
        int hour = lessonNumber * 45 + lessonNumber / 2 * 5 + (lessonNumber - 1) / 2 * 15;
        int minutes = hour % 60;

        System.out.println("The end of the lesson: ");
        System.out.print(9 + hour / 60 + " " + minutes);

    }
}


