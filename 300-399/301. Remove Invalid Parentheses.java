// solution 1: BFS, very complex, iterate String s go through every char and form all possible combinations, and return the final result strings
// that are valid and with maximum length
// note: 1. add visited hashset to avoid duplicates (if not the BFS tree will expand huge after few steps)
//       2. DFS is better, since you can first go through the string, and know the least number of 
//        left/right brackets you need to delete, then in each recursive call pass the state of the brackets you need to delete(left and right), once
//        you find the deleted number of left/right brackets are exceeding the limit, you can end this path-call in advance

// solution 2: DFS(or backtracking)
// solution 2.1: same as solution 2, use stringbuilder and in-place check of isValid(brackets) to save run time

// solution 1
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> visited = new HashSet();
        List<String> list = new ArrayList();
        Queue<String> q = new LinkedList();
        q.add("");
        visited.add("");
        
        for(int i=0;i<s.length();i++){
            int size = q.size();
            char ch = s.charAt(i);
            
            while(size>0){
                String tmp = q.poll();
                q.add(tmp);
                if(isValid(tmp+ch)>=0 && !visited.contains(tmp+ch)){
                    q.add(tmp+ch);
                    visited.add(tmp+ch);
                }
                size--;
            }
        }
        
        //return new ArrayList(q);
        deleteInvalid(s,q,list);
        return list;
    }
    
    // return >=0 means the extra left brackets num returned e.g "((" returns 2
    // so if returns 0 then it's a valid string with brackets
    // return -1 means invalid, e.g "())"
    public int isValid(String s){
        int l=0,r=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                l++;
            }else if(s.charAt(i)==')'){
                if(l>0) l--;
                else return -1;
            }
        }
        return l;
    }
    
    public void deleteInvalid(String s,Queue<String> q,List<String> list){
        int rmleft = 0;
        int rmright = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                rmleft++;
            }else if(s.charAt(i)==')'){
                if(rmleft>0) rmleft--;
                else rmright++;
            }
        }
        
        int len = s.length()-rmleft-rmright;
        List<String> tmp = new ArrayList(q);
        for(int i=0;i<tmp.size();i++){
            if(len==tmp.get(i).length() && isValid(tmp.get(i))==0) list.add(tmp.get(i));
        }
    }
}

// solution 2
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet();
        List<String> list = new ArrayList();
        
        int l = 0, r = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                l++;
            }
            if(s.charAt(i)==')'){
                if(l>0) l--;
                else r++;
            }
        }
        
        dfs(res,l,r,"",s);
        return new ArrayList(res);
    }
    
    public void dfs(Set<String> res,int l,int r,String cur,String s){
        if(l==0 && r==0 && s.length()==0 && isValid(cur)) {
            res.add(cur);
            return;
        }
        if(l<0 || r<0 || s.length()==0) return;
        
        char ch = s.charAt(0);
        s = s.substring(1);
        
        if(ch=='('){
            dfs(res,l,r,cur+ch,s);
            dfs(res,l-1,r,cur,s);
        }else if(ch==')'){
            dfs(res,l,r,cur+ch,s);
            dfs(res,l,r-1,cur,s);
        }else{
            dfs(res,l,r,cur+ch,s);
        }
    }
    
    public boolean isValid(String s){
        int l = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') l++;
            else if(s.charAt(i)==')'){
                if(l<=0) return false;
                else l--; 
            } 
        }
        return l==0;
    }
}

// solution 2.1
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')') {
                if (rmL != 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
        return new ArrayList<String>(res);
    }

    public void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(sb.toString());
            }        
            return;
        }

        char c = s.charAt(i); 
        int len = sb.length();

        if (c == '(') {
            dfs(s, i + 1, res, sb, rmL - 1, rmR, open);		    // not use (
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1);       // use (

        } else if (c == ')') {
            dfs(s, i + 1, res, sb, rmL, rmR - 1, open);	            // not use  )
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1);  	    // use )

        } else {
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);	
        }

        sb.setLength(len);        
    }
}
