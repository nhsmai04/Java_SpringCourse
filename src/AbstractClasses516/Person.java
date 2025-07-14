package AbstractClasses516;

public abstract class Person {
    //Lớp trừu tượng có thể có các fields để lưu trữ thông tin chung
    private String name;

    public Person(String name) {
        this.name = name;
    }

    //Phương thức trừu tượng
    public abstract String getDescription();

    //Lớp trừu tượng có thể có phương thức bình thường (có phần thân)
    public String getName(){
        return name;
    }
}
