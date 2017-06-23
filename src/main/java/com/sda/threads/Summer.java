package com.sda.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-06-23.
 */
public class Summer {

    private static Summer ourInstance = null;

    public synchronized static Summer getInstance() {
        if (ourInstance == null) {
            ourInstance = new Summer();
        }
        return ourInstance;
    }

    private List<Integer> list = new ArrayList<>();

    public synchronized void add(int sum) {
        list.add(sum);
    }

    public int sumElements() {
        return list.stream().mapToInt(e -> e).sum();
     }

    private Summer() {
    }

    public String getNumbers() {
        return  list.toString();
    }

    public synchronized void test() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("elo");
    }
}
