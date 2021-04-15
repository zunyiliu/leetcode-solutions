// solution 1: hashmap + list, while search in list we use iteration, however as the timestamp is stored in increasing order, binary search is applied
// solution 2: hashmap + treemap, as treemap can call floorkey(value) that returns the biggest key <= value (not given, simple logic behind)

// solution 1
class TimeMap {
    Map<String, List<Node>> map;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Node> list = map.getOrDefault(key, new LinkedList());
        list.add(new Node(value,timestamp));
        map.put(key,list);
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if (list == null) return "";
        
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).timestamp <= timestamp) return list.get(i).value;
        }
        return "";
    }
    
    class Node {
        String value;
        int timestamp;
        
        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

