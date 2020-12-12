package lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        invertArray(); //Задание №1. Замена 0 на 1 и наоборот
        System.out.println("");
        fillArray(); //Задание №2. Заполнение массива
        System.out.println("");
        multiplicationArray(); //Задание №3. Умноженние чисел массива меньше 6 на 2
        System.out.println("");
        fillDiagonal(); //Задание №4. Заполнение двумерного массива по диагоналям
        System.out.println("");
        minMaxArray(); //Задание №5. Нахождение минимального и максимального чисел массива

    }

    public static void invertArray() {
        int[] arr = {1, 0, 1, 0, 0, 1, 0, 1, 1};
        System.out.println("Задание №1");
        System.out.println("Заданный масив:        " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("Инвертированный масив: " + Arrays.toString(arr));
    }

    private static void fillArray() {
        System.out.println("Задание №2");
        int[] arr = new int[8];
        int valueArr = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = valueArr;
            valueArr += 3;
        }
        System.out.println("Заполненный массив: " + Arrays.toString(arr));
    }

    private static void multiplicationArray() {
        System.out.println("Задание №3");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Заданный масив:    " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
        System.out.println("Полученный массив: " + Arrays.toString(arr));

    }


    private static void fillDiagonal() {
        System.out.println("Задание №4. Заполнение диагоналей массива единицами");
        int[][] arr = new int[4][4];
        for ( int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i + j == 4-1) || (i == j)) arr[i][j] = 1;
                else arr[i][j] = 0;
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println("");
        }


    }

    private static void minMaxArray() {
        System.out.println("Задание №5. Нахождение максимального и минимального чисел массива");
        int[] arr = {4, 5, 3, 11, 5, 2, 4, 18, 9, 7};
        System.out.println("Заданный масив:    " + Arrays.toString(arr));
        int min = arr[0];
        int max = arr[0];
        for (int i =0; i < arr.length; i++) {

            if (min > arr[i]) min = arr[i];

            if (max < arr[i]) max = arr[i];
        }
        System.out.println("Минимальное число массива: " + min);
        System.out.println("Максимальное число массива: " + max);
    }
}
