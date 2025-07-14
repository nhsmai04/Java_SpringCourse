package EnumerationClasses56;

public class Test {
    public static void main(String[] args) {
        for (Size s : Size.values()) {
            System.out.println(s + " " + s.getAbbreviation() + " " + s.ordinal());
        }
    }
}
