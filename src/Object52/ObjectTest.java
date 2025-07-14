package Object52;

public class ObjectTest {
    public static void main(String[] args) {
        //Có thể sử dụng biến kiểu Object để tham chiếu đến các đối tượng thuộc bất kỳ kiểu nào.
        Object obj = new Person("Van");

        //Tuy nhiên bạn không thể sử dụng biến kiểu Object để gọi phương thức của lớp Person
        //System.out.println(obj.getName());
        // => Lỗi

        //Để gọi phương thức thuộc lớp Person thì phải ép kiểu
        Person p = (Person) obj;
        System.out.println(p.getName());
    }
}
