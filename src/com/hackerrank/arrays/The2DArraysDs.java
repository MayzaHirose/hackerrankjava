package com.hackerrank.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class The2DArraysDs {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHourglassSum = Integer.MIN_VALUE;
        for(int x = 0; x < 4; x++) {
            for(int y = 0; y < 4; y++) {
                int top = arr[x][y] + arr[x][y+1] + arr[x][y+2];
                int middle = arr[x+1][y+1];
                int bottom = arr[x+2][y] + arr[x+2][y+1] + arr[x+2][y+2];
                int tempSum = top + middle + bottom;
                maxHourglassSum = tempSum > maxHourglassSum ? tempSum : maxHourglassSum;
            }
        }
        return maxHourglassSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
