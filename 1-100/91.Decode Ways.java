// can use recursion -- but dp is better
// solution 1: top-down dp
class Solution{
    public int numDecodings(String s){
        if(s.length()==0) return 0;
        int []dp = new int[s.length()];
        for(int i=0;i<dp.length;i++) dp[i]=-1;
        return recur(dp,s,0);
    }
    public int recur(int[] dp,String s,int st){
        if(dp[st]!=-1) return dp[st];
        if(s.charAt(st)=='0')  return dp[st] = 0;
        else if(st==s.length()-1) return dp[st] = 1;
        else if(st==s.length()-2){
            if(valid(s.charAt(st)-'0',s.charAt(st+1)-'0')) return dp[st] = 1+recur(dp,s,st+1);
            else return dp[st] = recur(dp,s,st+1);
        }else{
            if(valid(s.charAt(st)-'0',s.charAt(st+1)-'0')){
                return dp[st] = recur(dp,s,st+1)+recur(dp,s,st+2);
            }else return dp[st] = recur(dp,s,st+1);
        }
    }

    public boolean valid(int a, int b){
        if(a*10+b<=26) return true;
        return false;
    }
}
// solution 2: bot-up dp, way more clear
class Solution{
	public int numDecodings(String s){
		if(s.length()==0) return 0;
		int []dp = new int[s.length()];
		
		for(int i=dp.length-1;i>=0;i--){
			if(s.charAt(i)=='0') dp[i] = 0;
			else if(i==dp.length-1) dp[i] = 1;
			else if(i==dp.length-2) dp[i] = valid(s.charAt(i)-'0',s.charAt(i+1)-'0')? 1+dp[i+1]:dp[i+1];
			else dp[i] = valid(s.charAt(i)-'0',s.charAt(i+1)-'0')? dp[i+1]+dp[i+2]:dp[i+1];
		}
		return dp[0];	
	}
	public boolean valid(int a,int b){
		if(a*10+b<=26) return true;
		return false;
	}
}
