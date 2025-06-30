import java.util.*;
public class BinoCo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values of n and k for the binomial coefficient C(n, k):");
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();
        System.out.println("The binomial coefficient C(" + n + ", " + k + ") is: " + binomialCoefficientDP(n, k));
    }
    public static int binomialCoefficient(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }
    public static int binomialCoefficientDP(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }
}
