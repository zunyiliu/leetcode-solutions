class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList();
        List<Integer> pre = new ArrayList();
        res.add(1);
        if(rowIndex==0) return res;
        res.add(1);
        if(rowIndex==1) return res;
        for(int i=2;i<=rowIndex;i++){
            pre = res;
            res = new ArrayList();
            res.add(1);
            for(int j=0;j<pre.size()-1;j++){
               res.add(pre.get(j)+pre.get(j+1)); 
            }
            res.add(1);
        }
        return res;
    }
}
