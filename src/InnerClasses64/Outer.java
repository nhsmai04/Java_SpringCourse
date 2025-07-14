package InnerClasses64;

class Outer {
    private int data = 42;

    class Inner {
        void printData() {
            System.out.println("Outer data: " + data); // OK!
        }
    }
}
