import java.util.*;
public class Graph2 {
    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected graph
    }
    public static void Print(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (int x : adj.get(i)) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        while(true){
            System.out.println("Enter Vertices to add edges -1 -1 to exit");
            int u=sc.nextInt();
            int v=sc.nextInt();
            if(u==-1 && v==-1){
                break;
            }
            addEdge(adj,u,v);
        }
        Print(adj);
    }
}
