class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList();        
        if (nums.length == 0) return list;
        int st = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != 1) {
                if (st != nums[i-1]) list.add(st+"->"+nums[i-1]);
                else list.add(st+"");

                st = nums[i];
            }
        }
        
        if (st != nums[nums.length-1]) {
            list.add(st+"->"+nums[nums.length-1]);
        } else {
            list.add(st+"");
        }
        return list;
    }
}
