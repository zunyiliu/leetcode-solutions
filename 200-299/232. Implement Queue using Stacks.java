class MyQueue {
    Stack<Integer> a;
    Stack<Integer> b;
    /** Initialize your data structure here. */
    public MyQueue() {
        a = new Stack();
        b = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        a.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!b.isEmpty()) {
            return b.pop();
        }
        
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        return b.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!b.isEmpty()) return b.peek();
        
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        return b.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return b.isEmpty() && a.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
