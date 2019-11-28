1. recursively using mind of binary search -- increment divisor twice to approach dividend exponentially(very fast) 

class Solution {
    public int divide(int a, int b) {
        if(a==Integer.MIN_VALUE && b==-1){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if(a>0){
            a = -a;
            sign = -sign;
        }
        if(b>0){
            b = -b;
            sign = -sign;
        }
        if(sign==1) return recur(a,b,0);
        return -recur(a,b,0);
    }
    
    //a, b both negative --> only this can allow edge condition while a=Integer.MIN_VALUE
    //can not be solved in positive form
    public int recur(int a,int b,int res){
        /* recursion method
        if(a>b) return res;
        if(a==b) return res+1;
        
        int temp = b;
        int temp_res = 1;
        while(temp+temp>a){
            //edge case, if two int plus exceed MIN_VALUE --> positive result
            if(temp+temp>0) break;
            temp += temp;
            temp_res += temp_res;
        }
        return recur(a-temp,b,temp_res+res);
        */
        
        //non-recursion method
        int temp;
        int temp_res;
        while(true){
            if(a>b) return res;
            if(a==b) return res+1;
            
            temp = b;
            temp_res = 1;
            while(temp+temp>a){
                //edge case, if two int plus exceed MIN_VALUE --> positive result
                if(temp+temp>0) break;
                temp += temp;
                temp_res += temp_res;
            }
            a -= temp;
            res += temp_res;
        }
    }
}
