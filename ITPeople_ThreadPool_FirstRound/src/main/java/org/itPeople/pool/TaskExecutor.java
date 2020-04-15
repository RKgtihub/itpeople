package org.itPeople.pool;

import java.util.concurrent.atomic.AtomicBoolean;

public class TaskExecutor implements Runnable {
    BlockingQueue<Runnable> queue;
    
    public TaskExecutor(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }
    private AtomicBoolean isThreadPoolShutDownInitiated = new AtomicBoolean(false);

    @Override
    public void run() {
        try {				
            while (true) {
                if(!isThreadPoolShutDownInitiated.get()) {
	                String name = Thread.currentThread().getName();
	                Runnable task = queue.dequeue();
	                System.out.println("Task Started by Thread :" + name);
	                task.run();
	                System.out.println("Task Finished by Thread :" + name);
            
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    public void shutdown() {
		isThreadPoolShutDownInitiated = new AtomicBoolean(true);
	}
	
}