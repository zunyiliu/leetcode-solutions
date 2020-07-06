// solution 1: BFS check below msg for more explanations
// solution 2: DFS with matrix graph representation check below msg for more explanations
// solution 2.1: DFS with adjecent list graph representation, much faster than matrix graph

// solution 1
// BFS: start from those courses that do not need prerequisite,
// add those courses into a stack/queue/whatever datastructure, 
// then expand the graph by popping course id from the datastructure
// each time a course does not need any more prerequiste(that is its indegree decreases
// to zero), we push the course into data structure to help release other courses
// do this until no new courses can be added into data structure, then check
// if all courses have been released
class Solution {
    public boolean canFinish(int num, int[][] pre) {
        int indegree[] = new int[num];
        int count = 0;
        
        // indegree[i] represents how many prerequisite the course i needs
        for(int i=0;i<pre.length;i++){
            indegree[pre[i][0]]++;
        }
        
        // add initial courses with no prerequisites into stack
        // you can use queue, stack, any data structure you want
        Stack<Integer> stack = new Stack();
        for(int i=0;i<num;i++){
            if(indegree[i]==0) {
                stack.push(i);
                count++;
            }
        }
        
        while(!stack.isEmpty()){
            int index = stack.pop();
            for(int i=0;i<pre.length;i++){
                if(pre[i][1]==index){
                    indegree[pre[i][0]]--;
                    if(indegree[pre[i][0]]==0){
                        stack.push(pre[i][0]);
                        count++;
                    }
                }
            }
        }
        return count==num;
    }
}

// solution 2
// DFS: build the graph with either a matrix or adjecent list
// check if the graph has a cycle or not
// the basic idea is trivial, the key point in this problem
// is to refine what it wants you to do from a general problem to a graph problem
public class Solution {
    boolean validNode[];
    boolean mark[];
    public boolean canFinish(int num, int[][] pre) {
        int graph[][] = new int[num][num];
        validNode = new boolean[num];
        mark = new boolean[num];
        
        for(int i=0;i<pre.length;i++){
            graph[pre[i][1]][pre[i][0]] = 1;
        }
        
        for(int i=0;i<graph.length;i++){
            if(!dfs(graph,i)){
                return false;
            }
        }
        return true;
    }
    
    // dfs true -- no cycle
    // dfs false -- has cycle
    public boolean dfs(int[][] graph, int index){
        // validNode[i] means a node i is validated before that it has no cycle in its children paths
        if(validNode[index]) return true;
        // mark[i] means a node i is visited in current path --> which means a cycle exists
        if(mark[index]) return false;
        
        mark[index] = true;
        for(int i=0;i<graph.length;i++){
            if(graph[index][i]==1){
                if(!dfs(graph,i)) return false;
            } 
        }
        mark[index] = false;
        validNode[index] = true;
        return true;
    }
}

// solution 2.1
// DFS: build the graph with either a matrix or adjecent list
// check if the graph has a cycle or not
// the basic idea is trivial, the key point in this problem
// is to refine what it wants you to do from a general problem to a graph problem
public class Solution {
    boolean validNode[];
    boolean mark[];
    public boolean canFinish(int num, int[][] pre) {
        ArrayList []graph = new ArrayList[num];
        for(int i=0;i<num;i++) graph[i] = new ArrayList();
        
        validNode = new boolean[num];
        mark = new boolean[num];
        
        for(int i=0;i<pre.length;i++){
            graph[pre[i][1]].add(pre[i][0]);
        }
        
        for(int i=0;i<graph.length;i++){
            if(!dfs(graph,i)){
                return false;
            }
        }
        return true;
    }
    
    // dfs true -- no cycle
    // dfs false -- has cycle
    public boolean dfs(ArrayList[] graph, int index){
        // validNode[i] means a node i is validated before that it has no cycle in its children paths
        if(validNode[index]) return true;
        // mark[i] means a node i is visited in current path --> which means a cycle exists
        if(mark[index]) return false;
        
        mark[index] = true;
        for(int i=0;i<graph[index].size();i++){
            int successor = (int)graph[index].get(i);
            if(!dfs(graph,successor)) return false;
        }
        mark[index] = false;
        validNode[index] = true;
        return true;
    }
}
