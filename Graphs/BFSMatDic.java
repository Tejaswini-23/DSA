import java.util.*;

class BFSMatDic {

    public static void addEdge(int[][] adj, int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1; // undirected graph
    }

    public static void print(int[][] adj) {
        System.out.println("Adjacency Matrix:");
        for (int[] row : adj) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> bfs(int[][] adj) {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                bfsComponent(adj, i, visited, component);
                res.add(component);
            }
        }
        return res;
    }

    private static void bfsComponent(int[][] adj, int start, boolean[] visited, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(node);
            for (int neighbor = 0; neighbor < adj.length; neighbor++) {
                if (adj[node][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] adj = new int[n][n];

        while (true) {
            System.out.print("Enter edge (u v) or -1 -1 to stop: ");
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u == -1 && v == -1) break;

            addEdge(adj, u, v);
        }

        print(adj);

        List<List<Integer>> bfsResult = bfs(adj);
        System.out.println("BFS Components:");
        for (List<Integer> component : bfsResult) {
            System.out.println(component);
        }

        sc.close();
    }
}
