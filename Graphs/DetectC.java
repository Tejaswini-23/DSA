import java.util.*;
public class DetectC {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int M=sc.nextInt();
        int edges[][]=new int[M][2];
        for(int i=0;i<M;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        boolean ans=findCircle(edges,V);
        System.out.println(ans);
    }
    public static boolean findCircle(int[][] edges,int V){
        int parent[]=new int[V+1];
        for(int i=1;i<=V;i++){
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++){
            int x=find(parent, edges[i][0]);
            int y=find(parent, edges[i][1]);
            if(x==y){
                return true;
            }
            union(parent,x,y);
        }
        return false;
    }
    public static int find(int[] parent,int x){
        if(parent[x]==x){
            return x;
        }
        return find(parent ,parent[x]);
    }
    public static void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot; // Make y's root point to x's root
        }
    }
}
