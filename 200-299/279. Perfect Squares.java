// Note : can apply lagrange's four square theorem, won't show the mathmatical solution here 
// solution 1: DP, not complex, but the problem does not illustrate that the range of n (thus generally we will consider n is between 0 to INTEGER.MAX_VALUE, and 
// if so we won't consider DP since the array is too large)

// solution 2: BFS, expand from n(you can either start from 0 or n), in each step, reduce n by minusing all possbile numbers' square and get all possible reduced new n(this is like BFS from source
// node to different nodes that generate different paths), the shortest path that reduces n to 0 is the result

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
