// two pointers, easy

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int st = 0, end = numbers.length-1;
        int [] res = new int[2];
        while(st<end){
            int cur = numbers[st]+numbers[end];
            if(cur==target){
                res[0] = st+1;
                res[1] = end+1;
                return res;
            }else if(cur<target){
                st++;
            }else{
                end--;
            }
        }
        return res;
    }
}
