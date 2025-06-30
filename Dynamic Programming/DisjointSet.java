import java.util.*;
public class DisjointSet {
    public static int find(int[] parent,int i){
        if(parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }
    public static void union(int i,int j){
        int x = find(parent, i);
        int y = find(parent, j);
        if(x != y) {
            parent[x] = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of elements
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initialize each element to be its own parent
        }
        
        int m = sc.nextInt(); // Number of union operations
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x, y);
        }
        
        // Output the parent array to see the disjoint sets
        for (int i = 0; i < n; i++) {
            System.out.print(find(parent, i) + " ");
        }
    }
}
