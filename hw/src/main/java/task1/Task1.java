package task1;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;

import java.util.Scanner;

// пользователь вводит случайный набор строк.
// После этого система просит ввести еще одно ключевое слово и показывает те слова из введенных прежде, которые:
//- начинаются на ключевое слово
//- заканчиваются на ключевое слово
//- имеют общие символы (*)
//- имеют одинаковую последовательность согласных (*)
//- имеют одинаковую последовательность гласных (*)

public class Task1 {
    public void run(BufferedReader reader) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your world/string: ");
        String inputString = scanner.nextLine();
        System.out.println("Type your key: ");
        String keyString = scanner.nextLine();
        StringUtils.lowerCase(inputString); //регистронезависимые строки
        StringUtils.lowerCase(keyString);

        String[] arrInputString = StringUtils.split(inputString); //заносим inputString в массив

//---------------------------------------------------------------------------------------------------------------------
        System.out.println("1.Start with a keyword"); // начинается с ключевого слова
        if (inputString.startsWith(keyString)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


        //        for (int i = 0; i < arrInputString.length; i++) { //вывод слов которые начинаются или заканчиваются на введенное ключевое слово
//            if (arrInputString[i].startsWith(keyString)) {
//                System.out.println("Founded word - " + arrInputString[i]);
//                count++;
//            }
//        }
//        if (count == 0) {System.out.println("Words are not founded. Enter another key word");}
        // случай если слова не найдены

//---------------------------------------------------------------------------------------------------------------------
        System.out.println(); // заканчивается ключевым словом
        System.out.println("2. End with a keyword");
        if (inputString.endsWith(keyString)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
//---------------------------------------------------------------------------------------------------------------------
        System.out.println();         // общие символы
        System.out.println("3. Common symbols");
        if (inputString.contains(keyString)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
//        System.out.println();
//        System.out.println("2. Common symbols");
//        char[] charInputString = inputString.toCharArray(); //создание символьного массива для сравнения
//        char[] charKeyInput = keyString.toCharArray();
//
//        for (int i = 0; i < charKeyInput.length; i++) {       // нахождение общих символов
//            for (int j = 0; j < charKeyInput.length; j++) {
//                if (charInputString[i] == charKeyInput[j]) {
//                    System.out.print(charInputString[i]);
//                }
//            }
//        }
//
//---------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("4.The same consonant sequence"); // порядок гласных

        String stringWithoutConsonant;
        stringWithoutConsonant = inputString.replaceAll("[aeiouy]+", "");

        String keyStringWithoutConsonant;
        keyStringWithoutConsonant = keyString.replaceAll("[aeiouy]+", "");

        if (stringWithoutConsonant.contains(keyStringWithoutConsonant)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        //        StringBuilder stringWithoutConsonant = new StringBuilder(); //выбор только согласных букв в введенной строке
//        Matcher matcher = Pattern.compile("[^aeiouy]").matcher(inputString);
//        while (matcher.find()) {
//            stringWithoutConsonant.append(matcher.group());
//        }
//        System.out.println(stringWithoutConsonant);

//        StringBuilder keyStringWithoutConsonant = new StringBuilder(); // выбор только согласных букв в ключевом слове
//        matcher = Pattern.compile("[^aeiouy]").matcher(keyString);
//        while (matcher.find()) {
//            keyStringWithoutConsonant.append(matcher.group());
//        }
//        System.out.println(keyStringWithoutConsonant);
//

//// ---------------------------------------------------------------------------------------------

        System.out.println();
        System.out.println("5. The same vowel sequence");
        ; // порядок согласных
        String stringWithConsonant;
        stringWithConsonant = inputString.replaceAll("[^aeiouy]+", "");
        //     System.out.println(stringWithConsonant);

        String keyStringWithConsonant;
        keyStringWithConsonant = keyString.replaceAll("[^aeiouy]+", "");
        //       System.out.println(keyStringWithConsonant);

        if (stringWithConsonant.contains(keyStringWithConsonant)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


    }
}