package Object52.toStringMethod524;


import java.util.Arrays;

public class toStringTest {
    public static void main(String[] args) {
        Manager m = new Manager("Van", "12", 12000);
        System.out.println(m);

        Employee e = new Employee("Van", "12");
        System.out.println(e);

        System.out.println(System.out);

        int[] i = {1,2, 3, 4, 5, 6};
        System.out.println("" + i);
        System.out.println(Arrays.toString(i));
    }
}
