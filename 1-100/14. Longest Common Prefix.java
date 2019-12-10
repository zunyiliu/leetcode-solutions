class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        for(int pointer=0;pointer<strs[0].length();pointer++){
            for(int i=1;i<strs.length;i++){
                if(pointer==strs[i].length() ||
                   strs[i].charAt(pointer)!=strs[0].charAt(pointer)){
                    return strs[i].substring(0,pointer);
                }
            }
        }
        return strs[0];
    }
}
