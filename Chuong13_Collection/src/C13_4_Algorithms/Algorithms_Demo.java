package C13_4_Algorithms;

import java.util.*;

public class Algorithms_Demo {
	public static void main(String[] args) {
        System.out.println("1. Sắp xếp và trộn danh sách");
        sortAndShuffle();
        System.out.println("\n----------------------------\n");
        System.out.println("2. Tìm kiếm nhị phân");
        binarySearchExample();
        System.out.println("\n----------------------------\n");
        System.out.println("3. reverse, fill, copy");
        reverseFillCopy();
        System.out.println("\n----------------------------\n");
        System.out.println("4. Tìm phần tử nhỏ nhất/lớn nhất");
        minMaxExample();
        System.out.println("\n----------------------------\n");
        System.out.println("5. Viết thuật toán riêng với Iterator - Xoá phần tử dài hơn 4 ký tự");
        filterListWithIterator();
    }

    // 1. Sắp xếp và trộn
    public static void sortAndShuffle() {
        List<String> names = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob", "David"));

        Collections.sort(names);
        System.out.println("Sau khi sắp xếp: " + names);

        Collections.shuffle(names);
        System.out.println("Sau khi trộn: " + names);
    }

    // 2. Tìm kiếm nhị phân
    public static void binarySearchExample() {
        List<String> sorted = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));
        Collections.sort(sorted);
        System.out.println("Danh sách: " + sorted);

        int index1 = Collections.binarySearch(sorted, "Cherry");
        int index2 = Collections.binarySearch(sorted, "Grape");

        System.out.println("Tìm 'Cherry': index = " + index1);
        System.out.println("Tìm 'Grape' (không có): index = " + index2);
    }

    // 3. Đảo ngược, điền, sao chép
    public static void reverseFillCopy() {
        List<String> original = new ArrayList<>(Arrays.asList("One", "Two", "Three"));
        System.out.println("Danh sách gốc: " + original);

        Collections.reverse(original);
        System.out.println("Sau reverse: " + original);

        Collections.fill(original, "X");
        System.out.println("Sau fill với 'X': " + original);

        List<String> copySource = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> copyDest = new ArrayList<>(Arrays.asList("", "", ""));
        Collections.copy(copyDest, copySource);
        System.out.println("Sau copy: " + copyDest);
    }

    // 4. Tìm min/max
    public static void minMaxExample() {
        List<Integer> numbers = Arrays.asList(10, 2, 35, 7, 99);

        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        System.out.println("Danh sách số: " + numbers);
        System.out.println("Giá trị nhỏ nhất: " + min);
        System.out.println("Giá trị lớn nhất: " + max);
    }

    // 5. Xoá phần tử theo điều kiện bằng Iterator
    public static void filterListWithIterator() {
        List<String> items = new ArrayList<>(Arrays.asList("apple", "dog", "banana", "cat", "elephant"));
        System.out.println("Trước: " + items);

        Iterator<String> iter = items.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.length() > 4) iter.remove();
        }

        System.out.println("Sau: " + items);
    }
}
