package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static final int SIZE_FIELD = 6;    // Размер Игрового поля
    static final int WIN_LINE = 4;    // Количество фишек подряд, для победы
    static final int EDGE_MAP = SIZE_FIELD - 1; //Границы игрового поля в массиве

    static final char CHIP_HUMAN = 'X';
    static final char CHIP_AI = 'O';
    static final char CHIP_EMPTY = '•';

    static final char HEADER_FIRST_SYMBOL = '☻';
    static final String EMPTY = " ";
    static int turnsCount;

    static final char[][] FIELD = new char[SIZE_FIELD][SIZE_FIELD];
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {
        turnGame();
    }


    public static void turnGame() {
        initField();

        printField();

        playGame();
    }


    private static void initField() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                FIELD[i][j] = CHIP_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.println();
        printHeadField();
        printBodyField();
    }

    private static void printHeadField() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE_FIELD; i++) {
            printMapNumbers(i);
        }
        System.out.println();
    }

    private static void printMapNumbers(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printBodyField() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            printMapNumbers(i);
            for (int j = 0; j < SIZE_FIELD; j++) {
                System.out.print(FIELD[i][j] + EMPTY);
            }
            System.out.println();
        }
    }


    private static void playGame() {

        turnsCount = 0;
        while (true) {
            humanTurn();
            printField();
            checkEnd(CHIP_HUMAN);

            aiTurn();
            printField();
            checkEnd(CHIP_AI);

        }
    }

    private static void humanTurn() {
        int rowNumber;
        int columnNumber;
        boolean isInputValid = true;

        System.out.println("\nХодит игрок! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            columnNumber = -1;

            System.out.print("Введите номер строки:  ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;

            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Введите номер столбца:  ");
            if (in.hasNextInt()) {
                columnNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }
        } while (!(isInputValid && isHumanValidTurn(rowNumber, columnNumber)));

        FIELD[rowNumber][columnNumber] = CHIP_HUMAN;
    }

    private static void processingIncorrectInput() {
        in.next();
        System.out.println("Введите число!");
    }

    private static boolean isHumanValidTurn(int rowNumber, int columnNumber) {

        if (!isNumbersValid(rowNumber, columnNumber)) {
            System.out.println("\nВы ввели ячейку за пределами поля");
            return false;
        } else if (!isCellOccupancy(rowNumber, columnNumber)) {
            System.out.println("\nЯчейка занята, выберите другую");
            return false;
        }

        return true;
    }

    private static boolean isNumbersValid(int rowNumber, int columnNumber) {
        return !(rowNumber > SIZE_FIELD || rowNumber < 0 || columnNumber > SIZE_FIELD || columnNumber < 0);
    }

    private static boolean isCellOccupancy(int rowNumber, int columnNumber) {
        return FIELD[rowNumber][columnNumber] == CHIP_EMPTY;
    }

    private static void checkEnd(char symbol) {
        boolean isEnd = false;

        if (checkWin(symbol)) {
            isEnd = true;
            String winMessage;

            if (symbol == CHIP_HUMAN) {
                winMessage = "Вы победили!";
            } else {
                winMessage = "Победил компьютер :(";
            }

            System.out.println(winMessage);
        }

        if (!isEnd && isMapFullByTurnsCount()) {
            System.out.println("Ничья!");
            isEnd = true;
        }

        if (isEnd) {
            System.exit(0);
        }
    }

    private static boolean checkWin(char symbol) {

        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                if (FIELD[i][j] == symbol) {
                    int accumulation = 1; // Переменная для накопления победной линии

                    if (CheckHorizont(i, j, symbol, accumulation)) return true;         // Проверки различных вариантов победы
                    if (CheckVertical(i, j, symbol, accumulation)) return true;         // по горизонтали, по вертикали
                    if (CheckRightDiagonal(i, j, symbol, accumulation)) return true;    // и по диагоналям
                    if (CheckLeftDiagonal(i, j, symbol, accumulation)) return true;     //

                }
            }
        }
        return false;
    }


    private static boolean CheckHorizont(int i, int j, char symbol, int accumulation) {     //Проверка горизонтали
        while (accumulation > 0 && j < EDGE_MAP) {
            j++;
            if (FIELD[i][j] == symbol) accumulation++;
            else accumulation = 1;
            if (accumulation == WIN_LINE) {
                return true;
            }
        }
        return false;
    }


    private static boolean CheckVertical(int i, int j, char symbol, int accumulation) {     //Проверка вертикали
        while (accumulation > 0 && i < EDGE_MAP) {
            i++;
            if (FIELD[i][j] == symbol) accumulation++;
            else accumulation = 1;
            if (accumulation == WIN_LINE) return true;
        }
        return false;
    }


    private static boolean CheckRightDiagonal(int i, int j, char symbol, int accumulation) {    //Проверка диагонали вправо
        while (accumulation > 0 && i < EDGE_MAP && j < EDGE_MAP) {
            i++;
            j++;
            if (FIELD[i][j] == symbol) accumulation++;
            else accumulation = 0;
            if (accumulation == WIN_LINE) return true;
        }
        return false;
    }

    private static boolean CheckLeftDiagonal(int i, int j, char symbol, int accumulation) {     //Проверка диагонали влево
        while (accumulation > 0 && i < EDGE_MAP && j > 0) {
            i++;
            j--;
            if (FIELD[i][j] == symbol) accumulation++;
            else accumulation = 0;
            if (accumulation == WIN_LINE) return true;
        }
        return false;
    }


    private static boolean isMapFull() {

        for (char[] chars : FIELD) {
            for (char symbol : chars) {
                if (symbol == CHIP_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isMapFullByTurnsCount() {
        return ++turnsCount == SIZE_FIELD * SIZE_FIELD;
    }

    private static void aiTurn() {
        int rowNumber;
        int columnNumber;

        System.out.println("\nХод компьютера!");
        do {
            rowNumber = random.nextInt(SIZE_FIELD);
            columnNumber = random.nextInt(SIZE_FIELD);
        } while (!isCellOccupancy(rowNumber, columnNumber));

        FIELD[rowNumber][columnNumber] = CHIP_AI;

    }
}
