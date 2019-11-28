1. My solution: recursion--left bracket and right bracket will both start from n, standing for remaining of left/right brackets
   a. you must stop when left==0
   b. if left < right, there're two results, append a '(' or a ')'
   c. if left == right, one result -- append a '('
   d. it's impossible that left>right(invalid bracket)
2. brute force: permutation all possible brackets' combinations, if it's valid add to the List
3. separate n l/r brackets into -- '('+a+')'+b and a+b+1=n, enumerate all solutions by breaking them into small parts

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        perm(n,n,"",res);
        return res;
    }
    public void perm(int l,int r,String current,List<String> result){
        if(l==0){
            for(int i=0;i<r;i++) current+=')';
            result.add(current);
            return;
        }
        
        perm(l-1,r,current+'(',result);
        if(l<r){
            perm(l,r-1,current+')',result);
        }
    }
}
