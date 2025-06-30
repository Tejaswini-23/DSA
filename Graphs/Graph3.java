import java.util.*;
public class Graph3 {
    public static void Print(HashMap<Integer, List<Integer>> adj){
        for(Map.Entry<Integer,List<Integer>> entry : adj.entrySet()){
            System.out.print(entry.getKey() + ": ");
            for(Integer x : entry.getValue()){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        HashMap<Integer, List<Integer>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        while(true){
            System.out.println("Enter the vertices to add edges and -1 -1 to exit");
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
