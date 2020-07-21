// A straight forward method wont record -- recursively iterate the string, in each recursion find a pair of brackets and decoding them,
// return once no bracket pair can be found

// solution 1: use two stacks, one for multiplier the other for strs in the corresponding multiplier, 
// e.g for input "3[a2[c]]", stack A will store [3,2] and stack B will store [a,c]. After 1st decoding, they become [3] and [a], and the decoding res is "cc"
// then we append the res of the 1st decoding to its previous inner-content, so the two stacks become to [3] and [acc], then they become [accaccacc] after 2nd iteration

// solution 2: recursively solve the problem, initially I come up with idea by using a for loop to iterating the string, and each time when meet a '[', call recursive function,
// however, it's hard to track the index of corresponding ']' (each time after decoding as the string will change, thus the index of corresponding ']' will change too)
// so the inner string witin a '[' ']' pair is hard to decode (will have higher run time complexity). But use queue can resolve this easily.

// solution 1
class Solution {
    public String decodeString(String s) {
        Stack<Integer> multis = new Stack();
        Stack<StringBuilder> strs = new Stack(); 
        int multi = 0;
        // this is for storing the final res
        strs.push(new StringBuilder());
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(ch<='9' && ch>='0'){
                multi = multi*10 + (ch-'0');
            }else if(ch=='['){
                multis.push(multi);
                multi = 0;
                strs.push(new StringBuilder());
            }else if(ch==']'){
                StringBuilder tmp = new StringBuilder();
                StringBuilder content = strs.pop();
                Integer iterate = multis.pop();
                
                for(int j=0;j<iterate;j++){
                    tmp.append(content);
                }
                strs.push(strs.pop().append(tmp));
            }else{
                strs.push(strs.pop().append(ch));
            }
            
        }
        
        return strs.pop().toString();
    }
}

// solution 2
class Solution {
    public String decodeString(String s) {
        Queue<Character> q = new LinkedList();
        for(char c:s.toCharArray()) q.add(c);
        q.add(']');
        return recur(q);
    }
    
    public String recur(Queue<Character> q){
        StringBuilder sb = new StringBuilder();
        int multi = 0;
                                            
        while(!q.isEmpty()){
            char ch = q.poll();
                
            if(ch<='9' && ch>='0'){
                multi = multi*10 + (ch-'0');
            }else if(ch=='['){
                String res = recur(q);
                for(int i=0;i<multi;i++){
                    sb.append(res);
                }
                multi = 0;
            }else if(ch==']'){
                break;
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
