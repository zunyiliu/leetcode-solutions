// solution 1: straightforward but a bit complicated, recursion
// solution 2: stack

// solution 1
class Solution {
    int i = 0;
    public int calculate(String s) {
        int a = 0;
        int b = 0;
        char op = '+';
        
        while (i < s.length()){
            char ch = s.charAt(i);
            i++;
            
            if (ch == ' ') continue;
            if (ch <= '9' && ch >= '0') {
                b = b * 10 + ch - '0';
            } else if (ch == '+' || ch == '-') {
                a = cal(a,b,op);
                b = 0;
                op = ch;
            } else {
                if (op == '+' || op =='-') {
                    b = cal(b,parseNum(s),ch);
                } else {
                    a = cal(a,b,op);
                    b = 0;
                    op = ch;
                }
            }
        }
        
        return cal(a,b,op);
    }
    
    public int parseNum(String s) {
        int num = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
            } else if (ch <= '9' && ch >= '0') {
                num = num * 10 + ch - '0';
                i++;
            } else {
                break;
            }
        }
        return num;
    }

    
    public int cal(int a, int b, char op) {
        if (op == '+') return a+b;
        if (op == '-') return a-b;
        if (op == '/') return a/b;
        return a*b;
    }
}

// solution 2:
