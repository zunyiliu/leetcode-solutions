// notice: >>> means shift the number right towards 1 bit, and add a '0' at the head of the number
// --> while >> means shift the number right forward 1 bit, and add a '1' at the head of the number if the number is negative, other wise '0'
// notice: bit operation like '&' is much faster than '%'

// solution 1: use %2 to determine if the lowest bit is '1' or not 
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            int t = n % 2;
            if (t == 1 || t == -1) {
                count++;
            } 
            n >>>= 1;
        }
        
        return count;
    }
}

// solution 2: use &1 to determine if the lowest bit is '1' or not
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        
        return count;
    }
}
