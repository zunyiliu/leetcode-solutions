// solution 1: stack based solution, a variation of No.84, for each row u have to deal with a largest rectangle histogram issue
// (对每一行都是以该行为底的直方图求一次stack based最大长方形的面积)

// solution 2: stack based dp solution, same concept as dp in 84, u could know it if u undetstand that problem(this is actually a 
// transformation of solution 1 while 1 uses stack and this uses dp to record each line's left most and right most expandable index)

// solution 3: from discussion true dp solution, very hard to understand 

// solution 1: 
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if( matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int []height = new int[matrix[0].length];
        int max = 0;
            
        for(int i=0;i<matrix.length;i++){
            Stack<Integer> stack = new Stack();
            
            for(int j=0;j<=matrix[0].length;j++){
                if(j!=matrix[0].length){
                    if(matrix[i][j]=='1') height[j]+=1;
                    else height[j]=0;
                }
                
                int temp = j==matrix[0].length? 0:height[j];
                while(!stack.isEmpty() && temp < height[stack.peek()] ){
                    int h = height[stack.pop()];
                    int w = stack.isEmpty()? j:j-stack.peek()-1;
                    max = Math.max(max,h*w);
                }
                stack.push(j);  
            }
        }
        return max;
    }
}
