import java.util.*;
class MST{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int M=sc.nextInt();
        int edges[][]=new int[M][3];
        for(int i=0;i<M;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
            edges[i][2]=sc.nextInt();
        }
        int ans=findCost(edges,V);
        System.out.println(ans);
    }
    public static int findCost(int[][] edges,int V){
        int parent[]=new int[V+1];
        for(int i=1;i<=V;i++){
            parent[i]=i;
        }
        Arrays.sort(edges,(x,y)->x[2]-y[2]);
        int cost=0;
        int count=0;
        for(int i=0;i<edges.length;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            int w=edges[i][2];
            if(find(parent,x)!=find(parent,y)){
                union(parent,x,y);
                cost+=w;
                count++;
                if(count==V-1){
                    break;
                }
            }
        }
        return cost;
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