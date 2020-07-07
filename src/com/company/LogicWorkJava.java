package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LogicWorkJava {

    public static <T> Queue<Integer> sortingWithConservationOrder(Queue<Integer> queue) throws Exception {

        Queue<Integer> tempPositive = new LinkedList<>();
        Queue<Integer> tempZero = new LinkedList<>();
        Queue<Integer> tempNegative = new LinkedList<>();

        int temp;

        while (queue.peek() != null) {
            temp = queue.poll();
            if (temp < 0) {
                tempNegative.add(temp);
            }
            if (temp == 0) {
                tempZero.add(temp);
            }
            if (temp > 0) {
                tempPositive.add(temp);
            }
        }
        while (tempNegative.peek() != null) {
            queue.add(tempNegative.poll());
        }
        while (tempZero.peek() != null) {
            queue.add(tempZero.poll());
        }
        while (tempPositive.peek() != null) {
            queue.add(tempPositive.poll());
        }

        return queue;
    }
    public static Queue<Integer> converterIntArrToQueueJava(int[] ints) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < ints.length; i++) {
            queue.add(ints[i]);
        }
        return queue;
    }
    public static int[] converterQueueJavaToIntArr(Queue<Integer> queue) throws Exception {

        List<Integer> lists = new ArrayList<>();

        while (queue.peek() != null) {
            lists.add(queue.poll());
        }
        int[] ints = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            ints[i] = lists.get(i);
        }

        return ints;
    }
}
