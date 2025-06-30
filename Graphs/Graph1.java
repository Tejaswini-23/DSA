import java.util.*;
class Graph1{
    public static void addEdge(int[][] M,int i,int j){
        M[i][j]=1;
    }
    public static void Print(int[][] M){
        for(int[] r:M){
            for(int x:r){
                System.out.print(x+" ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String args[]){
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int M[][]=new int[n][n];
        while(true){
            System.out.println("Enter vertices to add edges and -1 -1 to exit");
            int u=sc.nextInt();
            int v=sc.nextInt();
            if(u==-1 && v==-1){
                break;
            }
            addEdge(M, u, v);
        }
        Print(M);
    }
}