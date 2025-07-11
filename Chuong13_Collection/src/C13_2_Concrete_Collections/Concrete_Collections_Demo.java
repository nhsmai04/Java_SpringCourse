package C13_2_Concrete_Collections;

import java.util.*;

public class Concrete_Collections_Demo {
	public static void main(String[] args) {
        System.out.println("1. So sánh ArrayList và LinkedList");
        demoListPerformance();
        System.out.println("\n----------------------------\n");
        System.out.println("2. So sánh HashSet và TreeSet");
        demoSetComparison();
        System.out.println("\n----------------------------\n");
        System.out.println("3. Sắp xếp Item bằng Comparable và Comparator");
        demoItemSorting();
        System.out.println("\n----------------------------\n");
        System.out.println("4. Queue vs PriorityQueue");
        demoQueueVsPriorityQueue();
    }

    // 1. ArrayList vs LinkedList: thêm/xóa đầu, cuối, giữa
    public static void demoListPerformance() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        final int SIZE = 100_000;

        // Thêm vào cuối
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) arrayList.add(i);
        long arrayAddEnd = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) linkedList.add(i);
        long linkedAddEnd = System.nanoTime() - start;

        // Thêm vào đầu
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) arrayList.add(0, -1);
        long arrayAddFront = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) linkedList.add(0, -1);
        long linkedAddFront = System.nanoTime() - start;
        
        // Thêm vào giữa
        int middleIndex = arrayList.size() / 2;
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) arrayList.add(middleIndex, -1);
        long arrayAddMiddle = System.nanoTime() - start;

        middleIndex = linkedList.size() / 2;
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) linkedList.add(middleIndex, -1);
        long linkedAddMiddle = System.nanoTime() - start;

        System.out.printf("Thêm vào cuối (LinkedList): %d ns\n", linkedAddEnd);
        System.out.printf("Thêm vào cuối (ArrayList): %d ns\n", arrayAddEnd);
        System.out.printf("Thêm vào đầu (LinkedList): %d ns\n", linkedAddFront);
        System.out.printf("Thêm vào đầu (ArrayList): %d ns\n", arrayAddFront);
        System.out.printf("Thêm vào giữa (LinkedList): %d ns\n", linkedAddMiddle);
        System.out.printf("Thêm vào giữa (ArrayList): %d ns\n", arrayAddMiddle);
        System.out.printf("\n=> Thêm vào đầu/cuối danh sách thì nên chọn LinkedList, còn thêm vào giữa thì nên chọn ArrayList\n", arrayAddMiddle);
    }

    // 2. So sánh HashSet và TreeSet
    public static void demoSetComparison() {
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();

        String[] data = {"Tom", "Jerry", "Mickey", "Tom", "Anna"};
        hashSet.addAll(Arrays.asList(data));
        treeSet.addAll(Arrays.asList(data));

        System.out.println("HashSet (không thứ tự, không trùng): " + hashSet);
        System.out.println("TreeSet (có thứ tự, không trùng): " + treeSet);
    }

    // 3. So sánh Comparable và Comparator
    public static void demoItemSorting() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(3, "Banana"));
        items.add(new Item(1, "Apple"));
        items.add(new Item(2, "Orange"));

        System.out.println("Theo ID (Comparable):");
        Collections.sort(items);
        items.forEach(System.out::println);

        System.out.println("Theo Mô tả (Comparator):");
        items.sort(Comparator.comparing(Item::getDescription));
        items.forEach(System.out::println);
    }

    // 4. So sánh Queue và PriorityQueue
    public static void demoQueueVsPriorityQueue() {
        Queue<String> queue = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();

        String[] names = {"Charlie", "Alice", "Bob"};
        queue.addAll(Arrays.asList(names));
        pq.addAll(Arrays.asList(names));

        System.out.print("Queue thường: ");
        while (!queue.isEmpty()) System.out.print(queue.remove() + " ");

        System.out.print("\nPriorityQueue (theo thứ tự): ");
        while (!pq.isEmpty()) System.out.print(pq.remove() + " ");
    }
}

