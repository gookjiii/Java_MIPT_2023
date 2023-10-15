import java.io.*;
import java.util.*;

public class Main {
    private int ceilIndex(int input[], int T[], int end, int s) {
        int start = 0;
        int len = end;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (middle < len && input[T[middle]] < s && s <= input[T[middle + 1]]) {
                return middle + 1;
            } else if (input[T[middle]] < s) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public void findLongestNonIncreasingSubsequence(int input[]) {
        int n = input.length;
        int T[] = new int[n];
        int R[] = new int[n];
        Arrays.fill(R, -1);
        T[0] = 0;
        int len = 0;

        for (int i = 1; i < n; i++) {
            if (input[T[0]] > input[i]) {
                T[0] = i;
            } else if (input[T[len]] <= input[i]) {
                len++;
                T[len] = i;
                R[T[len]] = T[len - 1];
            } else {
                int index = ceilIndex(input, T, len, input[i]);
                T[index] = i;
                R[T[index]] = T[Math.max(index - 1,0)];
            }
        }

        System.out.println(len + 1);

        int index = T[len];
        while (index != -1) {
            System.out.print((n - index) + " ");
            index = R[index];
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] elements = br.readLine().split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(elements[Math.max(0,n - 1 - i)]);
        }
        
        Main lnis = new Main();
        lnis.findLongestNonIncreasingSubsequence(A);
    }
}
