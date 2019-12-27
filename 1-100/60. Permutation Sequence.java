// solution 1: backtrack, cant pass test since big n will cause stack overflow/time limit exceeds
class Solution {
    int count = 0;
    String res = "";
    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        for(int i=1;i<=n;i++){
            str.append(i);
        }
        backtrack("",str.toString(),k);
        return res;
    }
    public void backtrack(String a,String b,int k){
        if(b.length()==0){
            count++;
            if(count==k){
                res = a;
                return;
            }
        }
        for(int i=0;i<b.length();i++){
            String aTemp = a+b.charAt(i);
            String bTemp = b.substring(0,i)+b.substring(i+1,b.length());
            backtrack(aTemp,bTemp,k);
        }
    }
}
