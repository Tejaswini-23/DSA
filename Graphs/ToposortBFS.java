import java.util.*;
public class ToposortBFS {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int V = sc.nextInt(); // Number of vertices
        int E = sc.nextInt(); // Number of edges
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        int[] result = toposort(adj, V);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
    public static int[] toposort(List<List<Integer>> adj,int V){
        int ind[] =new int[V];
        for(int i=0;i<V;i++){
            for(int x:adj.get(i)){
                ind[x]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        int res[]=new int[V];
        int k=0;
        while(!q.isEmpty()){
            int x=q.poll();
            res[k++]=x;
            for(int y:adj.get(x)){
                ind[y]--;
                if(ind[y]==0){
                    q.add(y);
                }
            }
        }
        if(k<V){
            return new int[0]; // Cycle detected, return empty array
        }
        return res; // Return the topological sort order
    }
}
