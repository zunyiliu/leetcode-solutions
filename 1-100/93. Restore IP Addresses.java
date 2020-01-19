// solution 1: handwriting backtrack, for each bit try if it can generate a valid ip address, move forward if true, 
// back track otherwise
// solution 2: modification of solution 1 making it clearer
class Solution {
	public List<String> restoreIpAddresses(String s){
        List<String> res = new ArrayList();
        recur(res,s,0,-1,-1,-1);
        return res;
    }
    public void recur(List<String> res,String s,int count,int a,int b,int c){
        if(count==3) {
            if (valid(s.substring(c, s.length()))) res.add(dealstr(s, a, b, c));
            return;
        }
        int st;
        if(count==0) st=0;
        else if(count==1) st=a;
        else st = b;
        int size = Math.min(4,s.length()-st);
        for(int i=1;i<size;i++){
            String tp = s.substring(st,st+i);
            if( valid(tp) ){
                if(count==0) recur(res,s,1,st+i,-1,-1);
                else if(count==1) recur(res,s,2,a,st+i,-1);
                else recur(res,s,3,a,b,st+i);
            }
        }
    }
    public boolean valid(String s){
        if(s.charAt(0)=='0' && s.length()>1) return false;
        int num;
        try{
            num = Integer.valueOf(s);
        }catch (Exception e){
            return false;
        }
        if(num<=255 && num>=0) return true;
        return false;
    }
    public String dealstr(String s, int a, int b, int c){
        return s.substring(0,a)+"."+s.substring(a,b)+"."+s.substring(b,c)+"."+s.substring(c,s.length());
    }
}

// solution 2
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList();
        recur(res,s,0,"");
        return res;
    }
    public void recur(List<String> res, String s, int count, String path){
        if(count==4 || s.length()==0){
            if(count==4 && s.length()==0) res.add(path.substring(0,path.length()-1));
        }else{
            int size = s.charAt(0)=='0'? 1:Math.min(s.length(),3);
            for(int i=0;i<size;i++){
                if(valid(s.substring(0,i+1)))
                    recur(res,s.substring(i+1),count+1,path+s.substring(0,i+1)+'.');
            }
        }
    }
    public boolean valid(String s){
        if(Integer.valueOf(s)>=0 && Integer.valueOf(s)<=255) return true;
        return false;
    }
}
