// solution 1: naive DFS backtrack solution, will exceed time limitation for some cases

// solution 1
class Solution {
    int minsize = 99999;
    public List<List<String>> findLadders(String b, String e, List<String> words) {
        List<List<String>> res = new ArrayList();
        boolean []mark = new boolean[words.size()];
        List<String> cur = new ArrayList();
        cur.add(b);
        backtrack(res,cur,mark,b,e,words);
        return res;
    }
    public void backtrack(List<List<String>> res,List<String> cur,boolean mark[],String b,String e,List<String> words){
        if(b.equals(e)){
            if(cur.size()<minsize){
                minsize = cur.size();
                res.clear();
                res.add(new ArrayList(cur));   
            }else if(cur.size()==minsize){
                res.add(new ArrayList(cur));
            }
            return;
        }
        for(int i=0;i<words.size();i++){
            if(!mark[i] && modifiable(words.get(i),b)){
                mark[i] = true;
                cur.add(words.get(i));
                backtrack(res,cur,mark,words.get(i),e,words);
                cur.remove(cur.size()-1);
                mark[i] = false;
            }
        }
    }
    public boolean modifiable(String a,String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) count++;
        }
        return count==1;
    }
}
