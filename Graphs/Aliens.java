import java.util.*;
public class Aliens {
    public static String findOrder(String[] words){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        int ind[] = new int[26];
        boolean exist[]=new boolean[26];
        for(String w:words){
            for(char ch : w.toCharArray()){
                exist[ch-'a']=true;
            }
        }
        for(int i=0;i<words.length-1;i++){
            String w1=words[i];
            String w2=words[i+1];
            int l=Math.min(w1.length(),w2.length());
            int j=0;
            while(j<l && w1.charAt(j)==w2.charAt(j)){
                j++;
            }
            if(j<l){
                int u=w1.charAt(j)-'a';
                int v=w2.charAt(j)-'a';
                adj.get(u).add(v);
                ind[v]++;
            }
            else if(w1.length()>w2.length() && w1.startsWith(w2)){
                return ""; // Invalid order, w1 is longer but starts with w2
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i==0;i<26;i++){
            if(exist[i] && ind[i]==0){
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int x = q.poll();
            sb.append((char)(x + 'a'));
            for(int y : adj.get(x)){
                ind[y]--;
                if(ind[y] == 0){
                    q.add(y);
                }
            }
        }
        for(int i=0;i<26;i++){
            if(exist[i] && ind[i] > 0){
                return ""; // Cycle detected, invalid order
            }
        }
        return sb.toString(); // Return the topological order as a string
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of words
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        String order = findOrder(words);
        if (order.isEmpty()) {
            System.out.println("Invalid order");
        } else {
            System.out.println(order);
        }
    }
}
