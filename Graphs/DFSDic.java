import java.util.*;

class DFSDic {

    public void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected graph
    }

    public void print(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer v : adj.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> DFS(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        int c=0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsRec(adj, i, visited, result);
                c++;
            }
        }
        System.out.println("Number of connected components: " + c);
        return result;
    }

    private void dfsRec(List<List<Integer>> adj, int v, boolean[] visited, List<Integer> result) {
        visited[v] = true;
        result.add(v);
        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfsRec(adj, neighbor, visited, result);
                
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        // Correctly declare adjacency list with generics
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        DFSDic dfsDic = new DFSDic();

        while (true) {
            System.out.print("Enter edge (u v) or -1 -1 to stop: ");
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u == -1 && v == -1) {
                break;
            }

            dfsDic.addEdge(adj, u, v);
        }

        dfsDic.print(adj);
        List<Integer> dfsResult = dfsDic.DFS(adj);
        System.out.println("DFS Traversal: " + dfsResult);

        sc.close();
    }
}