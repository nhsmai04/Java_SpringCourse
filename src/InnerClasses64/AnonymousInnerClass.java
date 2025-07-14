package InnerClasses64;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class AnonymousInnerClass {
    public void start(int interval, final boolean beep) {
        // Anonymous inner class: tạo object ActionListener mà không đặt tên class
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };

        Timer t = new Timer(interval, listener);
        t.start();

        // Hộp thoại chặn để clock chạy
        JOptionPane.showMessageDialog(null, "Click OK to stop the clock.");
        System.exit(0);
    }
}
