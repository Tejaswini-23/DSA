import java.util.*;
public class SizeC {
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    int M=sc.nextInt();
    int[] parent=new int[N+1];
    int[] size=new int[N+1];
    for(int i=1;i<=N;i++){
        parent[i]=i; // Initialize each element to be its own parent
        size[i]=1; // Initialize size of each set to 1
    }
    for(int i=0;i<M;i++){
        int a=sc.nextInt();
        int b=sc.nextInt();
        union(parent, size, a, b); 
        // Sort the size array to get the sizes in ascending order
        ArrayList<Integer> sizes = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                if (parent[j] == j) { // root
                    sizes.add(size[j]);
                }
            }

            Collections.sort(sizes);
            for (int sz : sizes) {
                System.out.print(sz + " ");
            }
            System.out.println();

    }

    }
    public static void union(int[] parent,int[] size,int a,int b){
        int x1=find(parent,a);
        int y1=find(parent,b);
        if(x1!=y1){
            parent[y1] = x1; // Make y's root point to x's root
            size[x1] += size[y1]; // Update the size of the new root
        }
    }
    public static int find(int[] parent,int x){
        if(parent[x]==x){
            return x;
        }
        return find(parent,parent[x]);
    }
}
