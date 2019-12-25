// find the place that needs to insert the newInterval, solution 1 use linear add and detect method
// solution 2 uses binary search to find the insertion slot thus can calculate the length of the newIntervals array in advance
// thus can apply 2-D array directly as container for new intervals(in solution 1 u have to use dinamic arraylist thus will
// return arraylist.toArray(new int[arraylist.size()][]), and this also consumes O(n) time complexity)

//solution 1
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
//solution 2
class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int startBinaryIdx = Arrays.binarySearch(intervals, newInterval, new Comparator<int[]>() {
      public int compare(int[] src, int[] k) {
        return src[0] - k[0];
      }
    });
    int endBinaryIdx = Arrays.binarySearch(intervals, newInterval, new Comparator<int[]>() {
      public int compare(int[] src, int[] k) {
        return src[0] - k[1];
      }
    });
    int start = startBinaryIdx < 0 ? -(startBinaryIdx + 1) : startBinaryIdx + 1;
    int end = endBinaryIdx < 0 ? -(endBinaryIdx + 1) : endBinaryIdx + 1;
    // calculate the length of new intervals
    // calculate the pivot  of new intervals
    int len = intervals.length - end + start;
    int pivot = start - 1;
    if (start == 0 || newInterval[0] > intervals[start-1][1]) {
      pivot = pivot + 1;
      len = len + 1;
    }
    if (start == 0 && end != 0) {
      intervals[0][0] = Math.min(newInterval[0], intervals[0][0]);
    }
    int[][] newIntervals = new int[len][2];
    for (int i=0; i < pivot; i++) {
      newIntervals[i] = intervals[i];
    }
    if (end == 0 || pivot == intervals.length) {
      newIntervals[pivot] = newInterval;
    } else {
      newIntervals[pivot][0] = Math.min(newInterval[0], intervals[pivot][0]);
      newIntervals[pivot][1] = Math.max(newInterval[1], intervals[end-1][1]);
    }
    for (int i=end; i < intervals.length; i++) {
      newIntervals[++pivot] = intervals[i];
    }
    return newIntervals;
  }
}
