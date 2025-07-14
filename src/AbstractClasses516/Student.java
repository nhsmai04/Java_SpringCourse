package AbstractClasses516;

public class Student extends Person {
    private String SchoolName;
    public Student(String name, String schoolName) {
        super(name);
        this.SchoolName = schoolName;
    }
    @Override
    public String getDescription() {
        return "My name is " + this.getName() + " and my school is " + SchoolName;
    }
}
