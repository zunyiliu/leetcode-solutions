// solution 1: a tradition naive solution, time wasted
// solution 2: use two heaps(priorityqueue here), one maxHeap and another minHeap, O(logn) add operation and O(1) findMedian operation

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

// solution 2
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue( (i1,i2)->(int)i2-(int)i1 );
        minHeap = new PriorityQueue( (i1,i2)->(int)i1-(int)i2 );
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0){
            maxHeap.add(num);
            return;
        }
        
        if(maxHeap.size() > minHeap.size()){
            if(maxHeap.peek() > num) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }else {
                minHeap.add(num);
            }
        }else{
            if(maxHeap.peek() > num) maxHeap.add(num);
            else{
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return ((double)maxHeap.peek()+(double)minHeap.peek())/2;
    }
}
