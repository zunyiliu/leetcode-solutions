// solution 1: bfs, the key is keeping track of the nodes that stored in an array
// the array that stores the nodes can also be modified by introducing a HashMap storing all the nodes
// and for a HashMap search also takes O(1)

// solution 2: dfs solution, can modify a bit to make method call dfs be void, and pass return node as parameter so
// it may easier to understand
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// solution 1
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        // 0 stands for new node, 1 stands for nodes that waiting in queue
        // 2 stands for nodes that popped from queue
        int index[] = new int[200];
        Node nodes[] = new Node[200];
        for(int i=1;i<200;i++) nodes[i] = new Node(i);        
        return bfs(node,index,nodes);
    }
    public Node bfs(Node n,int[] index,Node nodes[]){
        Queue<Node> q = new LinkedList();
        q.offer(n);
        while(!q.isEmpty()){
            Node cur = q.poll();
            index[cur.val] = 2;
            for(Node neighbor:cur.neighbors){
                if(index[neighbor.val]==0){
                    q.offer(neighbor);
                    index[neighbor.val] = 1;
                }
                nodes[cur.val].neighbors.add(nodes[neighbor.val]);
            }
        }
        return nodes[n.val];
    }
}

// solution 2
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Integer,Node> map = new HashMap();
        return dfs(map,node);
    }
    public Node dfs(HashMap<Integer,Node> map, Node node){
        Node root = new Node(node.val);
        map.put(root.val,root);
        for(Node nei:node.neighbors){
            if(!map.containsKey(nei.val)){
                dfs(map,nei);
            }
            root.neighbors.add(map.get(nei.val));
        }
        return root;
    }
}

// a clearer dfs rather than previous solution 2
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map = new HashMap();
        return dfs(map,node);
    }
    public Node dfs(HashMap<Node,Node> map, Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }else{
            Node root = new Node(node.val);
            map.put(node,root);
            for(Node neighbor:node.neighbors){
                root.neighbors.add(dfs(map,neighbor));
            }
            return root;
        }
    }
}
