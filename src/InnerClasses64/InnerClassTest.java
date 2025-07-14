package InnerClasses64;

public class InnerClassTest {
    public  static void main(String[] args) {
        Outer obj = new Outer();
        Outer.Inner inner = obj.new Inner();
        inner.printData();
    }
}
