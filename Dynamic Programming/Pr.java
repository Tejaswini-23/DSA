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
    public boolean isPrefix(String key) {
        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            int ind = ch - 'a';
            if (curr.child[ind] == null) {
                return false;
            }
            curr = curr.child[ind];
        }
        return true;
    }
}
public class Pr {
    public static void main(String args[]) {
        Trie trie = new Trie();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            trie.insert(word);
        }
        String searchWord = scanner.nextLine();
        if (trie.search(searchWord)) {
            System.out.println("Word found in Trie");
        } else {
            System.out.println("Word not found in Trie");
        }
        String prefix = scanner.nextLine();
        if (trie.isPrefix(prefix)) {
            System.out.println("Prefix found in Trie");
        } else {
            System.out.println("Prefix not found in Trie");
        }
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