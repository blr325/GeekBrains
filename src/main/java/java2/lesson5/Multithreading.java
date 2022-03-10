package java2.lesson5;

import java.util.Arrays;

public class Multithreading {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr1 = createArray();
        float[] arr2 = createArray();
        firstMethod(arr1);
        secondMethod(arr2);
        System.out.println("Массивы равны ? " + (Arrays.equals(arr1, arr2)));
    }

    static void firstMethod(float[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = computeValue(arr[i], i);
        }
        System.out.println("Время выполнения последовательного метода " + (System.currentTimeMillis() - start) + " мс.");
    }

    static void secondMethod(float[] arr) throws InterruptedException {
        float[] arrTemp1 = Arrays.copyOfRange(arr, 0, H);
        float[] arrTemp2 = Arrays.copyOfRange(arr, H, arr.length);
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arrTemp1.length; i++) {
                arrTemp1[i] = computeValue(arrTemp1[i], i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < arrTemp2.length; i++) {
                arrTemp2[i] = computeValue(arrTemp2[i], i + H);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(arrTemp1, 0, arr, 0, H);
        System.arraycopy(arrTemp2, 0, arr, H, H);
        System.out.println("Время выполнения паралельного метода " + (System.currentTimeMillis() - start) + " мс.");
    }

    private static float computeValue(float value, int index) {
        return (float) (value * Math.sin(0.2f + index / 5.0) * Math.cos(0.2f + index / 5.0) * Math.cos(0.4f + index / 2.0));
    }

    private static float[] createArray() {
        float[] arr = new float[Multithreading.SIZE];
        Arrays.fill(arr, 1.0f);
        return arr;
    }
}
