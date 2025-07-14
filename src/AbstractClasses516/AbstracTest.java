package AbstractClasses516;

public class AbstracTest {
    public static void main(String[] args) {
        //Khi một lớp là trừu tượng thì không thể tạo bất kỳ đối tượng nào của lớp đó
        //Person p = new Person("Van");
        //=> Lỗi

        //Lưu ý rằng bạn vẫn có thể tạo các biến đối tượng của một lớp trừu tượng
        //Nhưng một biến như vậy phải tham chiếu đến một đối tượng của một lớp con không trừu tượng:
        Person n = new Student("Van", "UIT");
        System.out.println(n.getDescription());
    }
}
