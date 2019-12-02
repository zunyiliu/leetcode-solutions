//1. backtracking, recursion: go over all the possiblities of combining the final result, the solution of mine is not very efficient
//2. optimization: same idea but more efficient, sort the candidates array firstly so that less number of comibination will be considered
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        recur(candidates,target,arr,list);
        return list;
    }
    public void recur(int[] candidates, int target,List<Integer> arr,List<List<Integer>> list){
        for(int i=0;i<candidates.length;i++){
            if(candidates[i]==target){
                List<Integer> arr1 = new ArrayList<>(arr);
                arr1.add(candidates[i]);
                Collections.sort(arr1);
                if(!list.contains(arr1)){
                    list.add(arr1);
                }
            }else if(candidates[i]<target){
                List<Integer> arr1 = new ArrayList<>(arr);
                arr1.add(candidates[i]);
                recur(candidates,target-candidates[i],arr1,list);
            }
        }
    }
}

//solution 2
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        recur(candidates,target,new ArrayList<>(),list,0);
        return list;
    }
    public void recur(int[] candidates,int target,List<Integer> arr,List<List<Integer>> list,int index){
        for(int i=index;i<candidates.length;i++){
            arr.add(candidates[i]);
            if(candidates[i]==target){
                list.add(new ArrayList<>(arr));
            }else if(candidates[i]<target){
                recur(candidates,target-candidates[i],arr,list,i);
            }
            arr.remove(arr.size()-1);
        }
    }
}
