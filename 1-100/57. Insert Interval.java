class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res; 
        }
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;
        for(int i=0;i<intervals.length;i++){
            if(!inserted){
                if(intervals[i][0]>newInterval[0]){
                    inserted = true;
                    //newInterval is the smallest
                    if(res.size()==0){
                        res.add(newInterval);
                        merge(res,intervals[i]);
                    //newInterval is among intervals
                    }else{
                        //merge last element in res and newInterval firstly
                        //then merge the result of previous calculation, with the current interval
                        merge(res,newInterval);
                        merge(res,intervals[i]);
                    }
                }else{
                    //intervals before newInterval should add directly
                    res.add(intervals[i]);
                }
            }else{
                merge(res,intervals[i]);
            }
        }
        if(!inserted) merge(res,newInterval);
        return res.toArray(new int[res.size()][]);
    }
    //merge the last element of res with target
    public void merge(List<int[]> res,int[] target){
        if(res.get(res.size()-1)[1]<target[0]){
            res.add(target);
        }else{
            res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],target[1]);
        }
    }
}
