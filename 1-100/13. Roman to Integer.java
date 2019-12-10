class Solution {
    public int romanToInt(String s) {
        String [] strs = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int [] nums = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        int res = 0;
        for(int i=strs.length-1;i>=0;i--){
            while(s.startsWith(strs[i])){
                res+=nums[i];
                s = s.substring(strs[i].length());
            }
        }
        return res;
    }
}
