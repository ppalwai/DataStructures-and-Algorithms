package ds;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Trie {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isCompleteWord;

        @Override
        public String toString() {
            return children.toString();
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            node.children.putIfAbsent(c,new TrieNode());
            node = node.children.get(c);
        }
        node.isCompleteWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("trie");
        trie.insert("world");

        assert trie.search("hello");

        assert false == trie.search("hello1");

        assert trie.search("trie");

        assert trie.search("world");

        assert trie.search("worl");

        assert false == trie.search("trie1");
    }
}