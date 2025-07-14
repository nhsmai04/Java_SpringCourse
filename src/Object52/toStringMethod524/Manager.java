package Object52.toStringMethod524;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id,  double bonus) {
        super(name, id);
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;

        Manager m = (Manager) o;
        return this.bonus == m.bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", bonus=" + bonus;
    }
}
