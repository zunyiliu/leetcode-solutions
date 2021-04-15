// two pointers
class Solution {
    public int[][] intervalIntersection(int[][] f, int[][] s) {
        int p1 = 0;
        int p2 = 0;
        List<int[]> list = new ArrayList();
        
        while (p1 < f.length && p2 < s.length) {
            int minOfTail = Math.min(f[p1][1],s[p2][1]);
            int maxOfHead = Math.max(f[p1][0],s[p2][0]);
            
            if (minOfTail >= maxOfHead) {
                list.add(new int[]{maxOfHead,minOfTail});
            }
            
            if (f[p1][1] > s[p2][1]) {
                p2++;
            } else {
                p1++;
            }
        }
        
        int[][] res = new int[list.size()][2];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}
