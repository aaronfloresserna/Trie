package Trie;

public class Main {
    public static void main(String args[]){
        Trie trie = new Trie();
        
        trie.insert("word");
        trie.insert("aaron");
        //trie.insert("aaron");
        trie.insert("nintendo");
        trie.insert("aandrea");
        trie.insert("aron");
        System.out.println(trie.prefix(""));
    }
}
