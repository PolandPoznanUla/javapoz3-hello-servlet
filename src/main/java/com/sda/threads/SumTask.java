package com.sda.threads;

import java.util.List;

/**
 * Created by RENT on 2017-06-22.
 */
public class SumTask implements Runnable {

    private List<Integer> list;

    public SumTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        list.stream()
//                .collect(e -> e)
        int sum = list.stream().mapToInt(e -> e).sum();
        Summer.getInstance().add(sum);
//        long first = System.currentTimeMillis();
//        for (int i = 0; i < list.size(); i++) {

        Summer.getInstance().test();
        }
    }


//}
