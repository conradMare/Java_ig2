// Types of Parallelism:
// (a) -> Task parallelism:
//        Divides a program into smaller task that get executed concurrently.
//        Each task can run on a separate thread or processor core.
// (b) -> Data parallelism: (Example below)
//        Processes different parts of the same data concurrently.

package ParallelProcesses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

// Recursive task is generic:
class RecursiveSumTask extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;
    private final int division;

//    Constructor:
    public RecursiveSumTask(long[] numbers, int start, int end, int division) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.division = division;
    }

//    Splitting work:
    @Override
    protected Long compute() {

        if ((end - start) <= (numbers.length / division)) {
            System.out.println(start + " : " + end);
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            RecursiveSumTask leftTask =
                    new RecursiveSumTask(numbers, start, mid, division);
            RecursiveSumTask rightTask =
                    new RecursiveSumTask(numbers, mid, end, division);
            leftTask.fork();
            rightTask.fork();
            return leftTask.join() + rightTask.join();
        }
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        int numbersLength = 100_000;
        long[] numbers = new Random().longs(numbersLength,
                1, numbersLength).toArray();

        long sum = Arrays.stream(numbers).sum();
        System.out.println("sum = " + sum);

//        WorkStealingPool:
//        When running, gets the same sum as running a stream.
//        ExecutorService threadPool = Executors.newWorkStealingPool(4);

//        ForkJoinPool threadPool = (ForkJoinPool) Executors.newWorkStealingPool(4);

//        NOTE -> ForkJoinPool.commonPool();
//        (numbers differ from above, Parallelism = 7, not 4)
        ForkJoinPool threadPool = ForkJoinPool.commonPool();

//        Demonstrating how to split up the task of adding 100_000 numbers in to smaller tasks:
        List<Callable<Long>> tasks = new ArrayList<>();

        int taskNo = 10;
        int splitCount = numbersLength / taskNo;
        for (int i = 0; i < taskNo; i++) {
            int start = i * splitCount;
            int end = start + splitCount;
            tasks.add(() -> {
                long tasksum = 0;
                for (int j = start; j < end; j++) {
                    tasksum += (long) numbers[j];
                }
                return tasksum;
            });
        }

//        Submitting task to thread pool, and waiting for them to complete:
        List<Future<Long>> futures = threadPool.invokeAll(tasks);

        System.out.println("CPUs: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Parallelism = " + threadPool.getParallelism());
        System.out.println("Pool size = " + threadPool.getPoolSize());
        System.out.println("Steal count = " + threadPool.getStealCount());

        long taskSum = 0;
        for (Future<Long> future : futures) {
            taskSum += future.get();
        }

        System.out.println("Thread Pool Sum = " + taskSum);

        //        RecursiveTask<Long> task =
//                new RecursiveSumTask(numbers, 0, numbersLength, 2);
        //        RecursiveTask<Long> task =
//                new RecursiveSumTask(numbers, 0, numbersLength, 4);
        RecursiveTask<Long> task =
                new RecursiveSumTask(numbers, 0, numbersLength, 8);
        long forkJoinSum = threadPool.invoke(task);
        System.out.println("RecursiveTask sum is: " + forkJoinSum);

//        Remember to shut down the threadPool:
        threadPool.shutdown();

//        Class name of stealing the pool:
        System.out.println(threadPool.getClass().getName());
    }
}
