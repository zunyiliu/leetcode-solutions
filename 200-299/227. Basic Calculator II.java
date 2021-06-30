// solution 1: straightforward but a bit complicated, iteration
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
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch <= '9' && ch >= '0') {
                num = num * 10 + ch - '0';
            } 
            
            if ( ((ch > '9' || ch < '0') && ch != ' ') || i == s.length()-1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop()*num);
                } else if (op == '/') {
                    stack.push(stack.pop()/num);
                }
                num = 0;
                op = ch;
            }
        }
        
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        
        return sum;
    }
}
