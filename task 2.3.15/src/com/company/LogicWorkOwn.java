package com.company;

import com.company.QueueOwn;

public class LogicWorkOwn {

    public static <T> QueueOwn<Integer> sortingWithConservationOrder(QueueOwn<Integer> queue) throws Exception {

        QueueOwn<Integer> tempPositive = new QueueOwn<>();
        QueueOwn<Integer> tempZero = new QueueOwn<>();
        QueueOwn<Integer> tempNegative = new QueueOwn<>();

        int temp;

        while (queue.getCount() > 0) {
            temp = queue.get();
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
        while (tempNegative.getCount() > 0) {
            queue.add(tempNegative.get());
        }
        while (tempZero.getCount() > 0) {
            queue.add(tempZero.get());
        }
        while (tempPositive.getCount() > 0) {
            queue.add(tempPositive.get());
        }

        return queue;
    }
    public static QueueOwn<Integer> converterIntArrToQueueOwn(int[] ints) {
        QueueOwn<Integer> queue = new QueueOwn<Integer>();
        for (int i = 0; i < ints.length; i++) {
            queue.add(ints[i]);
        }
        return queue;
    }
    public static int[] converterQueueOwnToIntArr(QueueOwn<Integer> queue) throws Exception {
        int[] ints = new int[queue.getCount()];
        for (int i = 0; queue.getCount() > 0; i++) {
            ints[i] = queue.get();
        }

        return ints;
    }
}
