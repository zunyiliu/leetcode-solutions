// Note : can apply lagrange's four square theorem, won't show the mathmatical solution here 
// solution 1: DP, not complex, but the problem does not illustrate that the range of n (thus generally we will consider n is between 0 to INTEGER.MAX_VALUE, and 
// if so we won't consider DP since the array is too large)

// solution 2 notice, for not exceeding time limit, you should create a set to record all visited remainings of n (e.g. you have spent 2 steps to reach 5, now from another path with 3 steps you reach
// 5 again, now to reduce duplicate operations, you should avoid to add that path to the list/queue, since the path with 2 steps reaching 5 must have a shorter path to reach
// the end compare to the path with 3 steps reaching 5)
// solution 2: BFS, expand from n(you can either start from 0 or n), in each step, reduce n by minusing all possbile numbers' square and get all possible reduced new n(this is like BFS from source
// node to different nodes that generate different paths), the shortest path that reduces n to 0 is the result

// solution 2.1, same concept as 2, but use an arraylist to function the same as a queue

// solution 1
class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2;i<=n;i++){
            dp[i] = i;
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}

// solution 2
class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        queue.add(n);
        int depth = 0;
        if(n==0) return 0;
        
        while(true){
            int size = queue.size();
            depth++;
            for(int i=0;i<size;i++){
                int remain = queue.poll();
                for(int j=1;j*j<=remain;j++){
                    if(remain-j*j==0) return depth;
                    
                    if(!visited.contains(remain-j*j)){
                        queue.add(remain-j*j);
                        visited.add(remain-j*j);
                    }
                }
            }
        }
    }
}

// solution 2.1
class Solution {
    public int numSquares(int n) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList();
        ArrayList<Integer> path1 = new ArrayList();
        Set<Integer> visited = new HashSet();
        path1.add(n);
        paths.add(path1);
        
        while(true){
            int size = paths.size();
            for(int i=0;i<size;i++){
                int remain = paths.get(i).get(0);
                
                for(int j=1;j*j<=remain;j++){
                    ArrayList<Integer> pathi = new ArrayList(paths.get(i));
                    pathi.set(0,remain-j*j);
                    pathi.add(j);
                    if(pathi.get(0)==0){
                        return pathi.size()-1;
                    }
                    if(!visited.contains(pathi.get(0))){
                        visited.add(pathi.get(0));
                        paths.add(pathi);
                    }
                }
            }
            
            for(int i=0;i<size;i++) paths.remove(0);
        }
        
    }
}
