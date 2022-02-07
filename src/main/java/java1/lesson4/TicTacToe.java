package java1.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '•';
    private static final int SIZE = 5;

    private static char[][] MAP;
    private static Scanner scanner;
    private static Random random;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkEndGame(DOT_X)) {
                return;
            }

            aiTurn();
            printMap();
            if (checkEndGame(DOT_O)) {
                return;
            }
        }

    }

    private static void getWinMessage(char symbol) {
        if (symbol == DOT_X) {
            System.out.println("Победил человек");
        }
        if (symbol == DOT_O) {
            System.out.println("Победил компьютер");
        }
    }

    private static boolean checkEndGame(char symbol) {
        if (isWin(DOT_X)) {
            getWinMessage(DOT_X);
            return true;
        }
        if (isWin(DOT_O)) {
            getWinMessage(DOT_O);
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    private static boolean isWin(char symbol) {
        if (SIZE == 3) {
            for (int x = 0; x < SIZE; x++) {
                int lineX = 0;
                int lineY = 0;
                for (int y = 0; y < SIZE; y++) {
                    lineX = (MAP[x][y] == symbol) ? lineX + 1 : 0;
                    lineY = (MAP[y][x] == symbol) ? lineY + 1 : 0;
                    if (lineX == SIZE || lineY == SIZE) {
                        return true;
                    }
                }
            }
            int diagonalLeft = 0;
            int diagonalRight = 0;
            for (int i = 0; i < SIZE; i++) {
                diagonalLeft = (MAP[i][i] == symbol) ? diagonalLeft + 1 : 0;
                diagonalRight = (MAP[i][SIZE - 1 - i] == symbol) ? diagonalRight + 1 : 0;
                if (diagonalLeft == SIZE || diagonalRight == SIZE) {
                    return true;
                }
            }
        }
        if (SIZE == 5) {
            for (int x = 0; x < SIZE; x++) {
                int lineX = 0;
                int lineY = 0;
                for (int y = 0; y < SIZE; y++) {
                    lineX = (MAP[x][y] == symbol) ? lineX + 1 : 0;
                    lineY = (MAP[y][x] == symbol) ? lineY + 1 : 0;
                    if (lineX == SIZE - 1 || lineY == SIZE - 1) {
                        return true;
                    }
                }
            }
            int diagonalLeft = 0;
            int diagonalRight = 0;

            for (int i = 0; i < SIZE; i++) {
                diagonalLeft = (MAP[i][i] == symbol) ? diagonalLeft + 1 : 0;
                diagonalRight = (MAP[i][SIZE - 1 - i] == symbol) ? diagonalRight + 1 : 0;
                if (diagonalLeft == SIZE - 1 || diagonalRight == SIZE - 1) {
                    return true;
                }
            }
        }
       /* if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;

        // check columns
        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;

        // check diagonals
        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
        if (map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) return true;
        return false;*/
        return false;
    }

    private static boolean isMapFull() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (isEmptyCell(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isEmptyCell(int x, int y) {
        return MAP[x][y] == DOT_EMPTY;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isEmptyCell(x, y));
        MAP[x][y] = DOT_O;
        System.out.println("Компьютер ввел координаты " + x + " и " + y + ":");
    }

    private static void humanTurn() {

        System.out.println("Введите координаты Х и Y:");
        int x = 0;
        int y = 0;
        do {
            x = readIndex();
            y = readIndex();

            if (!checkRange(x) || !checkRange(y)) {
                System.out.println("Значение координат должно быть от 1 до " + SIZE + " , повторите попытку:");
                continue;
            }
            if (isEmptyCell(x - 1, y - 1)) {
                break;
            } else {
                System.out.println("Эта клетка занята. Повторите попытку");

            }
        } while (true);
        MAP[x - 1][y - 1] = DOT_X;
    }


    private static boolean checkRange(int index) {
        return index > 0 && index <= SIZE;
    }

    private static int readIndex() {
        while (!scanner.hasNextInt()) {
            System.out.println("Введите целочисленное число:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void printMap() {
        printNumberColumn();
        printRow();
    }

    private static void printRow() {
        for (int x = 0; x < SIZE; x++) {
            System.out.print((x + 1) + " ");
            for (int y = 0; y < SIZE; y++) {
                System.out.print(MAP[x][y] + " ");
            }
            System.out.println();
        }
    }

    private static void printNumberColumn() {
        for (int numY = 0; numY <= SIZE; numY++) {
            System.out.print(numY + " ");
        }
        System.out.println();
    }

    private static void initMap() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(MAP[i], DOT_EMPTY);
        }
    }
}