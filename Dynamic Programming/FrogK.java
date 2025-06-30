import java.util.*;
class Frogk{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of steps :");
        int n = scanner.nextInt();
        System.out.println("Enter k :");
        int k = scanner.nextInt();
        System.out.println("Enter the height :");
        int[] height = new int[n];
        for(int i=0;i<n;i++){
            height[i] = scanner.nextInt();
        }
        int ans= frog(n,k, height);
        System.out.println("The minimum cost to reach the top is: " + ans);
        scanner.close();
    }
    
    public static int frog(int n,int k, int[] height) {
        int[] dp= new int[n+1];
        dp[0] = 0; // Starting point, no cost
        for(int i=1;i<n;i++){
            dp[i] = Integer.MAX_VALUE; // Initialize to a large value
            for(int j=1;j<=k && i-j>=0;j++){
                dp[i] = Math.min(dp[i], dp[i-j] + Math.abs(height[i] - height[i-j]));
            }
        }
        return dp[n-1]; // Return the cost to reach the top
    }
}
