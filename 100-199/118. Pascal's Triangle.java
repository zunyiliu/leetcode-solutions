// easy
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if(numRows==0) return res;
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList();
            if(i!=0) list.add(1);
            if(i>1){
                List<Integer> tmp = res.get(res.size()-1);
                for(int j=0;j<tmp.size()-1;j++){
                    list.add(tmp.get(j)+tmp.get(j+1));
                }
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
