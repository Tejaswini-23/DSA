import java.util.*;

class DFSMatDic {

    public void addEdge(int[][] adj, int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1; // undirected graph
    }

    public void print(int[][] adj) {
        System.out.println("Adjacency Matrix:");
        for (int[] row : adj) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> DFS(int[][] adj) {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsRec(adj, i, visited, result);
                c++;
            }
        }
        System.out.println("Number of connected components: " + c);
        return result;
    }

    private void dfsRec(int[][] adj, int v, boolean[] visited, List<Integer> result) {
        visited[v] = true;
        result.add(v);
        for (int neighbor = 0; neighbor < adj.length; neighbor++) {
            if (adj[v][neighbor] == 1 && !visited[neighbor]) {
                dfsRec(adj, neighbor, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] adj = new int[n][n];

        DFSMatDic dfsDic = new DFSMatDic();

        while (true) {
            System.out.print("Enter edge (u v) or -1 -1 to stop: ");
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u == -1 && v == -1) break;

            dfsDic.addEdge(adj, u, v);
        }

        dfsDic.print(adj);
        List<Integer> dfsResult = dfsDic.DFS(adj);
        System.out.println("DFS Traversal: " + dfsResult);

        sc.close();
    }
}
