// solution 1:
// 1. Apply trie as the data structure of the WordDictionary
//    init a Node class, each Node represents a lower-case letter, 
//    a Node has two atts - a children[26] that contains all its subsequent node, and a boolean value isWord if a word ends with this Node
//2.  BackTrack the WordDic starting from its root node, the root node is a empty node which contains children[26] where each child represents 
//    the header of a word

// solution 1
class WordDictionary {
    class Node {
        Node []children;
        boolean isWord;
        
        public Node(){
            this.children = new Node[26];
            this.isWord = false;
        }
    }
    
    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (cur.children[ch] == null) {
                cur.children[ch] = new Node();
            }
            
            cur = cur.children[ch];
        }
        
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return backtrack(word,this.root);
    }
    
    public boolean backtrack(String word, Node cur) {
        if (word.length() == 0 && cur.isWord) return true;
        if (word.length() == 0 && !cur.isWord) return false;
        
        char ch = word.charAt(0);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && backtrack(word.substring(1),cur.children[i])) {
                    return true;
                }
            }
        } else {
            if (cur.children[ch-'a'] != null) return backtrack(word.substring(1),cur.children[ch-'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
