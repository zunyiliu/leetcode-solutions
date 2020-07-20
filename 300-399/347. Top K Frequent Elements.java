// solution 1: hashmap + priorityQueue O(n), use hashmap to record all nums[i] with (key,value) --> (nums[i],nums[i]'s frequency)
// use priorityQueue to pop the res according to keys' values from high to low K times, and that's the result

// solution 2: hashmap + treemap O(n), treemap can use function pollLastEntry() to poll the last entry with the highest key

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

// solution 2
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        
        for(int n:nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }
        
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
           int freq = map.get(num);
           if(!freqMap.containsKey(freq)){
               freqMap.put(freq, new LinkedList<>());
           }
           freqMap.get(freq).add(num);
        }
        
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        
        int []tmp = new int[k];
        for(int i=0;i<k;i++){
            tmp[i] = res.get(i);
        }
        
        return tmp;
    }
}

