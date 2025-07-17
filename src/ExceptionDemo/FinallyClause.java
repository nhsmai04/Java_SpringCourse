import java.util.Scanner;

public class FinallyClause {

    // Trường hợp 1: Không lỗi
    public static void testFinally1() {
        try {
            int data = 25 / 5;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("Quit");
    }

    // Trường hợp 2: ArithmeticException
    public static void testFinally2() {
        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("Quit");
    }

    // Trường hợp 3: return trong try
    public static void testFinally3() {
        try {
            int data = 25 / 5;
            System.out.println(data);
            return;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("Quit");
    }

    // Trường hợp 4: finally có return → che mất return trong try
    public static int testFinally4() {
        try {
            System.out.println("Trong try, chuẩn bị return 1");
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        } finally {
            System.out.println("Trong finally, return 2 (ghi đè return ở try)");
            return 2;
        }
    }

    // Trường hợp 5: System.exit(0) → finally không chạy
    public static void testFinally5() {
        try {
            System.out.println("Trong try, gọi System.exit(0)");
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed (nhưng không chạy được vì exit)");
        }
    }

    // Trường hợp 6: finally đóng tài nguyên thủ công
    public static void testFinally6() {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.print("Nhập tên của bạn: ");
            String name = sc.nextLine();
            System.out.println("Xin chào, " + name);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (sc != null) {
                sc.close();
                System.out.println("Scanner đã được đóng trong finally.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Test 1 ===");
        testFinally1();

        System.out.println("\n=== Test 2 ===");
        try {
            testFinally2();
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException in main: " + e);
        }

        System.out.println("\n=== Test 3 ===");
        testFinally3();

        System.out.println("\n=== Test 4 ===");
        int result4 = testFinally4();
        System.out.println("Giá trị trả về: " + result4);

        System.out.println("\n=== Test 5 ===");
        testFinally5(); // Sau đây chương trình sẽ kết thúc, các test sau không chạy nếu bật lên.

        // Nếu bạn muốn test testFinally6, hãy comment testFinally5 để không bị exit.
        System.out.println("\n=== Test 6 ===");
        testFinally6();
    }
}
