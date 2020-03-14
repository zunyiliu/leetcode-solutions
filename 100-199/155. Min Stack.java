// solution 1: use native structure to build the min stack, two pointers for min stack one for head, the other for the minhead which holds
// min values. two pointers for Node, one pointeer pointing to the next node, the other pointing to the next node which holds min val

// solution 2: use two stacks

class MinStack {
    Node head;
    Node minhead;
    
    /** initialize your data structure here. */
    public MinStack() {
        head = new Node(-1);
        minhead = new Node(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        Node n = new Node(x);
        n.next = head;
        head = n;
        
        if(n.val<minhead.val){
            n.minnext = minhead;
            minhead = n;
        }
    }
    
    public void pop() {
        Node pre = head;
        head = head.next;
        
        if(pre==minhead) minhead = minhead.minnext;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return minhead.val;
    }
    class Node{
        int val;
        Node next;
        Node minnext;
        public Node(int val){
            this.val = val;
        }
    }
}

// solution 2
