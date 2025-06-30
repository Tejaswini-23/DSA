import java.util.*;
public class ToposortDFS {
    public static int[] toposort(List<List<Integer>> adj,int V){
        boolean visited[]=new boolean[V];
        Stack <Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,i,visited,st);
            }
        }
        int ans[]=new int[V];
        int k=0;
        while(!st.isEmpty()){
            ans[k++] = st.pop();
        }
        return ans;
    }
    public static void dfs(List<List<Integer>> adj,int s,boolean[] visited,Stack<Integer> st){
        visited[s]=true;
        for(int x:adj.get(s)){
            if(!visited[s]){
                dfs(adj,x,visited,st);
            }
        }
        st.push(s);
    }
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
}
