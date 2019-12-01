//solution 1: dynamic programming&stack: use stack to store the index of '(' in s, 
//an array where array[i] stores the longest valid parentheses end with index i, all end with '(' is by default 0
//each time meet a ')' with index l try to pop a '(' with index r in stack, if stack is empty then no valid parentheses end with r
//thus array[r] = 0, if stack is not empty then r-l+previous longest parenthese will be stored in array[r]

//solution 2: use purely stack, a pointer that points to the least index(longest parentheses) that is valid for the current index i
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int array[] = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
    
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('){
               stack.push(i);
           }else{
               if(stack.isEmpty()){
                   array[i] = 0;
               }else{
                    int l_bracket = stack.pop();
                    array[i] = l_bracket==0? i-l_bracket+1 : i-l_bracket+1+array[l_bracket-1];
                    max = array[i]>max? array[i]:max;
               }
           }
        }
        return max;
    }
}

// solution 2
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int pointer = 0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('){
               stack.push(i);
           }else{
               if(stack.isEmpty()){
                   pointer = i+1;  
               }else{
                   int temp = stack.pop();
                   if(stack.isEmpty()){
                       max = Math.max(i-pointer+1,max);
                   }else{
                       max = Math.max(i-stack.peek(),max);
                   }
               }
           }
        }
        return max;
    }
}
