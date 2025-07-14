package InnerClasses64;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class LocalInnerClass {
    private int interval;
    private boolean beep;

    public LocalInnerClass(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
