package InnerClasses64;

import javax.swing.*;

public class LocalInnerClassTest {
    public static void main(String[] args) {
        LocalInnerClass clock = new LocalInnerClass(1000, true);
        clock.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

}
