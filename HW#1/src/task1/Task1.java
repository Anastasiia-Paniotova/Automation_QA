package task1;

import java.io.BufferedReader;
import java.util.Scanner;
import java.lang.Integer;
//         1 задача
//        реализуйте задачу, которая принимает строку с консоли и вычленяет все числа и находит их сумму

public class Task1 {
    public void run(BufferedReader reader) {

        System.out.println("Type your string:");
        Scanner input = new Scanner(System.in);
        String str = input.next();

        int sum = 0;
        str = str.replaceAll("\\D+", "");

        String[] arr = str.split("");

        int[] numArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
            sum += numArr[i];
        }
        System.out.println("Sum is " + sum);

    }
}
