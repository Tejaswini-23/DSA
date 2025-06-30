import java.util.*;

public class Sliding5 {
    static int max(int a[],int n,int x)
    {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int res=0,wsum=0;
        for(int i=0;i<n;i++)
        {
            wsum=wsum+a[i];
            if(wsum==x)
            {
                res=i+1;
            }
            if(hm.containsKey(wsum-x))
            {
                res=Math.max(res,i-hm.get(wsum-x));
            }
            if(!hm.containsKey(wsum))
            {
                hm.put(wsum,i);
            }
        }
        return res;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println(max(a,n,x));
    }

}
