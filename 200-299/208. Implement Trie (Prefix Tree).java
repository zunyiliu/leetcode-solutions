// Prefix tree
// very simple concept, a tree has a root node, the node holds a val and an array represents its children, also a node will hold a isWord boolean value which represents
// a word is ended here or not

class node{
    char val;
    node children[];
    boolean isWord;
    
    public node(){
        this.children = new node[26];
    }
    public node(char ch){
        this.children = new node[26];
        this.val = ch;
    }
}

class Trie {
    node root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
                cur.children[ch-'a'] = new node(ch);
            }
            cur = cur.children[ch-'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null) return false;
            else cur = cur.children[ch-'a'];
        }
        if(cur.isWord) return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        node cur = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(cur.children[ch-'a']==null) return false;
            else cur = cur.children[ch-'a'];
        }
        return true;
    }
}
