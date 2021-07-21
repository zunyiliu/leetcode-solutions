// boyer-moore voting algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList();
        int count[] = new int[2];
        int mode[] = new int[2];
        mode[0] = -9999; mode[1] = -9999;
        
        for (int n : nums) {
            if (n == mode[0]) {
                count[0]++;
            } else if (n == mode[1]) {
                count[1]++;
            } else if (count[0] == 0) {
                count[0]++;
                mode[0] = n;
            } else if (count[1] == 0) {
                count[1]++;
                mode[1] = n;
            } else {
                count[0]--;
                count[1]--;
            }
        }
        
        count[0] = 0; count[1] = 0;
        for (int n : nums) {
            if (mode[0] == n) {
                count[0]++;
            }
            if (mode[1] == n) {
                count[1]++;
            }
        }
        
        if (count[0] > nums.length/3) list.add(mode[0]);
        if (count[1] > nums.length/3) list.add(mode[1]);
        
        return list;
    }
}
