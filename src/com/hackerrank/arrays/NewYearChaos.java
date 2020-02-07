package com.hackerrank.arrays;

import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int minimumBribes = 0;

        if(personNeedToBribeMoreThanTwoPersons(q)) {
            System.out.println("Too chaotic");
        } else {
            int currentPosition = 0;
                int personCorrectPosition = q[currentPosition] - 1;

            System.out.println(minimumBribes);
        }
    }

    private static Boolean personNeedToBribeMoreThanTwoPersons(int[] q) {
        for(int x = 0; x < q.length; x++) {
            if (!(x >= q[x]-3)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static Boolean notOrdered(int[] q) {
        int[] expected = new int[q.length];
        for(int x=0;x<q.length;x++) expected[x] = x+1;
        for(int x=0;x<q.length;x++) {
            if(q[x] != expected[x]) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static Boolean bribeFrontPerson(int correctPosition, int currentPosition) {
        return currentPosition > correctPosition;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

}

