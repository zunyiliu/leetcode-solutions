// solution 1: a tradition naive solution, time wasted


// solution 1
class MedianFinder {
    List<Integer> list;
    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList();
    }
    
    public void addNum(int num) {
        int size = list.size();
        
        if(size==0) list.add(num);
        for(int i=0;i<size;i++){
            if(num<list.get(i)){
                list.add(i,num);
                break;
            }
            if(i==size-1) list.add(num);
        }
  
    }
    
    public double findMedian() {
        int size = list.size();
        if(size==0) return 0;
        if(size%2==0) return ((double)list.get(size/2)+(double)list.get(size/2-1))/2;
        return list.get(size/2);
    }
}
