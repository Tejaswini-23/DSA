import java.util.*;
class Frogjump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of steps :");
        int n = scanner.nextInt();
        System.out.println("Enter the height :");
        int[] height = new int[n];
        for(int i=0;i<n;i++){
            height[i] = scanner.nextInt();
        }
        int ans= frog(n, height);
        System.out.println("The minimum cost to reach the top is: " + ans);
        scanner.close();
    }
    public static int frog(int n, int[] height) {
        int[] dp= new int[n+1];
        dp[2] = Math.abs(height[1] - height[0]);
        for(int i=3;i<=n;i++){
            dp[i] = Math.min(dp[i-1] + Math.abs(height[i-1] - height[i-2]), dp[i-2] + Math.abs(height[i-1] - height[i-3]));
        }
        return dp[n];

    }
}