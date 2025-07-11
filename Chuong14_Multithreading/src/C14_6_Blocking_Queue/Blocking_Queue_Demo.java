package C14_6_Blocking_Queue;

import java.util.concurrent.*;

//  Dùng ArrayBlockingQueue để hạn chế kích thước hàng đợi

public class Blocking_Queue_Demo {
	private static final int QUEUE_CAPACITY = 5;
    private static final int FILES_TO_PROCESS = 10;
    private static final int CONSUMERS = 3;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= FILES_TO_PROCESS; i++) {
                    String file = "File-" + i;
                    queue.put(file); // sẽ block nếu hàng đợi đầy
                    System.out.println("[Producer] Added: " + file);
                    Thread.sleep(100); // mô phỏng thời gian tạo file
                }
                for (int i = 0; i < CONSUMERS; i++) {
                    queue.put("DONE"); 
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer threads
        Thread[] consumers = new Thread[CONSUMERS];
        for (int i = 0; i < CONSUMERS; i++) {
            int id = i;
            consumers[i] = new Thread(() -> {
                try {
                    while (true) {
                        String file = queue.take(); 
                        if ("DONE".equals(file)) break;
                        System.out.println("[Consumer-" + id + "] Processing: " + file);
                        Thread.sleep(200); 
                    }
                    System.out.println("[Consumer-" + id + "] Done.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        producer.start();
        for (Thread c : consumers) c.start();

        producer.join();
        for (Thread c : consumers) c.join();

        System.out.println("All work done.");
    }
}
