import java.util.*;

class BFSDic {

    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected graph
    }

    public static void print(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer v : adj.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> bfs(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> res= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                bfsRec(adj, i, visited, result,component);
                res.add(component);
            }
        }
        return res;
    }

    private static List<Integer> bfsRec(List<List<Integer>> adj, int start, boolean[] visited, List<Integer> result,List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            component.add(node);
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return component;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

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