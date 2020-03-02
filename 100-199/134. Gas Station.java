// solution 1: naive solution, iterate all starting point and try all of them, O(n^2) time complexity
// solution 2:

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
