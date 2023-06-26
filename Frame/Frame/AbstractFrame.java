package Frame;

import javax.swing.*;
import java.awt.*;

/**
 * Abstraction Implemented
 */
public abstract class AbstractFrame {

    public JFrame frame = new JFrame();

    public void defaultFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(0x000000));
        frame.setLayout(new BorderLayout());
    }

}
