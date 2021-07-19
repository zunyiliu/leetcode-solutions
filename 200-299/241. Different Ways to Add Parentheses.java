// solution 1: recursion
// solution 2: recursion with DP, as there are many duplicated substrings, use a map to store those substrings as keys and their results as values

// solution 1
class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                List<Integer> left = diffWaysToCompute(exp.substring(0,i));
                List<Integer> right = diffWaysToCompute(exp.substring(i+1));
                
                for (Integer l: left) {
                    for (Integer r: right) {
                        if (ch == '-') list.add(l-r);
                        else if (ch == '+') list.add(l+r);
                        else list.add(l*r);
                    }
                }
            }
        }
        
        if (list.size()==0) {
            list.add(Integer.valueOf(exp));
        }
        
        return list;
    }
}

// solution 2
class Solution {
    Map<String,List<Integer>> map;
    public List<Integer> diffWaysToCompute(String exp) {
        map = new HashMap();
        return recur(exp);
    }
    
    public List<Integer> recur(String exp) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                String lexp = exp.substring(0,i);
                String rexp = exp.substring(i+1);
                List<Integer> left, right;
                
                if (map.containsKey(lexp)) {
                    left = map.get(lexp);
                } else {
                    left = diffWaysToCompute(lexp);
                }
                
                if (map.containsKey(rexp)) {
                    right = map.get(rexp);
                } else {
                    right = diffWaysToCompute(rexp);
                }
                
                for (Integer l: left) {
                    for (Integer r: right) {
                        if (ch == '-') list.add(l-r);
                        else if (ch == '+') list.add(l+r);
                        else list.add(l*r);
                    }
                }
            }
        }
        
        if (list.size()==0) {
            list.add(Integer.valueOf(exp));
        }
        
        map.put(exp,list);
        return list;
    }
}
