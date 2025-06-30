import java.util.*;

class Countpath {
    public static int countPaths(int V, int[][] edges, int src, int des) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            adj.get(x).add(y);
        }
        return dfs(src, des, adj);
    }

    public static int dfs(int src, int des, ArrayList<ArrayList<Integer>> adj) {
        if (src == des) return 1;
        int c = 0;
        for (int x : adj.get(src)) {
            c += dfs(x, des, adj); // correct variable used: des
        }
        return c;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // Number of vertices
        int E = sc.nextInt(); // Number of edges
        int[][] edges = new int[E][2];
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        int src = sc.nextInt(); // Source vertex
        int des = sc.nextInt(); // Destination vertex

        int result = countPaths(V, edges, src, des);
        System.out.println(result);
    }
}
