import java.util.*;
import java.io.*;
class NthCatalog{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();
        scanner.close();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        if (n >= 1) dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println("The " + n + "th Catalan number is: " + dp[n]);
    }

}