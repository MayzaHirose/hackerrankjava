package com.hackerrank.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArraysLeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int arrayLength = a.length;
        int[] rotatedArray = new int[arrayLength];
        int currentIndex = 0;
        for(; currentIndex+d < a.length; currentIndex++) {
            rotatedArray[currentIndex] = a[currentIndex+d];
        }
        for(int x = 0; x < d; currentIndex++, x++) {
            rotatedArray[currentIndex] = a[x];
        }
        return rotatedArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        scanner.close();
    }
}
