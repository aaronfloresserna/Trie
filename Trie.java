package Trie;

public class Trie {

    public TrieNode root;
    
    public class TrieNode {
        private char data;
        private TrieNode[] children = new TrieNode[26];
        private int prefixCount = 0;
        public boolean wordEnd;

        public TrieNode(char data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Char: " + data + " Is end? " + wordEnd;
        }
    }

    public Trie() { 
        this.root = new TrieNode('/');
    }

    private int getIndex(char c){
        return c - 'a';
    }

    public void insert(String word) {
        if (search(word)) throw new IllegalStateException();
        int i = 0;
        TrieNode current = root;
        while (i < word.length()){
            char newData = word.charAt(i);
            int index = getIndex(newData);
            if (current.children[index] == null) 
                current.children[index] = new TrieNode(newData);
            current.children[index].prefixCount++;
            if (i == word.length() - 1){
                current.children[index].wordEnd = true;
                break;
            } else 
                current = current.children[index];
            i++;
        }
    }

    public boolean search(String word){ 
        TrieNode current = root;
        for(int count = 0; count < word.length(); count++){
            char c = word.charAt(count);
            if(current.children[getIndex(c)] == null)
                return false;
            current = current.children[getIndex(c)];
        }
        if (current.wordEnd == true)
            return true;
        else 
            return false;
    }

    public boolean delete(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            if(current.children[getIndex(word.charAt(i))] != null)
                current = current.children[getIndex(word.charAt(i))];
            else 
                throw new IllegalStateException();
        }
        current.wordEnd = false; 
        return true;
    } 

    public int prefix(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++){
            current = current.children[getIndex(word.charAt(i))];
        }
        return current.prefixCount;
    }

}

