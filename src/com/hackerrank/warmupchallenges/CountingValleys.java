package com.hackerrank.warmupchallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    public static final Integer UPHILL = 1;
    public static final Integer DOWNHILL = -1;

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        Integer countingValleys = 0;
        Integer currentLevel = 0;
        Boolean downhill = Boolean.FALSE;
        char[] steps = new char[s.length()];
        for (int i = 0; i < n; i++) {
            steps[i] = s.charAt(i);
        }

        for(int x=0;x<n;x++) {
            if(steps[x] == 'U') {
                if(currentLevel == 0) {
                    downhill = Boolean.FALSE;
                }
                currentLevel = currentLevel + UPHILL;
            } else {
                if(currentLevel == 0) {
                    downhill = Boolean.TRUE;
                }
                currentLevel = currentLevel + DOWNHILL;
            }
            if (currentLevel == 0 && downhill) {
                countingValleys++;
            }
        }
        return countingValleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
