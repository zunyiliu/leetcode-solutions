// patitioning current s into two parts, left part is the current patitioned length that would be added into list,
// right part is the remaining length which will be doing the same patition operation in the next recuring calculation

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        backtrack(s,new ArrayList(),res);
        return res;
    }
    public void backtrack(String s,List<String> list,List<List<String>> res){
        if(isPalin(s)){
            List<String> newlist = new ArrayList(list);
            newlist.add(s);
            res.add(newlist);
        }
        for(int i=1;i<s.length();i++){
            if( isPalin(s.substring(0,i)) ){
                List<String> newlist = new ArrayList(list);
                newlist.add(s.substring(0,i));
                backtrack(s.substring(i),newlist,res);
            }
        }  
    }
    public boolean isPalin(String s){
        int st = 0;
        int end = s.length()-1;
        while(st<end){
            if(s.charAt(st)!=s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
}
