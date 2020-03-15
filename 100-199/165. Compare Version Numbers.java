// naive, split then compare element by element

class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        
        int len = Math.max(v1.length,v2.length);
        for(int i=0;i<len;i++){
            int a = v1.length-1<i? 0:Integer.valueOf(v1[i]);
            int b = v2.length-1<i? 0:Integer.valueOf(v2[i]);
            if(a<b) return -1;
            if(a>b) return 1;
        }
        return 0;
    }
}
