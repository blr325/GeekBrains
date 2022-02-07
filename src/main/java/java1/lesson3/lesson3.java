package java1.lesson3;

import java.util.Arrays;
import java.util.Random;

public class lesson3 {
    static Random random = new Random();

    public static void main(String[] args) {

        changeOneToZero();
        initArray();
        increaseNumbers();
        createSquareArray();
        System.out.println("Создали одномерный массив: " + Arrays.toString(createArray(5, 10)));
        findMinAndMax();
        int[] array = {10, 1, 2, 2, 2, 2, 2, 1};
        System.out.println(isCheckBalance(array));
    }


    private static void changeOneToZero() {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(2);
        }
        System.out.println("Исходный массив\n" + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        System.out.println("Поменяли местами 0 и 1\n" + Arrays.toString(array));
    }

    private static void initArray() {
        int[] emptyArray = new int[100];
        for (int i = 0; i < emptyArray.length; i++) {
            emptyArray[i] = random.nextInt(100);
        }
        System.out.println("Заполнили массив значениями: " + Arrays.toString(emptyArray));
    }

    private static void increaseNumbers() {
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] < 6 ? numbers[i] *= 2 : numbers[i];
        }
        System.out.println("Числа меньше 6 умножили на 2: " + Arrays.toString(numbers));
    }

    private static void createSquareArray() {
        System.out.println("Создали двумерный квадратный массив с главными диагоналями:");
        int[][] squareArray = new int[6][6];
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray[i].length; j++) {
                if (i == j || i + j == squareArray[i].length - 1) {
                    System.out.print("Х" + " ");
                } else System.out.print(squareArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    private static void findMinAndMax() {
        int[] array = {3, 6, 4, -4, 9, 7, 10, 1};
        int numberMin = array[0], numberMax = array[0];
        int indMin = 0, indMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > numberMax) {
                numberMax = array[i];
                indMax = i;
            }
            if (array[i] < numberMin) {
                numberMin = array[i];
                indMin = i;
            }
        }
        System.out.printf("Минимальный элемент в массиве под индексом %d = %d\n", indMin, numberMin);
        System.out.printf("Максимальный элемент в массиве под индексом %d = %d\n", indMax, numberMax);
    }

    private static boolean isCheckBalance(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int j : array) {
            sumRight = sumRight + j;
        }
        for (int j : array) {
            if ((sumLeft = sumLeft + j) == (sumRight = sumRight - j)) {
                return true;
            }
        }
        return false;
    }

}


