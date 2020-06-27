// Use comparator, for any two numbers in the array, compare their two concatenations
// and sort them according to which combination is larger
class Solution {
    public String largestNumber(int[] nums) {
        String strs[] = new String[nums.length];
        for(int i=0;i<nums.length;i++) strs[i] = nums[i]+"";
        
        Arrays.sort(strs, new Comparator<String>() {
           @Override
           public int compare(String num0,String num1) {               
               int len = Math.min(num0.length(),num1.length());
               
               String num0num1 = num0+num1;
               String num1num0 = num1+num0;
               
               return -num0num1.compareTo(num1num0);
           }
       });
        
        String res = "";
        if(strs[0].charAt(0)=='0') return "0";
        
        for(int i=0;i<strs.length;i++){
            res += strs[i];
        }
        return res;
    }
}
