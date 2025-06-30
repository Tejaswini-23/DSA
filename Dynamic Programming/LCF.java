import java.util.*;
public class LCF {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine(); // Consume the newline character
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLine();
        }
        Arrays.sort(arr);
        String s1 = arr[0];
        String s2 = arr[n-1];
        int i=0;
        while(s1.length() > i && s2.length() > i && s1.charAt(i) == s2.charAt(i)){
            i++;
        }
        System.out.println("Longest common prefix: " + s1.substring(0, i));
        sc.close();        
    }
}
