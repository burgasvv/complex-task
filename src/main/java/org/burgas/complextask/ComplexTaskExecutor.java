package org.burgas.complextask;

import java.util.LinkedList;
import java.util.concurrent.*;

public final class ComplexTaskExecutor {

    private final CyclicBarrier cyclicBarrier;

    public ComplexTaskExecutor(int tasks) {
        cyclicBarrier = new CyclicBarrier(tasks, () -> System.out.println("Result"));
    }

    public void executeTasks(int numberOfTasks) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            executorService.invokeAll(
                    new LinkedList<ComplexTask>() {{
                        for (int i = 0; i < numberOfTasks; i++) add(new ComplexTask(cyclicBarrier));
                    }}
            );

            executorService.shutdown();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
