package com.sda.counter;

import com.sda.threads.Summer;

import java.util.List;

/**
 * Created by RENT on 2017-06-23.
 */
public class CounterTask implements Runnable {

    private List<Integer> list;

    public CounterTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

      CounterSummaryProvider provider = CounterSummaryProvider.getInstance();
      CounterSummaryService service =  CounterSummaryService.getInstance();
      int threadCounter = 0;
      while (provider.hasNext()) {
          int nextValue = provider.getNextValue();
          threadCounter++;
          if (nextValue % 2 == 0) {
              service.increaseCounter();
          }
      }
        System.out.println("Proceeded: " + threadCounter);
    }
}
