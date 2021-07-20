import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr) {

        if (arr == null || arr.length == 0)
            return 0;
        else if (arr.length == 1)
            return arr[0];

        int maxSum = arr[0];
        int maxTillNow = arr[0];
        for (int i = 1; i < arr.length; i++) {

            if (maxTillNow > 0)
                maxTillNow = maxTillNow + arr[i];
            else {
                maxTillNow = arr[i];
            }
            maxSum = Math.max(maxSum, maxTillNow);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}