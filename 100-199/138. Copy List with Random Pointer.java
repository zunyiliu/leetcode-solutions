// similar as deep-copy of graph probelm, with the help of mapping to locate each node with its corresponding copy
// solution 1: dfs
// solution 2: bfs

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
