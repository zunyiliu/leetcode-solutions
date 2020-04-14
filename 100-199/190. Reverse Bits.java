// apply bit operation, reverse the position bit by bit

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=15;i>=0;i--){
            int tmp = i*2+1;
            res |= (n<<tmp) & (1<<i+16); 
        }
        for(int i=0;i<=15;i++){
            int tmp = i*2+1;
            res |= (n>>tmp) & (1<<15-i);
        }
        return res;
    }
}
