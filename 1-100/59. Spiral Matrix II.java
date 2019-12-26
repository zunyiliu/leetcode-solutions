//mimic spiral, easy
class Solution {
    public int[][] generateMatrix(int n) {
        int top=0,l=0,r=n-1,bot=n-1;
        int [][] res = new int[n][n];
        int side = 0,count = 1;
        while(top<=bot && l<=r){
            if(side==0){
                for(int i=l;i<=r;i++){
                    res[top][i] = count;
                    count++;
                }
                top++;
            }
            if(side==1){
                for(int i=top;i<=bot;i++){
                    res[i][r] = count;
                    count++;
                }
                r--;
            }
            if(side==2){
                for(int i=r;i>=l;i--){
                    res[bot][i] = count;
                    count++;
                }
                bot--;
            }
            if(side==3){
                for(int i=bot;i>=top;i--){
                    res[i][l] = count;
                    count++;
                }
                l++;
            }
            side = (side+1)%4;
        }
        return res;
    }
}
