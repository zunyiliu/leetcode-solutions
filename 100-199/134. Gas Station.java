// solution 1: naive solution, iterate all starting point and try all of them, O(n^2) time complexity

// solution 2: brilliant solution O(n) time complexity, pre-set start at the end station and end at start station
// each time expand end as far as possible, if sum reduces below 0 before end reaches start then the check last station before
// start (index in start-1), do this till end reaches start, if sum >= 0 then the station is the desired start station, otherwise
// there's no station could be selected

// solution 3: brilliant solution too O(n) time complexity:
// Here's the idea: 1. if the sumgas > sumcost, then there must be a soltution 
//                  2. the question itself only has one unique solution or no solution
//                  3. if start from A station can't reach B station (while B is the 1st station A can't reach), then
//                     all stations between A and B can't reach B
// We can iterate gas[], and get result from the above idea

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

//solution 3
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumtank = 0;
        int tank = 0;
        int st = 0;
        for(int i=0;i<gas.length;i++){
            sumtank += gas[i]-cost[i];
            tank += gas[i]-cost[i];
            if(tank<0){
                tank = 0;
                st = i+1;
            }
        }
        return sumtank>=0? st:-1;
    }
}
