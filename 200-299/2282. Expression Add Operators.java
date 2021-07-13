// solution 1 backtracking -- notice, a num "103" can also be parsed as 10 + 3
// solution 2: an improvement to avoid using Stack 
// e.g 1 + 3 * 4, we transfer the equation to (1 + 3) - 3 + (3 * 4)
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList();
        backtrack(0,new Stack<Long>(),new StringBuilder(),list,num,target);
        return list;
    }
    
    public void backtrack(int pos, Stack<Long> stack, StringBuilder cur, List<String> res, String num, int target)     {
        if (pos == num.length()) {
            long sum = sumOfStack(stack);
            if (sum == target) {
                res.add(cur.toString());
            }
            return;
        }
        
        long pre = 0;
        for (int i = pos; i < num.length(); i++) {
            int temp = num.charAt(i) - '0';
            pre = pre * 10 + temp;
            
            if (num.charAt(pos) == '0' && i != pos) break;
            
            if (pos == 0) {
                Stack<Long> stack0 = (Stack)stack.clone();
                stack0.push(pre);
                backtrack(i+1,stack0,new StringBuilder(cur).append(""+pre),res,num,target);
            } else {
                Stack<Long> stack0 = (Stack)stack.clone();
                stack0.push((long)-pre);
                backtrack(i+1,stack0,new StringBuilder(cur).append("-"+pre),res,num,target);

                Stack<Long> stack1 = (Stack)stack.clone();
                stack1.push((long)pre);
                backtrack(i+1,stack1,new StringBuilder(cur).append("+"+pre),res,num,target);

                Stack<Long> stack2 = (Stack)stack.clone();
                stack2.push(stack2.pop()*pre);
                backtrack(i+1,stack2,new StringBuilder(cur).append("*"+pre),res,num,target);
            }
        }
    }
    
    public long sumOfStack(Stack<Long> stack) {
        long sum = 0;
        for (long i : stack) {
            sum += i;
        }
        return sum;
    }
}

// solution 2
class Solution {
    List<String> list;
    int target;
    String num;
    public List<String> addOperators(String num, int target) {
        this.target = target;
        this.num = num;
        this.list = new ArrayList();
        
        backtrack(0,0,0,"");
        return list;
    }
    
    public void backtrack(int pos, long pre, long sum, String path) {
        if (pos == num.length()) {
            if (sum == target) {
                list.add(path);
            }
            return;
        }
        
        long mul = 0;
        long head = num.charAt(pos) - '0';
        for (int i = pos; i < num.length(); i++) {
            if (head == 0 && i > pos) break;
            
            int cur = num.charAt(i) - '0';
            mul = mul * 10 + cur;
            
            if (pos == 0) {
                backtrack(i + 1, mul, mul, mul + "");
            } else {
                backtrack(i + 1, mul, sum + mul, path + "+" + mul);
                backtrack(i + 1, -mul, sum - mul, path + "-" + mul);
                backtrack(i + 1, pre * mul, sum - pre + pre * mul, path + "*" + mul);
            }
        }
    }
}
