package ObjectWrappersandAutoboxing54;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //Autoboxing
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);  // Compiler biến thành: list.add(Integer.valueOf(3));

        //Unboxing
        int n = list.get(0);  // Compiler biến thành: list.get(0).intValue();
        //Khi dùng Integer như int → Compiler tự động .intValue():

        Integer m = 3;
        m++;  // Compiler: unbox -> int, ++, box lại -> Integer

        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b); // Thường là false
        System.out.println(a.equals(b)); // Luôn true

        //JVM cache các giá trị -128 đến 127:
        Integer a1 = 100;
        Integer b1 = 100;
        System.out.println(a1 == b1); // true vì dùng chung object cache

        int x = Integer.parseInt("123"); // chuyển String → int


    }
}
