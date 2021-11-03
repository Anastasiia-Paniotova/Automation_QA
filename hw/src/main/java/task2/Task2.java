package task2;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.Scanner;

public class Task2 {
    public void run(BufferedReader reader) {
        Map<String, String> dictionary = new HashMap<String, String>();
        Map<String, String> allValues = new HashMap<String, String>();


        System.out.println("Type your word ");
        Scanner scanner = new Scanner(System.in);

        dictionary();

        System.out.println();
        System.out.println("Do you want to add another word?");
        String answer = scanner.nextLine();

        while (answer.equals("yes")) {
            System.out.println("Type your word");
            dictionary();
            System.out.println();
            System.out.println("Do you want to add another word?");
            answer = scanner.nextLine();
        }
        System.out.println(dictionary);
    }

    public static void dictionary() {
        Map<String, String> dictionary = new HashMap<String, String>();
        Scanner scanner = new Scanner(System.in);
        String inputtedWord = scanner.nextLine();
        char[] ch;
        ch = inputtedWord.toCharArray();
        String stringCode = "";
        for (int i = 0; i < ch.length; i++) { // перевод слова в юникод
            int code = (int) ch[i];
            System.out.format("%04X ", code);// форматирование числа как шестнадцатеричное целое число с четырьмя цифрами
            stringCode = code + "";
            dictionary.put(stringCode, inputtedWord);


//            Map<String, String> allValues = new HashMap<String, String>();
//            dictionary.put(stringCode, inputtedWord);
//            allValues.putAll(dictionary);
        }



    }
}

