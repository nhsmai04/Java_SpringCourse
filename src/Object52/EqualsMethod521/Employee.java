package Object52.EqualsMethod521;

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
}
