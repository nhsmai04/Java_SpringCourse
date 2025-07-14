package InterfacesAndCallbacks63;

import java.awt.event.ActionListener;
import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(10000, listener); // 10 giây gọi 1 lần
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
    }
}
