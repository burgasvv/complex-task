package org.burgas.complextask;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public final class ComplexTask implements Callable<String> {

    private final CyclicBarrier cyclicBarrier;

    public ComplexTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public String call() throws BrokenBarrierException, InterruptedException {
        System.out.println("Complex task");
        this.execute();
        this.cyclicBarrier.await();
        return "Finish";
    }

    private void execute() {
        System.out.println("Part of a complex task");
    }
}
