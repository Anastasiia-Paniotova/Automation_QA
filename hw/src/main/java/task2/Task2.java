package task2;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.Scanner;

public class Task2 {
    Map<String, String> dictionary = new HashMap<>();

    public void run(BufferedReader reader) {

        System.out.println("Type your word ");
        Scanner scanner = new Scanner(System.in);

        writeToDictionary();

        System.out.println();
        System.out.println("Do you want to add another word?");
        String answer = scanner.nextLine();

        while (answer.equals("yes")) {
            System.out.println("Type your word");
            writeToDictionary();
            System.out.println();
            System.out.println("Do you want to add another word?");
            answer = scanner.nextLine();
        }
        System.out.println(dictionary);
    }

    void writeToDictionary() {  // метод для перевода слова в юникод + записи в словарь
        Scanner scanner = new Scanner(System.in);
        String inputtedWord = scanner.nextLine();
        char[] ch = inputtedWord.toCharArray();
        String stringCode = "";
        for (int i = 0; i < ch.length; i++) { // перевод слова в юникод
            int code = (int) ch[i];
            System.out.format("%04X ", code);// форматирование числа как шестнадцатеричное целое число с четырьмя цифрами
            stringCode += code + " ";
        }
        dictionary.put(stringCode, inputtedWord);


    }
}

