package C14_8_Callables_Futures;

import java.util.*;
import java.util.concurrent.*;

//  Demo đếm số lượng từ khóa xuất hiện trong 3 chuỗi văn bản khác nhau bằng các Callable và lấy kết quả qua Future

public class Callables_Futures_Demo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
        String keyword = "java";

        List<String> texts = Arrays.asList(
        		"A thread is a single sequential flow of control within a program.",
                "Java provides built-in support for multithreaded programming.",
                "Each thread shares memory space with other threads in the same process.",
                "Thread synchronization is critical to avoid race conditions.",
                "In Java, you can create threads using the Thread class or the Runnable interface.",
                "The Executor framework provides a higher-level replacement for managing threads."
        );

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> results = new ArrayList<>();

        for (String text : texts) {
            Callable<Integer> task = () -> countOccurrences(text, keyword);
            Future<Integer> future = executor.submit(task);
            results.add(future);
        }

        int total = 0;
        for (int i = 0; i < results.size(); i++) {
            int count = results.get(i).get(); 
            System.out.println("Text " + (i + 1) + " contains " + count + " occurrences.");
            total += count;
        }

        System.out.println("Total occurrences of keyword \"" + keyword + "\": " + total);

        executor.shutdown();
    }

    // Đếm số lần xuất hiện
    private static int countOccurrences(String text, String keyword) {
        String[] words = text.toLowerCase().split("\\W+");
        int count = 0;
        for (String word : words) {
            if (word.equals(keyword.toLowerCase())) {
                count++;
            }
        }
        return count;
    }
}
