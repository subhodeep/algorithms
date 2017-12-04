package threads;

public class TaskController {

  public static void main(String[] args) {
    TaskAllocator allocator = new TaskAllocator();
    for (int i = 0; i < 3; i++) {
      Task task = new Task("Task " + i);
      allocator.executeTask(task);
    }
    allocator.endTaskAllocator();
  }

}
