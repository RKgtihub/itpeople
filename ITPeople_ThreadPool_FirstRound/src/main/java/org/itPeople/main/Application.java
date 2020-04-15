package org.itPeople.main;

import org.itPeople.pool.ThreadPool;

public class Application {
    public static void main(String[] args) throws InterruptedException {
    	//create queue size - 3
    	//Number of threads - 4
        ThreadPool threadPool = new ThreadPool(3,4);
        //Created 15 Tasks and submit to pool
        for(int taskNumber = 1 ; taskNumber <= 7; taskNumber++) {
        	RunTask task = new RunTask(taskNumber);
            threadPool.submitTask(task);
        }
        threadPool.shutdown();
    }
}