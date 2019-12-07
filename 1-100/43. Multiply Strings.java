// using elementry school's naive way for calculation. PS -- it's intuitive that 
//the length of the result will not be longer than num1.len+num2.len
class Solution {
    public String multiply(String num1, String num2) {
        int pos[] = new int[num1.length()+num2.length()];
       
        for(int i=num2.length()-1;i>=0;i--){
            for(int j=num1.length()-1;j>=0;j--){
                int mul = (num2.charAt(i)-'0')*(num1.charAt(j)-'0')+pos[i+j+1];
                pos[i+j+1] = mul%10;
                pos[i+j] += mul/10;
            }
        }
        String res = "";
        for(int i=0;i<pos.length;i++){
            if(pos[i]!=0 || !res.equals("")){
                res += pos[i];
            }
        }
        return res.equals("")? "0":res;
    }
}
