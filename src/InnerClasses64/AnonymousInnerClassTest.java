package InnerClasses64;

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        AnonymousInnerClass clock = new AnonymousInnerClass();
        clock.start(1000, true); // 1 giây kêu 1 lần, có beep
    }
}
