// bit manipulation
class Solution {
    public int getSum(int a, int b) {
        int res = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int cur = 0;
            if ((a & 1) == 1 && (b & 1) == 1) {
                cur = carry;
                carry = 1;
            } else if ((a & 1) != 1 && (b & 1) != 1) {
                cur = carry;
                carry = 0;
            } else {
                cur = carry == 1 ? 0 : 1;
            }
            
            res |= cur << i;
            a >>= 1;
            b >>= 1;
        }
        
        return res;
    }
}
