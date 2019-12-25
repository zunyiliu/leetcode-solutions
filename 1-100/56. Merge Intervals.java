class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        
        // loop invariant: 
        // after every loop, 
        // all intervals except the last non-merged interval should be added to res,
        // and set curr to be this last interval.
        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];
            // check if it could be merged to curr interval
            if (intv[0] > curr[1]) {
                res.add(curr);
                curr = intv;
            } else {
                curr[1] = Math.max(curr[1], intv[1]);
            }
        }
        // don't forget to add current interval
        res.add(curr);
        
        return res.toArray(new int[res.size()][2]);
    }
}
