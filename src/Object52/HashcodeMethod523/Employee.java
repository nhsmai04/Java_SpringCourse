package Object52.HashcodeMethod523;

import java.util.Objects;

public class Employee {
    protected String name;
    protected String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {

        //Kiểm tra nhanh xem các đối tượng có giống hệt nhau không
        if (this == obj) return true;

        //Kiểm tra xem đối tượng có null không
        if (obj == null) return false;

        //Kiểm tra obj có chung lớp không
        if (getClass() != obj.getClass()) return false;

        Employee e = (Employee) obj;
        //Kiểm tra xem các trường có giá trị giống hệt nhau không
        return name.equals(e.name) && id.equals(e.id);

    }

    @Override
    public int hashCode() {
        //return 7 * name.hashCode() + 11 * id.hashCode();
        //hoặc cách này:
        return Objects.hash(name, id);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

