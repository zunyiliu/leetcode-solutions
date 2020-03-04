// similar as deep-copy of graph probelm, with the help of mapping to locate each node with its corresponding copy
// solution 1: dfs
// solution 2: bfs with queue, this method applies for graph (since graph can not use .next to traverse all nodes, a queue
// is necessary to traverse all nodes)
// solution 3: bfs without applying queue, since node.next in linkedlist can traverse all nodes easily

// solution 1
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap();
        return dfs(map,head);
    }
    public Node dfs(HashMap<Node,Node> map,Node node){
        if(node==null) return null;
        if(map.containsKey(node)){
            return map.get(node);
        }else{
            Node replica = new Node(node.val);
            map.put(node,replica);
            replica.next = dfs(map,node.next);
            replica.random = dfs(map,node.random);
            return replica;
        }
    }
}
// solution 2
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap();
        return bfs(map,head);
    }
    public Node bfs(HashMap<Node,Node> map,Node node){
        if(node==null) return null;
        map.put(node,new Node(node.val));
        
        Queue<Node> queue = new LinkedList();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.next==null) map.get(cur).next = null;
            else{
                if(!map.containsKey(cur.next)){ 
                    map.put(cur.next,new Node(cur.next.val));
                    queue.offer(cur.next);
                }
                map.get(cur).next = map.get(cur.next);
            }
            
            if(cur.random==null) map.get(cur).random = null;
            else{
                if(!map.containsKey(cur.random)){ 
                    map.put(cur.random,new Node(cur.random.val));
                    queue.offer(cur.random);
                }
                map.get(cur).random = map.get(cur.random);
            }
        }
        return map.get(node);
    }
}

// solution 3
