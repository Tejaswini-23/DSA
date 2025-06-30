import java.util.*;
public class LongSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        System.out.println("Enter the elements of the array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Length of the longest subarray is: " + longestSubArray(arr, n));
    }
    public static int longestSubArray(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, sum = 0;
        map.put(0, -1); // sum 0 at index -1

        for (int i = 0; i < arr.length; i++) {
            // Replace 0 with -1
            sum += (arr[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}


