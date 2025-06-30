import java.util.*;
public class FloodFillDFS {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m = sc.nextInt();
        int n=sc.nextInt(); 
        int img[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                img[i][j]=sc.nextInt();
            }
        }
        int sr=sc.nextInt();
        int sc1=sc.nextInt();
        int newColor=sc.nextInt();
        int res[][]=floodFill(img,sr,sc1,m,n,newColor);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static int[][] floodFill(int[][] img,int sr,int sc,int m,int n,int newColor){
        if(img[sr][sc]==newColor) return img;
        int oldColor = img[sr][sc];
        dfs(img,sr,sc,m,n,oldColor,newColor);
        return img;
    }
    public static void dfs(int[][] img,int sr,int sc,int m,int n,int oldColor,int newColor){
        if(sr<0||sr>=m||sc<0||sc>=n||img[sr][sc]!=oldColor){
            return;
        }
        img[sr][sc]=newColor;
        dfs(img,sr+1,sc,m,n,oldColor,newColor);
        dfs(img,sr-1,sc,m,n,oldColor,newColor);  
        dfs(img,sr,sc+1,m,n,oldColor,newColor);
        dfs(img,sr,sc-1,m,n,oldColor,newColor);
        return;
    }
}
