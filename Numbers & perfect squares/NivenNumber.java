import java.util.*;

public class NivenNumber {
       public static boolean isNivenNumber(int n) {
        int sum=0;
        int temp=n;
        while (temp>0) {
            sum+=temp % 10;
            temp/=10;
        }
        return n%sum==0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        if (isNivenNumber(number)) {
            System.out.println(number + " is a Niven number.");
        } else {
            System.out.println(number + " is not a Niven number.");
        }
    }
}
