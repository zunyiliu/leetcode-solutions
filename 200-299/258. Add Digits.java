// solution 1
class Solution {
    // e.g. abcd = a*10^3 + b*10^2 + c*10 + d
    // a*10^3 % 9 = a * (10^3%9) = a * 1 = a
    // b,c,d same as a
    // so, abcd % 9 = (a+b+c+d) % 9 = (d+f) % 9 = e % 9 (let's assume a+b+c+d = df, and d+f = e)
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
// solution 2 simplication of solution 1
class Solution {
    // e.g. abcd = a*10^3 + b*10^2 + c*10 + d
    // a*10^3 % 9 = a * (10^3%9) = a * 1 = a
    // b,c,d same as a
    // so, abcd % 9 = (a+b+c+d) % 9 = (d+f) % 9 = e % 9 (let's assume a+b+c+d = df, and d+f = e)
    public int addDigits(int num) {
        return (num-1)%9+1;
    }
}
