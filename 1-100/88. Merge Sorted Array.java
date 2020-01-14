// start from the end of num1 thus no extra spaces will be needed (and there must always be enough spaces for inserting a new sorted number)
class Solution{
	public void merge(int[] num1,int m,int[] num2,int n){
		int k = m+n-1;
        while(m>0 && n>0){
            if(num1[m-1]>num2[n-1]){
                num1[k] = num1[m-1];
                m--;
            }else{
                num1[k] = num2[n-1];
                n--;
            }
            k--;
        }
        while(n>0){
            num1[k] = num2[n-1];
            k--;
            n--;
        }
	}
}
