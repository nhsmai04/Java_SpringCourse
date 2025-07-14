package Object52.HashcodeMethod523;

public class HashcodeTest {
    public static void main(String[] args) {
        int i = 1;
        int i2= 1;
        Object obj = i;
        Object obj2 = i2;
        System.out.println(obj.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj.hashCode() == obj2.hashCode());

        //StringBuilder không override hashCode, nên mặc định nó xài Object.hashCode()
        //String override hashCode để tính toán dựa trên nội dung (content)
        String s = "ok";
        StringBuilder sb = new StringBuilder("ok");
        System.out.println(s.hashCode());
        System.out.println(sb.hashCode());
        System.out.println(s.hashCode() == sb.hashCode());

        Employee e = new Employee("Van", "12");
        Employee e1 = new Employee("Van", "12");
        System.out.println(e.hashCode());
        System.out.println(e1.hashCode());
        System.out.println(e.hashCode() == e1.hashCode());
        System.out.println(e.equals(e1));

    }
}
