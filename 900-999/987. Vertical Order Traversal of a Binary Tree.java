// just application of priorityQueue, we use map since map has O(1) while searching and inserting, whereas PQ has O(lgn) on insert and delete
// notice: 1. use hashmap is because we can know the column is continuous, that is the difference between two continuous columns will be 1, so we can record the minimum 
//            and the maximum column while traverse the tree and then use the min and max value to traverse the map.
//         2. use treemap is because the row is not continuous, and treemap.keySet() can return the keys in ascending order, so we can apply the treemap.keySet() to traverse the rows

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min = 99999;
    int max = -99999;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new HashMap();
        dfs(map,root,0,0);
        
        List<List<Integer>> res = new ArrayList();
        
        for (int i = min; i <= max; i++) {
            TreeMap<Integer,PriorityQueue<Integer>> tm = map.get(i);
            List<Integer> tmp = new ArrayList();
            for (int key : tm.keySet()) {
                PriorityQueue<Integer> pq = tm.get(key);                
                while(!pq.isEmpty()) {
                    tmp.add(pq.poll());
                }
            }
            res.add(tmp);
        }
        
        return res;
    }
    
    // in-order traverse
    public void dfs(Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map, TreeNode root, int col,int row) {
        if (root == null) return;
        min = col < min ? col : min;
        max = col > max ? col : max;
        
        dfs(map, root.left, col-1, row+1);
        
        // visit root
        TreeMap<Integer,PriorityQueue<Integer>> tm = map.getOrDefault(col,new TreeMap<Integer,PriorityQueue<Integer>>());
        PriorityQueue<Integer> pq = tm.getOrDefault(row,new PriorityQueue<Integer>());
        pq.offer(root.val);
        tm.put(row,pq);
        map.put(col,tm);
        
        dfs(map, root.right, col+1, row+1);
    }
}
