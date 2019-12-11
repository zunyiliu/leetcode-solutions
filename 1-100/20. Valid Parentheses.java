//1 use stack
//2 optimization with also using stack

//solution 1
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }
            if(s.charAt(i)==')'){
                if(stack.isEmpty() || stack.pop()!='(') return false;
            }
            if(s.charAt(i)=='{'){
                stack.push('{');
            }
            if(s.charAt(i)=='}'){
                if(stack.isEmpty() || stack.pop()!='{') return false;
            }
            if(s.charAt(i)=='['){
                stack.push('[');
            }
            if(s.charAt(i)==']'){
                if(stack.isEmpty() || stack.pop()!='[') return false;
            }
        }
        return stack.isEmpty();
    }
}

//solution 2
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(')');
            }else if(s.charAt(i)=='{'){
                stack.push('}');
            }else if(s.charAt(i)=='['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop()!=s.charAt(i) ){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
