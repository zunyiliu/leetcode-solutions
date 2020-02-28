// bot-up dp: 2-D array to store if [j,i] is a palindrome (where j to i stands for s.charAt(j) to s.charAt(i) )
// if s.charAt(j)==s.charAt(i), then we just determin if [j+1,i-1] is palindrome, and it's been calculated in the previous step
// another point is that while bot-up this dp, we should keep track of the min value of the cut
// this is --> cut[i] = j==0? 0:Math.min(cut[i],cut[j-1]+1);

class Solution {
    public int minCut(String s) {
        int n = s.length()-1;
        boolean isP[][] = new boolean[n+1][n+1];
        int cut[] = new int[n+1];
        for(int i=0;i<=n;i++){
            cut[i] = i;
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)){
                    //if i-j<=2 then it must be a palindrome
                    if(i-j<=2 || isP[j+1][i-1]){
                        isP[j][i] = true;
                        cut[i] = j==0? 0:Math.min(cut[i],cut[j-1]+1);
                    }
                }
            }
        }
        return cut[n];
    }
}
