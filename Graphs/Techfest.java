import java.util.*;
public class Techfest {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int Q=sc.nextInt();
        sc.nextLine();
        int[] parent = new int[N+1];
        int s[]=new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i; // Initialize each element to be its own parent
            s[i] = 1; // Initialize size of each set to 1
        }
        for(int i=0;i<Q;i++){
            String ch[]=sc.nextLine().split(" ");
            if(ch[0].equals("Q")){
                int ans=getTotal(parent,s,Integer.parseInt((ch[1])));
                System.out.println(ans);
            }
            else{
                int a=Integer.parseInt(ch[1]);
                int b=Integer.parseInt(ch[2]);
                union(parent, s, a, b);
            }
        }
    }
    public static void union(int[] parent,int[] s,int x,int y){
        int x1=find(parent,x);
        int y1=find(parent,y);
        if(x1!=y1){
            parent[y1]=x1;
            s[x1]=s[x1]+s[y1];
        }
    }
    public static int find(int[] parent,int x){
        if(parent[x]==x){
            return x;
        }
        return find(parent,parent[x]);
    }
    public static int getTotal(int[] parent,int[] s,int x){
        return s[find(parent,x)];
    }
}
