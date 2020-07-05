// solution 1: BFS check below msg for more explanations
// solution 2: DFS check below msg for more explanations

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
