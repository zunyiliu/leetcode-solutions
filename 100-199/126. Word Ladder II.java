// solution 1: DFS backtrack solution, will exceed time limitation for some cases(since by using DFS u can't find the shortest
// path firstly, there might be 10 paths with length from 10 to 1, and your result finding sequence may follow as descending order
// from 10 to 1, thus time consumption wasted a lot)
// solution 2: BFS, from BFS your first finding sequence is the shortest path, there might be multiple shortest paths at the same time

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

// solution 2

