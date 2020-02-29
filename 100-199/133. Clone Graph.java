// solution 1: bfs, the key is keeping track of the nodes that stored in an array

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
