package com.sda.counter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by RENT on 2017-06-23.
 */
public class CounterSummaryProvider {

    private static CounterSummaryProvider ourInstance = new CounterSummaryProvider();


    public synchronized static CounterSummaryProvider getInstance() {
        return ourInstance;
    }

    private List<Integer> list;



    private Iterator<Integer> integerIterator;

    private CounterSummaryProvider() {
        initList();
        this.integerIterator = list.iterator();
            }

    private void initList() {
        this.list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt());
        }
    }

    public synchronized int getNextValue() {
        return integerIterator.next();
    }

    public synchronized boolean hasNext() {
        return true;
    }
}
