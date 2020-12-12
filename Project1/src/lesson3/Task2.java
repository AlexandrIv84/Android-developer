package lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        System.out.println("Урок 3, Задание №2. Угадай слово");
        System.out.println("Загадано одни из приведенных слов, попробуй угадай его" + Arrays.toString(words));
        StartGame();

    }

    private static void StartGame() {
        int indexWordsInArray = (int) (Math.random() * words.length);
        String word = words[indexWordsInArray];
//        System.out.println(word);
        char[] resultWord = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};

        CheckAnswer(word, resultWord);

    }

    private static void CheckAnswer(String word, char[] resultWord) {

        Scanner scan = new Scanner(System.in);
        String inputword = null;
        do {
            System.out.print("Введите слово:");
            inputword = scan.next();
            if (word.equals(inputword)) {
                break;
            }
            int minLengthWord = inputword.length() < word.length() ? inputword.length() : word.length();
            for (int i = 0; i < minLengthWord; i++) {
                if (word.charAt(i) == inputword.charAt(i)) {
                    resultWord[i] = word.charAt(i);
                }
            }
            System.out.println("Если вы угадали какие-либо буквы, они откроются...Попробуйте вновь!");
            System.out.println(resultWord);

        } while (true);
        System.out.println("Поздравляю, Вы угадали!");

    }
}
