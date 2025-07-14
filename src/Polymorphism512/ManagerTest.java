package Polymorphism512;

public class ManagerTest
{
    public static void main(String[] args)
    {
        System.out.println("--- Demo 1: Gán lớp con cho biến lớp cha ---");
        Manager ceo = new Manager("Alice", 100000.0, 2004, 12, 30);
        Employee e = ceo; //Upcasting: ép kiểu đối tượng của lớp con theo kiểu của lớp cha
        System.out.println(e);
        //Mặc dù e được khai báo là Employee, nhưng phương thức của đối tượng thực sự (Manager) được gọi.
        System.out.println("\n--- Demo 2: Mảng các đối tượng Employee (đa hình) ---");
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Bob", 50000.0, 2000, 12, 10);
        staff[1] = new Manager("Charlie", 80000.0, 2000, 12, 10);
        staff[2] = new Employee("David", 60000.0, 2000, 12, 10);
        System.out.println("Hiển thị thông tin tất cả nhân viên:");
        for (Employee emp : staff) {
            System.out.println(emp); // Tính đa hình tại đây: phương thức được gọi khác nhau tùy loại đối tượng
        }
        System.out.println("\n--- Demo 3: Không thể gán lớp cha cho biến lớp con ---");
        //Manager m = new Employee("Frank", 40000.0, 2000, 12, 10);

    }
}