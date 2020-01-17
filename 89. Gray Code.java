// you can get observation that for each existing array of n-1 bits, the nth new bit is to add a leading 1 and 0 respectively to 
// all elements
// e.g 00 01 11 10 add new array -- 110 111 101 100 --> 000 001 011 010 110 111 101 100

class Solution{
	public List<Integer> grayCode(int n){
        List<Integer> res = new ArrayList();
        res.add(0);
		for(int i=0;i<n;i++){
            int s = res.size();
            for(int k=s-1;k>=0;k--){
                res.add(res.get(k)|1<<i);
            }
        }
        return res;
	}
}
