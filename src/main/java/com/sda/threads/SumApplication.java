package com.sda.threads;

import java.util.Arrays;

/**
 * Created by RENT on 2017-06-23.
 */
public class SumApplication {
    public static void main(String[] args) throws InterruptedException {
        SumTask sumTask = new SumTask(Arrays.asList(1, 2, 3, 4, 5, 6,7));
        SumTask sumTask2 = new SumTask(Arrays.asList(5,10,15));
        SumTask sumTask3 = new SumTask(Arrays.asList(3,19,81));

//        sumTask.run();
//        sumTask2.run();
//        sumTask3.run();

        Thread thread = new Thread(sumTask);
        Thread thread2 = new Thread(sumTask2);
        Thread thread3 = new Thread(sumTask3);

//        thread3.setPriority(Thread.MIN_PRIORITY);

        thread.start();
        thread2.start();
        thread3.start();

        Thread.sleep(2500);

        System.out.println(Summer.getInstance().getNumbers());
        System.out.println(Summer.getInstance().sumElements());
    }
}
