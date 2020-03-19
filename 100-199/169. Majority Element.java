class Solution {
    public int majorityElement(int[] nums) {
        // bit operation, for every bit out of 32-bits(Integer's maximum)
        // count the ones and zeros appearance time, by loop all 32-bits you will 
        // 'concatenate' the result bit by bit
        int res = 0;
        for(int i=0;i<32;i++){
            int zeros = 0;
            int ones = 0;
            for(int num:nums){
                if( (num&(1<<i))==0 ) zeros++;
                else ones++;
            }
            if(zeros<ones) res |= 1<<i; 
        }
        return res;
    }
}
