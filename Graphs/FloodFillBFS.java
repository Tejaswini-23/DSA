import java.util.*;
public class FloodFillBFS {
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
        Queue<int[]> queue = new LinkedList<>();
        int oldColor = img[sr][sc];
        queue.add(new int[]{sr, sc});\
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        while(!queue.isEmpty()){
            int p[] = queue.poll();
            for(int i=0;i<4;i++){
                int x = p[0] + dx[i];
                int y = p[1] + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n && img[x][y] == oldColor){
                    img[x][y] = newColor;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return img;
    }
}
