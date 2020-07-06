package com.company;


public class QueueOwn<T> {
    
    private class ListNode {

        T value;
        ListNode next;

        ListNode(T value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        ListNode() {
            this(null, null);
        }
    }
    
    private ListNode head = null;
    private ListNode tail = null;
    private int count = 0;
    
    
    public void add(T value) {
        if (head == null) {        
            head = tail = new ListNode(value, null);
        } else {
            tail.next = new ListNode(value, null);
            tail = tail.next;
        }
        count++;
    }
    
    public T get() throws Exception {
        if (head == null) {
            throw new Exception("Queue is empty!");
        }
        T result = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        count--;
        return result;
    }
    
    public int getCount() {
        return count;
    }
}
