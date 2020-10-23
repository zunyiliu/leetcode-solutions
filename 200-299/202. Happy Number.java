// easy level, use hashSet to track duplicated number
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        
        while(!set.contains(n)){
            set.add(n);
            int newN = 0;
            
            while(n!=0){
                int remainder = n%10;
                newN += remainder*remainder;
                n /= 10;
            }
            
            n = newN;
        }
        
        return n==1;
    }
}
