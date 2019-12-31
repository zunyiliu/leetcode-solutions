// a hard problem, should figure the logic out and consider every edge case
// 2 -- just rewrite the solution making it concise
public class Solution {
    public List<String> fullJustify(String[] words, int max) {
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<words.length;i++){
            StringBuilder newline = new StringBuilder();
            int len = words[i].length();
            newline.append(words[i]);
            int i2 = i+1;
            //calculate len of the newline
            while(i2<words.length && len+words[i2].length()+1<=max){
                len+=words[i2].length()+1;
                i2++;
            }
            int space = 0,extra=0;
            if(i2!=i+1 && i2!=words.length){ //not 1st char, not last line
                space = (max-len)/(i2-i-1);
                extra = (max-len)%(i2-i-1); 
            }  
            
            for(int j=i+1;j<i2;j++){
                newline.append(" ");
                for(int z=0;z<space;z++) newline.append(" ");
                if(extra-->0) newline.append(" ");
                newline.append(words[j]);
            }                
            //last line or newline with one word
            int gap = max-newline.length();
            for(int j=0;j<gap;j++) newline.append(" ");
            i = i2-1;
            list.add(newline.toString());
        }
        return list;
    }
}

// 2
class Solution {
    public List<String> fullJustify(String[] words, int max) {
        List<String> list = new ArrayList<>();
        
        for(int i=0,i1=0;i<words.length;i=i1){
            StringBuilder line = new StringBuilder(words[i]);
            int len = words[i].length();
            for(i1=i+1;i1<words.length && len+1+words[i1].length()<=max;i1++){
                len+=1+words[i1].length();
            }
            int space=1,extra=0;
            //if not the last line
            // not a line with only one word(since this will incur divided by zero)
            if(i1<words.length && i1!=i+1){
                space += (max-len)/(i1-i-1);
                extra = (max-len)%(i1-i-1);
            }
            //append spaces and words(a line with only one word would not be considered
            //since j starts from i+1)
            for(int j=i+1;j<i1;j++){
                for(int z=0;z<space;z++) line.append(' ');
                if(extra-->0) line.append(' ');
                line.append(words[j]);
            }
            int gap = max-line.length();
            for(int j=0;j<gap;j++) line.append(' ');
            list.add(line.toString());
        }
        return list;
    }
}
