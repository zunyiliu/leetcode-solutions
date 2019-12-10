class Solution {
    public String intToRoman(int num) {
        String [] s = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int [] n = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        
        StringBuilder res = new StringBuilder();
        
        for(int i=s.length-1;i>=0;i--){
            while(num>=n[i]){
                num-=n[i];
                res.append(s[i]); 
            }
        }
        
        return res.toString();
    }
}
