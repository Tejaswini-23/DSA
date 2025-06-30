import java.util.*;
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String key) {
        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
            }
            curr = curr.child[index];
            curr.c++;
        }
        curr.isleaf = true; // Mark the end of the word
    }
    public boolean search(String key) {
        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            int ind = ch - 'a';
            if (curr.child[ind] == null) {
                return false;
            }
            curr = curr.child[ind];
        }
        return curr.isleaf;
    }
}
public class WordBreak {
    public static void main(String args[]) {
        Trie trie = new Trie();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            trie.insert(word);
        }
        System.out.println("Enter the string to check for word break:");
        String s = scanner.nextLine();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && trie.search(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (dp[s.length()]) {
            System.out.println("The string can be segmented into words from the dictionary.");
        } else {
            System.out.println("The string cannot be segmented into words from the dictionary.");
        }
        scanner.close();
    }
}
class TrieNode {
    TrieNode child[];
    boolean isleaf;
    int c;
    public TrieNode() {
        child = new TrieNode[26];
        isleaf = false;
        c = 0;
    }
}