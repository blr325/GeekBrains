package java1.lesson2;

public class lesson2 {
    public static void main(String[] args) {
        System.out.println(checkSum(6, 5));
        checkInt(-1);
        System.out.println(isCheckInt(-1));
        printLine("Строка ", 5);
        System.out.println(isCheckLeapYear(2000));
    }

    private static boolean isCheckLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static boolean checkSum(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    private static void checkInt(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else System.out.println("Число отрицательное");
    }

    private static boolean isCheckInt(int a) {
        return a < 0;
    }

    private static void printLine(String line, int num) {
        for (int i = 1; i <= num; ++i) {
            System.out.println(line + i);
        }
    }
}

