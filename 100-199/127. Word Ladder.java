// bfs solution 
// solution 2: same but use Queue instead of creating list repeated
class Solution {
    public int ladderLength(String b, String e, List<String> words) {
        Set<String> dict = new HashSet(words);
        List<String> beginlist = new ArrayList();
        beginlist.add(b);
        int count = 1;
        boolean found = false;
        loop:
        while(!beginlist.isEmpty()){
            dict.removeAll(beginlist);
            List<String> nextlist = new ArrayList();
            for(String sbegin:beginlist){
                if(sbegin.equals(e)){
                    found = true;
                    break loop;
                }
                findnext(dict,nextlist,sbegin);
            }
            beginlist = nextlist;
            count++;
        }
        return found? count:0;
    }
    public void findnext(Set<String> dict,List<String> nextlist, String s){
        char schar[] = s.toCharArray();
        for(int i=0;i<schar.length;i++){
            char cur = schar[i];
            for(char ch='a';ch<='z';ch++){
                schar[i] = ch;
                String temp = new String(schar);
                if(dict.contains(temp)){
                    nextlist.add(temp);
                }
            }
            schar[i] = cur;
        }
    }
}

// optimization of BFS
class Solution {
    public int ladderLength(String b, String e, List<String> words) {
        Set<String> dict = new HashSet(words);
        Queue<String> q = new LinkedList<>();
        q.add(b);
        int count = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String temp = q.poll();
                if(temp.equals(e)){
                    return count;
                }
                findnext(dict,q,temp);
            }
            count++;
        }
        return 0;
    }
    public void findnext(Set<String> dict,Queue<String> q, String s){
        char schar[] = s.toCharArray();
        for(int i=0;i<schar.length;i++){
            char cur = schar[i];
            for(char ch='a';ch<='z';ch++){
                schar[i] = ch;
                String temp = new String(schar);
                if(dict.contains(temp)){
                    q.offer(temp);
                    dict.remove(temp);
                }
            }
            schar[i] = cur;
        }
    }
}
