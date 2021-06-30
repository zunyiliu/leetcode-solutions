// recursion 
class Solution {
    int i = 0;
    public int calculate(String s) {
        int a = 0;
        char op = '+';
        int b = 0;
        
        while (i < s.length()) {
            char ch = s.charAt(i);
            i++;
            
            if (ch == '(') {
                b = calculate(s);
            } else if (ch == ')') {
                return cal(a,b,op);
            } else if (ch <= '9' && ch >= '0') {
                b = b * 10 + ch - '0';
            } else if (ch== ' ') {
                continue;
            } else {
                a = cal(a,b,op);
                b = 0;
                op = ch;
            }
        }
        
        return cal(a,b,op);
    }
     
    public int cal(int a,int b,char op) {
        if (op == '+') return a + b;
        return a - b;
    }
}
