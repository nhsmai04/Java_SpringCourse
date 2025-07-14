package InnerClasses64;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class LocalInnerClassAddFinal {
    public void start(int interval, final boolean beep) {
        // Biến đếm số lần chuông kêu
        final int[] counter = new int[1]; // Mảng 1 phần tử để lách hạn chế final
        // Local Inner Class
        class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                Date now = new Date();
                counter[0]++; // Tăng bộ đếm mỗi lần chạy
                System.out.println("At the tone, the time is " + now + " | Count: " + counter[0]);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();

        // Hộp thoại chặn để chờ người dùng đóng
        JOptionPane.showMessageDialog(null, "Click OK to stop the clock.");
        System.exit(0);
    }

}
