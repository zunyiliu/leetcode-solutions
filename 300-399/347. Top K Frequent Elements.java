// solution 1: hashmap + priorityQueue O(n), use hashmap to record all nums[i] with (key,value) --> (nums[i],nums[i]'s frequency)
// use priorityQueue to pop the res according to keys' values from high to low K times, and that's the result

// solution 1
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        
        PriorityQueue<int[]> q = new PriorityQueue( 
            (t0,t1)-> ((int[])t1) [1]- ((int[])t0) [1]         
        );
            
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) != -1){
                int []tmp = new int[2];
                tmp[0] = nums[i];
                tmp[1] = map.get(nums[i]);
                map.put(nums[i],-1);
                q.add(tmp);
            }
        }
        
        int[] res = new int[k];
        while( k > 0 ){
            res[res.length-k] = q.poll()[0];
            k--;
        }
        
        return res;
    }
}
