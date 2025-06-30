import java.util.*;

class PerfectNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PerfectNumber obj1 = new PerfectNumber();
        int b = obj1.isPerfect(n);
        if (b == n) {
            System.out.println(n + " is a perfect number");
        } else {
            System.out.println(n + " is not a perfect number");
        }
    }

    int isPerfect(int n) {
        int sum = 1; // Start sum with 1 (since 1 is always a divisor)
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }
}
