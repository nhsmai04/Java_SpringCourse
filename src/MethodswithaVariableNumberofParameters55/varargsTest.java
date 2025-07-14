package MethodswithaVariableNumberofParameters55;


import java.util.Arrays;

public class varargsTest {
    public static void print(String... args) {
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) {
        print();              // không tham số cũng được
        print("A");           // 1 tham số
        print("A", "B", "C"); // nhiều tham số
        String[] a = {"A", "B", "C"};
        print(a);             // truyền sẵn mảng


    }
}
