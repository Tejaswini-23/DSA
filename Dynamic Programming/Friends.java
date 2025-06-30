import java.util.*;
public class Friends {
   public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    int M=sc.nextInt();
    ArrayList<int []> a=new ArrayList<>();
    for(int i=0;i<M;i++){
        int x=sc.nextInt();
        int y=sc.nextInt();
        int t=sc.nextInt();
        a.add(new int[]{x,y,t});
    }
    int ans=earliestTime(a,N);
    System.out.println(ans);
   } 
   public static int earliestTime(ArrayList<int[]>a,int N){
    int parent[]=new int[N];
    for(int i=0;i<N;i++){
        parent[i]=i;
    }
    Collections.sort(a, (x,y)->x[2]-y[2]);
    int N1=N;
    for(int[] a1:a){
        int x=a1[0];
        int y=a1[1];
        int t=a1[2];
        if(find(parent,x)!=find(parent,y)){
            union(parent,x,y);
            N1--;
        }
        if(N1==1){
            return t;
        }
    }
        return -1;
   }
     public static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }
    public static void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);
        parent[x]=y; // Return type adjusted to match the method signature
    }
   
}
