package Object52.EqualsMethod521;

public class EqualsTest {
    public static void main(String[] args) {
        Employee e = new Employee("Van", "12");
        Employee e2 = new Employee("Van", "12");
        System.out.println(e.equals(e2));

        Manager m = new Manager("Van", "12", 12000);
        Manager m2 = new Manager("Van", "12", 13000);
        System.out.println(m.equals(m2));

        System.out.println(e.equals(m));

        System.out.println(m.equals(e));




    }
}
