package C13_3_Collections_Framework;

import java.util.*;

public class Collections_Framework_Demo {
	public static void main(String[] args) {
        System.out.println("1. Demo Arrays.asList() và lỗi khi thêm phần tử");
        demoArraysAsList();
        System.out.println("\n----------------------------\n");
        System.out.println("2. Demo unmodifiableList và checkedList");
        demoUnmodifiableAndCheckedList();
        System.out.println("\n----------------------------\n");
        System.out.println("3. Demo retainAll()");
        demoRetainAll();
    }

    // 1. Arrays.asList và UnsupportedOperationException
    public static void demoArraysAsList() {
        try {
            List<String> fixedList = Arrays.asList("A", "B", "C");
            fixedList.add("D"); // sẽ gây lỗi
        } catch (UnsupportedOperationException e) {
            System.out.println("Lỗi khi thêm phần tử vào danh sách từ Arrays.asList(): " + e);
        }
    }

    // 2. UnmodifiableList và CheckedList
    public static void demoUnmodifiableAndCheckedList() {

        // unmodifiableList
        try {
            List<String> modifiable = new ArrayList<>();
            modifiable.add("Hello");
            List<String> unmodifiable = Collections.unmodifiableList(modifiable);
            unmodifiable.add("World");
        } catch (UnsupportedOperationException e) {
            System.out.println("Không thể thêm phần tử vào unmodifiableList: " + e);
        }

        // checkedList
        try {
            List<String> checked = Collections.checkedList(new ArrayList<>(), String.class);
            Object obj = Integer.valueOf(42);
            @SuppressWarnings("unchecked")
            List raw = checked;
            raw.add(obj); // lỗi kiểu
        } catch (ClassCastException e) {
            System.out.println("Không thể thêm phần tử sai kiểu vào checkedList: " + e);
        }
    }

    // 3. Demo retainAll 
    public static void demoRetainAll() {
        List<String> listA = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        List<String> listB = Arrays.asList("B", "C", "X");

        System.out.println("listA trước retainAll listB: " + listA);
        listA.retainAll(listB);
        System.out.println("listA sau retainAll listB: " + listA);
    }
}
