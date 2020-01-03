// use two pointers all start from index 0, step 1 : 1st pointer is moving forward till all chars are found
// 2 step: then try to minimize the length by moving 2nd pointer forward
// 3 step: once you can't move anymore in step 2, go back to step 1 and try to move 1st pointer to once again try find all chars
// during these steps, a hashmap is required for recording the number of each chars required(-2 represents u need 2 more this char,
and positive 2 represents u have 2 more this char besides what u've needed)
// when tracking length a min_length and the index of the min_length substring must be recorded so u can return it
// after finish of execution
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> memo = new HashMap();
        // use map to record chars and how many of each char is needed
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(!memo.containsKey(c)) memo.put(c,-1);
            else memo.put(c,memo.get(c)-1);
        }
        int counter=0,start=0,end=0,len=Integer.MAX_VALUE;
        // if a char needed is hit, reduce its requirement by 1
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(memo.containsKey(c)){
                memo.put(c,memo.get(c)+1);
                if(memo.get(c)<=0) counter++; 
            }
            // if all chars are hit currently, try minimise the length
            // be moving start forward till can't move anymore
            while(counter==t.length()){
                if(i-start<len){
                    len = i-start;
                    end = i;   
                }
                char delete = s.charAt(start);
                if(memo.containsKey(delete)){
                    memo.put(delete,memo.get(delete)-1);
                    if(memo.get(delete)<0) counter--;
                }
                start++;
            }
        }
        return len == Integer.MAX_VALUE? "":s.substring(end-len,end+1);
    }
}
