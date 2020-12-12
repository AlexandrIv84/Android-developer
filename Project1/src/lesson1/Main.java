package lesson1;

public class Main {
    public static void main(String[] args) {

        byte varByte = -10;             // Задание 2:
        short varShort = 12121;         // переменные всех типов данных
        int varInt = 19000000;          //
        long varLong = -100000L;        //
        float varFloat = 12.34f;        //
        double varDouble = -567.897;    //
        char varChar = 1040;            //
        boolean varBoolean = true;      //

        int a = 3;
        int b = 4;
        int c = 5;
        int d = 2;
        System.out.println("Задание №3. Результат выражения: " + solutionExpression(a, b, c, d)); // Задание №3 решение a * (b + (c / d))
        System.out.println("");

        int varA = 0;
        int varB = 10;
        System.out.println("Задание №4. Результат: " + checkingSumNumber(varA, varB));  //Задание №4 проверка суммы чисел в диапазоне
        System.out.println("");

        int varC = 15;
        System.out.println("Задание №5. Введенное число: "+ positiveOrNegative(varC));  //Задание №5 положительное или отрицательное
        System.out.println("");

        int varD = -17;
        System.out.println("Задание №6. Результат: "+ checkNegative(varD));  //Задание №6 true - если число отрицательное
        System.out.println("");

        String varName = "Андрей";  //Задание №7 вывод приветствия по имени
        printMessage (varName);


    }

    private static float solutionExpression(int a, int b, int c, int d) {
        if (d == 0) {
            System.out.println("Деление на 0 невозможно!");
            return 0;
        }
        return a * (b + ((float)c / d));
    }

    private static boolean checkingSumNumber(int varA, int varB) {
        return ((varA + varB) >= 10) & (varA + varB <=20);
    }

    private static String positiveOrNegative(int varC) {
        if (varC < 0) return "отрицательное";
        else return "положительное";
    }

    private static boolean checkNegative(int varD) {
        return (varD < 0);
    }

    private static void printMessage(String varName) {
        System.out.println("Привет, " + varName + "!");
    }
}
