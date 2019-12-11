// solution 1: recursively add new combination to List<> res, use hashmap to record and get char-String
// solution 2: same concept but use for loop instead of recursion

//solution 1
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> memo = new HashMap<>();
        memo.put('2',"abc");
        memo.put('3',"def");
        memo.put('4',"ghi");
        memo.put('5',"jkl");
        memo.put('6',"mno");
        memo.put('7',"pqrs");
        memo.put('8',"tuv");
        memo.put('9',"wxyz");
        StringBuilder str = new StringBuilder();
        List<String> res = new ArrayList<>();
        
        recur(memo,str,res,digits);
        return res;
    }
    public void recur(HashMap<Character,String> memo,StringBuilder str,List<String> res,String digits){
        if(digits.equals("")){
            if(str.length()!=0) res.add(str.toString());
            return;
        }
        String temp = memo.get(digits.charAt(0));
        if(temp!=null){
            for(int i=0;i<temp.length();i++){
                StringBuilder str1 = new StringBuilder(str);
                recur(memo,str1.append(temp.charAt(i)),res,digits.substring(1));
            }
        }
    }
}

//solution 2
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> memo = new HashMap<>();
        memo.put('2',"abc");
        memo.put('3',"def");
        memo.put('4',"ghi");
        memo.put('5',"jkl");
        memo.put('6',"mno");
        memo.put('7',"pqrs");
        memo.put('8',"tuv");
        memo.put('9',"wxyz");
        StringBuilder str = new StringBuilder();
        List<String> res = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            String temp = memo.get(digits.charAt(i));
            if(temp!=null){
                if(res.size()==0){
                    for(int x=0;x<temp.length();x++){
                        res.add(temp.charAt(x)+"");
                    }
                }else{
                    List<String> res1 = new ArrayList<>();
                    for(int j=0;j<res.size();j++){
                        for(int x=0;x<temp.length();x++){
                            res1.add(res.get(j)+temp.charAt(x));
                        }
                    }
                    res = res1;
                }
            }
        }
        return res;
    }
}
