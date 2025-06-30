import java.util.*;

public class DetectBFS {
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
        for(int i=0;i<V;i++){
            if(!visited[i]&& bfs(adj,i,visited)){
                return true;
            }
        }
        return false;
    }
    public static boolean bfs(List<List<Integer>> adj,int s,boolean[] visited){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{s, -1}); // Node and its parent
        visited[s] = true;
        while(!q.isEmpty()){
            int p[]=q.poll();
            int x=p[0];
            int y=p[1];
            for(int x1:adj.get(x)){
                if(!visited[x1]){
                    visited[x1]=true;
                    q.offer(new int[]{x1, x}); // Add the node and its parent
                }
                else if(x1 != y) { // If the node is visited and is not the parent
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle detected
    }
}
