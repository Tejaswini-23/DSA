import java.util.*;
class Sliding3{
    static List<Integer> MaxWindow(int a[],int n,int k){
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer,Integer> tp=new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            tp.put(a[i], tp.getOrDefault(a[i], 0) + 1);
        }
        res.add(tp.firstKey());
        for(int i=1;i<=n-k;i++){
            tp.put(a[i + k - 1], tp.getOrDefault(a[i + k - 1], 0) + 1);
            tp.remove(a[i-1]);
            res.add(tp.firstKey());
        }
        return res;
    }
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println(MaxWindow(a,n,m));
	}

}