// solution 1: naive solution, iterate all starting point and try all of them, O(n^2) time complexity
// solution 2: brilliant solution O(n) time complexity

// solution 1
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            if(reachable(i,gas,cost)) return i;
        }
        return -1;
    }
    public boolean reachable(int i,int[] gas,int[] cost){
        int total = gas[i]-cost[i];
        if(total<0) return false;
        
        for(int j=1;j<gas.length;j++){
            i = (i+1)%gas.length;
            total += gas[i]-cost[i];
            if(total<0) return false;
        }
        return true;
    }
}

// solution 2:
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int end = 0;
        int st = gas.length-1;
        int sum = gas[st]-cost[st];
        
        while(st>end){
            if(sum>=0){
                sum += gas[end]-cost[end];
                end++;
            }else{
                st--;
                sum += gas[st]-cost[st];                 
            }
        }
        return sum >= 0? st:-1;
    }
}
