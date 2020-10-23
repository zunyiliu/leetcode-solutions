// recursively add-on the String, and return 
class Solution {
    public String countAndSay(int n) {
        String cur = "1";
        
        for(int i=1;i<n;i++){
            StringBuilder sb = new StringBuilder();
            
            int count = 1;
            char ch = cur.charAt(0);
            
            for(int j=1;j<cur.length();j++){
                if(cur.charAt(j)==ch){
                    count++;        
                }else{
                    sb.append(count).append(ch);
                    ch = cur.charAt(j);
                    count = 1;
                }
            }
            
            cur = sb.append(count).append(ch).toString();
        }
        
        return cur;
    }
}
