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
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList();
        if (wordList == null || wordList.size() == 0) return res;
        Set<String> wordDict = new HashSet(wordList);
        if (!wordDict.contains(endWord)) return res;
        
        Map<String, List<String>> graph = new HashMap();
        Set<String> curLevel = new HashSet();
        
        curLevel.add(beginWord);
        boolean foundEnd = false;
        
        while (!curLevel.isEmpty() && !foundEnd) {
            wordDict.removeAll(curLevel); //this is important for minimizing the graph size, and avoid backtrack of the path
            Set<String> nextLevel = new HashSet();
            for (String s : curLevel) {
                graph.put(s, new ArrayList<String>());
                char[] cur = s.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char c = cur[j];
                    for (char r = 'a'; r <= 'z'; r++) {
                        if (r == c) continue;
                        cur[j] = r;
                        String temp = new String(cur);
                        if (!wordDict.contains(temp)) continue;
                        graph.get(s).add(temp);
                        nextLevel.add(temp);
                        if (temp.equals(endWord)) {
                            foundEnd = true;
                        };
                    }
                    cur[j] = c;
                }
            }
            curLevel = nextLevel;
        }
        if (!foundEnd) return res;
        List<String> list = new ArrayList();
        list.add(beginWord);
        addPath(beginWord, endWord, res, graph, list);
        return res;
    }
    
    private void addPath(String from, String to,  List<List<String>> res, 
                         Map<String, List<String>> graph, List<String> list) {
        if (from.equals(to)) {
            res.add(new ArrayList(list));
            return;
        }
        if (!graph.containsKey(from)) return;
        for (String next : graph.get(from)) {
            list.add(next);
            addPath(next, to, res, graph, list);
            list.remove(list.size() - 1);
        }
    }
}
