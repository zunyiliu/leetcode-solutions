// solution 1: topology sort to determine if a map is connected
// 1. delete nodes with indegree==0 (indegree=0 also means root nodes)
// 2. delete edges start from the nodes deleted in step 1, now some nodes with indegree>1 may become 0 now, they will be the new roots
// 3. go back to step 1, until no nodes can be deleted
// 4. if no nodes exist in the map then the original map is connected



// solution 1
class Solution {
    public int[] findOrder(int n, int[][] pre) {
        int []indegree = new int[n];
        int graph[][] = new int[n][n];
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i < pre.length; i++){
            indegree[pre[i][0]]++;
            graph[pre[i][1]][pre[i][0]] = 1;
        }
        
        while (list.size() < n){
            boolean deleted = false;
            for (int i = 0; i < n; i++){
                if (indegree[i] == 0){
                    indegree[i] = -1;
                    deleted = true;
                    list.add(i);
                    for (int j = 0; j < n; j++){
                        if (graph[i][j] == 1){
                            indegree[j]--;
                        }
                    }
                }
            }
            
            if (!deleted) return new int[0];
        }
        
        int res[] = new int[n];
        
        for ( int i = 0; i < list.size(); i++) res[i] = list.get(i);
        
        return res;
    }
}
