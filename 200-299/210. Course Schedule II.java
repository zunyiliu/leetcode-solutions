// solution 1: topology sort with BFS to determine if a map contains cycle
// 1. delete nodes with indegree==0 (indegree=0 also means root nodes)
// 2. delete edges start from the nodes deleted in step 1, now some nodes with indegree>1 may become 0 now, they will be the new roots
// 3. go back to step 1, until no nodes can be deleted
// 4. if no nodes exist in the map then the original map has cycle

// solution 1.1: BFS topology sort, same as 1, just apply queue

// solution 2: DFS topology sort, use a time stamp
// the node finished later must be either the prerequisite of a node finished earlier or has no time dependency with a node finished earlier
// more edge cases in this solution A. a node may have 3 status, new or visited or finished, cycle means a visited node be visited again in one dfs)
// B. if all root nodes finish dfs, there still may exist a cycle, like a cycle with all nodes have indegree > 0 in which case no root node to start from

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

// solution 1.1
class Solution {
    public int[] findOrder(int n, int[][] pre) {
        Queue<Integer> q = new LinkedList();
        int[] order = new int[n];
        int[] indegree = new int[n];
        int index = 0;
        int graph[][] = new int[n][n];
        
        // build the map, calculate init indegrees
        for (int i = 0; i < pre.length; i++) {
            indegree[pre[i][0]]++;
            graph[pre[i][1]][pre[i][0]] = 1;
        }
        
        // add root nodes to queue
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                order[index] = i;
                index++;
            }
        }
        
        while (!q.isEmpty()){
            int course = q.poll();
            for (int i = 0; i < n; i++) {
                if (graph[course][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.offer(i);
                        order[index] = i;
                        index++;
                    }
                }
            }
        }
        
        return index == n? order : new int[0];
    }
}

// solution 2
class Solution {
    boolean hasCycle = false;
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<Integer> list = new ArrayList();
        int []indegree = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) graph[i] = new ArrayList();   
        for (int i = 0; i < pre.length; i++) {
            indegree[pre[i][0]]++;
            graph[pre[i][1]].add(pre[i][0]);
        }
        
        int visited[] = new int[n];        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                dfs(i, graph, list, visited);
            }
        }
        
        int order[] = new int[n];
        for (int i = 0; i < list.size(); i++) {
            order[i] = list.get(list.size()-i-1);
        }
        
        return (hasCycle || list.size() < n) ? new int[0] : order;
    }
    
    // visited[i] == 1 : a node has been visited
    // visited[i] == 2 : a node has been finished
    public void dfs(int cur, List<Integer>[] graph, ArrayList<Integer> list, int visited[]) {
        if (visited[cur] == 1) {
            hasCycle = true;
            return;
        }  
        if (visited[cur] == 2) return;
        
        visited[cur] = 1;
        
        for (int i = 0; i < graph[cur].size(); i++) {
            dfs(graph[cur].get(i), graph, list, visited);
        }
        
        visited[cur] = 2;
        list.add(cur);
    }
}
