1. Brute force -- collecting all nodes into an array, sort them and create a new list within sorted array nlogn complexity
2. compare one by one -- each time compare k nodes, and select the smallest adding to the tail of the list kn complexity
3. divide and conquer -- merge two lists once, and then continue merge them. e.g list[1,2,3,4], you merge 1,2 and 3,4 to become
1' and 2', then you merge 1' and 2' to get the result

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//solution 1 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> res = new ArrayList<>();
            
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp!=null){
                res.add(temp);
                temp = temp.next;
            }
        }
        if(res.size()==0) return null;
        
        //quicksort
        res = quicksort(res);
        for(int i=0;i<res.size()-1;i++){
            res.get(i).next = res.get(i+1);
        }
        res.get(res.size()-1).next = null;
        return res.get(0);
    }
    
    public List<ListNode> quicksort(List<ListNode> res){
        if(res.size()<=1) return res;
        
        int pivot = res.size()/2;
        int pivot_val = res.get(pivot).val;
        List<ListNode> l = new ArrayList<>();
        List<ListNode> r = new ArrayList<>();
        
        for(int i=0;i<res.size();i++){
            if(i!=pivot)
            if(res.get(i).val<pivot_val){
                l.add(res.get(i));
            }else{
                r.add(res.get(i));
            }
        }
        
        l = quicksort(l);
        r = quicksort(r);
        l.add(res.get(pivot));
        l.addAll(r);
        return  l;
    }
}

//solution 2
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> res = new ArrayList<>(); 
        
        while(true){
            int smallest = 999999;
            int index = 0;
            boolean stop = true;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null && smallest>lists[i].val){
                    stop = false;
                    smallest = lists[i].val;
                    index = i;
                }
            }
            if(!stop){
                res.add(lists[index]);
                lists[index] = lists[index].next;
                if(res.size()>1){
                    res.get(res.size()-2).next = res.get(res.size()-1);
                }
            }else{
                break;
            }
        }
        if(res.size()==0) return null;
        return res.get(0);
    }
    
}
