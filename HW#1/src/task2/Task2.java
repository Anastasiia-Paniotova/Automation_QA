package task2;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;


public class Task2 {
    // 2 задача
// реализуйте задачу, которая принимает строку с консоли и вычленяет все символы латиницы/кириллицы и сортирует их,
// указывая количество вхождений каждого символа
    public void run(BufferedReader reader) {
        System.out.println("Type your string: ");
        Scanner input = new Scanner(System.in);
        String inputtedString = input.next();
        StringBuilder newString = new StringBuilder();
        int count = 0;

        Matcher matcher = Pattern.compile("[a-zA-Zа-яА-Я]").matcher(inputtedString);
        while (matcher.find()) {
            newString.append(matcher.group());
        }

        String[] arr = newString.toString().split("");
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i].equals(arr[i - 1])) {
                continue;
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    count++;
                }
            }
            System.out.println("Result: " + arr[i] + " = " + count);
            count = 0;
        }
    }
}
