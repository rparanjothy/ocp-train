package com.ram.multithreading;

import java.util.concurrent.*;

public final class Main {
    class Resource {
    }

    static int c = 0;

    void longRunner() throws InterruptedException {
        Thread.sleep(3000);
        c++;
        System.out.println("C incremented after 3 secs" + ": " + c + " : " + Thread.currentThread().getName());
    }

    Runnable task2 = () -> {
        int i = 0;
        while (i < 10) {
            try {
                System.out.println("I am running for :" + i);

                Thread.sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    };

    Runnable task1 =
            () -> {
                while (true) {
                    System.out.println("I am a task running every sec" + ":" + Thread.currentThread().getName());

                    try {
                        Thread.sleep(1000);

//                        let each thread call the longrunner method and lock it with as resource (INTRINSIC)
                        synchronized (Resource.class) {
                            longRunner();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };


    public static void main(String[] args) {
        System.out.println("I am Multithreading");

//        Thread t1 = new Thread(Main.task1);
        Thread t1 = new Thread(new Main().task1);
        Thread t2 = new Thread(new Main().task1);
        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();

        System.out.println(Runtime.getRuntime().availableProcessors());
        /*
        C incremented after 3 secs: 5 : B
        I am a task running every sec:B
        C incremented after 3 secs: 6 : A
        I am a task running every sec:A
        C incremented after 3 secs: 7 : B
        I am a task running every sec:B
         */

//        set # of workers
        ScheduledExecutorService s = Executors.newScheduledThreadPool(4);
//        let it start them
        s.scheduleAtFixedRate(new Main().task2, 1, 1, TimeUnit.SECONDS);
        s.shutdown();
        /*
        I am a task running every sec:A
        I am running for :7
        I am running for :8
        I am running for :9
        C incremented after 3 secs: 3 : B
        I am a task running every sec:B
        I am running for :0
         */


//        Callable Futures; This is diff from Runnable.. you use submit() via the ExecutorService
        Callable<Integer> taskThatRetunsInt = () -> {
            try {
                Thread.sleep(3000);
                return 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return -1;
            }
        };

        ExecutorService exs = Executors.newFixedThreadPool(2);
//        JS Promise
        Future<Integer> ret = exs.submit(taskThatRetunsInt);

        System.out.println(ret);
//        java.util.concurrent.FutureTask@5b464ce8[Not completed, task = com.ram.multithreading.Main$$Lambda$17/0x0000000800065840@30c7da1e]
        try {
//            get(i,Time) is not blocking
            var fromFutue = ret.get(4,TimeUnit.SECONDS);
//            get() is blocking
//            var fromFutue = ret.get();

            System.out.println("From Future: "+fromFutue);

        /*
        If called before completion of the Future..
        java.util.concurrent.TimeoutException
        at java.base/java.util.concurrent.FutureTask.get(FutureTask.java:204)
        at com.ram.multithreading.Main.main(Main.java:111)
         */

        } catch (InterruptedException | ExecutionException | TimeoutException  e) {
//        } catch (InterruptedException | ExecutionException   e) {
            e.printStackTrace();
        }

    }
}
