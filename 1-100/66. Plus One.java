class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int pos = digits.length-1;
        while(carry==1){
            if(pos==-1) break;
            carry = (1+digits[pos])/10;
            digits[pos] = (1+digits[pos])%10;
            pos--;
        }
        if(carry == 1){
            int [] res = new int[digits.length+1];
            for(int i=0;i<digits.length;i++){
                res[i+1] = digits[i];
            }
            res[0] = 1;
            return res;
        }else return digits;
    }
}
