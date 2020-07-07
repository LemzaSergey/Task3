package com.company;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

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
    private int count = 0;
    
    /**
     * Добавление элемента в стек
     * @param value 
     */
    public void push(T value) {
        head = new ListNode(value, head);
        count++;
    }
    
    public T peek() throws Exception {
        if (head == null) {
            throw new Exception("Stack is empty!");
        }
        return head.value;
    }
    
    public T pop() throws Exception {
        T result = peek();
        head = head.next;
        count--;
        return result;
    }
    
    public int getCount() {
        return count;
    }
    
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ListNode curr = head;
                       
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T res = curr.value;
                curr = curr.next;
                return res;
            }
        };
    }
    
    /*
    public Iterator<T> iterator() {
        class TempClass implements Iterator<T> {
            private ListNode curr = head;
            
            @Override
            public boolean hasNext() {
                
            }

            @Override
            public T next() {
                
            }
        }
        
        return new TempClass();
    }
    */
}
