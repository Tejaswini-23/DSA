public class NthCrRec {
    public static int findCatalan(int n) {
        if (n <= 1) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += findCatalan(i) * findCatalan(n - i - 1);
        }
        return res;
    }
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();
        scanner.close();
        int result = findCatalan(n);
        System.out.println("The " + n + "th Catalan number is: " + result);
    }
}
