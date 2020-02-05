import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        return (n == 1) ? 0 : calculatePairs(n, ar);

    }

    static int calculatePairs(int n, int[] ar) {
        AtomicReference<Integer> totalOfPairs = new AtomicReference<>(0);
        Map<Integer, Integer> mapOfPairs = new HashMap<>();
        for(int i=0;i<n;i++) {
            Integer actualQttOfColor = mapOfPairs.getOrDefault(ar[i], 0);
            actualQttOfColor++;
            mapOfPairs.put(ar[i], actualQttOfColor);
        }
        mapOfPairs.forEach((color, qtt) -> {
            totalOfPairs.set(totalOfPairs.get() + (qtt / 2));
        });
        return totalOfPairs.get();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}