package Interface61;

public class Employee implements Comparable<Employee>, Moveable {
    private double salary;

    public void move() {
        System.out.println("Employee moved");
    }

    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }
}

