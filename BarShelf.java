// Last edited 19-04-2020
import java.util.Scanner;

public class BarShelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long counter = 0;
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        if (n >= 3) {
            for (int middle = 1; middle < n - 1; middle++) {
                long leftOf = 0;
                long rightOf = 0;
                for (int left = 0; left < middle; left++) {
                    if (array[left] >= array[middle] * 2) {
                      leftOf++;
                    }
                }
                for (int right = middle+1; right < n; right++) {
                    if (array[middle] >= array[right] * 2) {
                        rightOf++;
                    }
                }
                counter += leftOf * rightOf;
            }
        }
        System.out.println(counter);
    }
}
