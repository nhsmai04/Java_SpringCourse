package ObjectCloning62;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Employee original = new Employee("Van", "12", date);
        Employee copy = original.clone();
        copy.setName("van");// OK - original không bị đổi
        System.out.println(copy.getName());
        System.out.println(original.getName());
    }
}
