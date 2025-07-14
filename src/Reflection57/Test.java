package Reflection57;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Employee e = new Employee("van", "12");
        Class cl = e.getClass();
        System.out.println(cl.getName());  // "Employee"

        Class cl1 = Class.forName("java.util.Date");
        Object obj = cl1.newInstance();  // Gọi constructor không tham số

        Class cl2 = Employee.class;
        Field[] fields = cl2.getDeclaredFields();
        Method[] methods = cl2.getDeclaredMethods();
        Constructor[] constructors = cl2.getDeclaredConstructors();

        //Sửa Field
        Field f = cl2.getDeclaredField("name");
        f.setAccessible(true);  // Cho phép truy cập field private
        Object value = f.get(e);  // Đọc giá trị
        f.set(e, "New Name");     // Gán giá trị mới
        System.out.println(e.name);


    }
}
