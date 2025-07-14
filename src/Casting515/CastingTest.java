package Casting515;

class People {
    public String name;
    public int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Animal {
    public String name;
    public int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Manager extends People {
    public Manager(String name, int age) {
        super(name, age);
    }
}

public class CastingTest {
    public static void main(String[] args) {
        //Ép kiểu thông thường
        double x = 3.405;
        int nx = (int) x;
        System.out.println(nx);
        System.out.println(x);

        //cast of an object reference
        People p = new People("Van", 21);
        Manager m = new Manager("Van", 21);
        //Promise less
        People k = m; //ở đây đúng là vì biến này ít nhất cũng là People nhưng cũng có thể là Manager
        // =>Trình biên dịch cho phép ngay, không cần ép kiểu.
        System.out.println(k.name);
        //Gặp lỗi khi mà:

        //Promise more
        //Manager l = (Manager) p; //ép kiểu xuống
        //Ở đây Compiler vẫn cho phép ép kiểu vì nó không chắc p là Manager thật không
        //Tuy nhiên khi chạy thì JVM sẽ kiểm tra và p không phải Manager nên báo lỗi

        //Ép kiểu mà không có sự liên quan về lớp con và cha => Bị lỗi
        //Animal a = (Animal) p;

        //Dùng instanceof
        if(p instanceof Manager) {
            Manager m2 = (Manager)p;
            System.out.println("Cast succesfully");
        }
        //Dùng instanceof để kiểm tra trước khi ép kiểu giúp tránh gặp lỗi
    }
}
