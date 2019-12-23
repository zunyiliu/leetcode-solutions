//easy one, just simulation the spiral and add all elements to List<Integer>

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0) return res;
        int top=0,right=matrix[0].length-1,bot=matrix.length-1,left=0;
        run(res,matrix,top,right,bot,left);
        return res;
    }
    public void run(List<Integer> res,int[][] matrix,int top,int right,int bot,int left){
        int round = 0;
        while(top<=bot && left<=right){
            if(round==0){
                for(int i=left;i<=right;i++) res.add(matrix[top][i]);
                top++;
            }
            if(round==1){
                for(int i=top;i<=bot;i++) res.add(matrix[i][right]);
                right--;
            }
            if(round==2){
                for(int i=right;i>=left;i--) res.add(matrix[bot][i]);
                bot--;
            }
            if(round==3){
                for(int i=bot;i>=top;i--) res.add(matrix[i][left]);
                left++;
            }
            round = (round+1)%4;
        }
    }
}
