// a hard problem, should figure the logic out and consider every edge case

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
