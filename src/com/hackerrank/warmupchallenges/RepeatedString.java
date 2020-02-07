package com.hackerrank.warmupchallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        return s.contains("a") ? countLetterA(s, n) : 0L;
    }

    static long countLetterA(String s, long n) {
        Long totalCount = 0L;
        Long wordACount = 0L;
        Long wordRepeats = n/s.length();
        Long substringRepeats = n%s.length();
        for(int x = 0;x < s.length(); x++) {
            if (s.charAt(x) == 'a') wordACount++;
            if (x < substringRepeats && s.charAt(x) == 'a') totalCount++;
        }
        totalCount = totalCount + (wordRepeats*wordACount);
        return totalCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
