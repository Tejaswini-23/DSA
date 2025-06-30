import java.util.*;
public class DetectDFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int M = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // For undirected graph
        }
        boolean ans= isCycle(V, adj);
        System.out.println(ans);
    }
    public static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited=new boolean[V + 1];
        boolean[] recStack = new boolean[V + 1];
        for(int i=0;i<V;i++){
            if(!visited[i]&& dfs(adj,i,visited,recStack)){
                return true;
            }
        }
        return false;
    }
    boolean dfs(List<List<Integer>> adj, int node, boolean[] visited, boolean[] recStack) {
        if(recStack[node]==true){
            return true;
        }
        if(visited[node]==true){
            return false;
        }
        visited[node]=true;
        recStack[node]=true;
        for(int neighbour:adj.get(node)){
            if(dfs(adj,neighbour,visited,recStack)){
                return true;
            }
        }
        recStack[node]=false;
        return false;
    }
}
