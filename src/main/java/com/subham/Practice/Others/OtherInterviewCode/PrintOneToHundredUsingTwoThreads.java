package com.subham.Practice.Others.OtherInterviewCode;

public class PrintOneToHundredUsingTwoThreads {

    public static void main(String[] args) {

        Object lock = new Object();
        int max = 20;
        int[] counter = {1};

        Runnable oddPrintObj = () -> {
            try {
                while (true) {
                    synchronized (lock) {
                        if (counter[0] > max) {
                            lock.notifyAll();
                            break;
                        }
                        while (counter[0] % 2 == 0 && counter[0] <= max) {
                            lock.wait();
                        }
                        if (counter[0] > max) {
                            break;
                        }
                        System.out.println(counter[0]++);
                        lock.notifyAll();
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Runnable evenPrintObj = () -> {
            try {
                while (true) {
                    synchronized (lock) {
                        if (counter[0] > max) {
                            lock.notifyAll();
                            break;
                        }
                        while (counter[0] % 2 != 0 && counter[0] <= max) {
                            lock.wait();
                        }
                        if (counter[0] > max) {
                            break;
                        }
                        System.out.println(counter[0]++);
                        lock.notifyAll();
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(oddPrintObj);
        t1.start();

        Thread t2 = new Thread(evenPrintObj);
        t2.start();

    }
}











