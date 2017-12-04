package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskAllocator {

  private ThreadPoolExecutor executor;

  public TaskAllocator() {
    executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
  }

  public void executeTask(Task task) {
    System.out.printf("Server: A new task has arrived\n");
    executor.execute(task);
    System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
    System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
    System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
  }
  
  public void endTaskAllocator() {
    executor.shutdown();
    }

}
