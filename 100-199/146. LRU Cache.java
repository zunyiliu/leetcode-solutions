// solution 1: use a hashmap to record key and node, node for storing key and value, and a double linked list to link all the nodes

// solution 2: there's existing data structure linkedhashmap can do it, FYI


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 
 // solution 1
class LRUCache {
    int capacity;
    HashMap<Integer,Node> map; // map <key,Node> , node contains key and val
    Node fakehead;
    Node faketail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        fakehead = new Node(0,0);
        faketail = new Node(0,0);
        fakehead.next = faketail;
        faketail.pre = fakehead;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node tar = map.get(key);
            remove(tar);
            insert(tar);
            return tar.val;
        }else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }else if(map.size()==capacity){
            remove(faketail.pre);
        }
        insert(new Node(key,value));
    }
    
    public void remove(Node node){
        map.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public void insert(Node node){
        map.put(node.key,node);
        Node headnext = fakehead.next;
        node.next = fakehead.next;
        headnext.pre = node;
        node.pre = fakehead;
        fakehead.next = node;
    }
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
}


// solution 2
import java.util.LinkedHashMap;
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
}
