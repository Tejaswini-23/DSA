import java.util.*;
class Trie1{
    TrieNode1 root;
    String mostFrequent = "";
    int maxCount = 0;
    public Trie1(){
        root = new TrieNode1();
    }
    public void insert(String key){
        TrieNode1 curr = root;
        for(char ch : key.toCharArray()){
            int index = ch - 'a';
            if(curr.child[index] == null){
                curr.child[index] = new TrieNode1();
            }
            curr = curr.child[index];
            curr.c++;
            if (curr.c > maxCount || (curr.c == maxCount && key.compareTo(mostFrequent) < 0)) {
            maxCount = curr.c;
            mostFrequent = key.substring(0, maxCount ); // Update most frequent word
            }
        }
        curr.isleaf = true; // Mark the end of the word
        curr.wordCount++;
    }
    public boolean search(String key){
        TrieNode1 curr = root;
        for(char ch : key.toCharArray()){
            int ind = ch - 'a';
            if(curr.child[ind] == null){
                return false;
            }
            curr = curr.child[ind];
        }
        return curr.isleaf;
    }
    public boolean isPrefix(String key){
        TrieNode1 curr = root;
        for(char ch : key.toCharArray()){
            int ind = ch - 'a';
            if(curr.child[ind] == null){
                return false;
            }
            curr = curr.child[ind];
        }
        return true;
    }
}
public class Pr2 {
    public static void main(String args[]){
        Trie1 trie = new Trie1();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        for(int i = 0; i < n; i++){
            String word = scanner.nextLine();
            trie.insert(word);
        }
        String searchWord = scanner.nextLine();
        if(trie.search(searchWord)){
            System.out.println("Word found in Trie");
        } else {
            System.out.println("Word not found in Trie");
        }
        String prefix = scanner.nextLine();
        if(trie.isPrefix(prefix)){
            System.out.println("Prefix found in Trie");
        } else {
            System.out.println("Prefix not found in Trie");
        }
        System.out.println("Most frequent word: " + trie.mostFrequent);
    }
}
class TrieNode1{
    TrieNode1 child[];
    boolean isleaf;
    int c;
    int wordCount = 0; // To count the number of times a word is inserted
    public TrieNode1(){
        child = new TrieNode1[26];
        isleaf = false;
        c = 0;
        wordCount = 0; // Initialize word count
    }
    
}