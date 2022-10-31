package app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new GridLayout(0, 3));
            String test[][]={{"A","D","M","I","R","E","D","F","G","N","I","L","L","O","R","Z"},{"D","E","F"},{"G","H","I"}};
            Border paddingBorder = new EmptyBorder(50, 50, 50, 50);
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    JLabel label = new JLabel(test[row][col]);
                    label.setVerticalAlignment(JLabel.CENTER);
                    label.setHorizontalAlignment(JLabel.CENTER);

                    Border edgeBorder = new MatteBorder(
                            1,
                            1,
                            row == 2 ? 1 : 0,
                            col == 2 ? 1 : 0,
                            Color.BLACK);
                    label.setBorder(new CompoundBorder(edgeBorder, paddingBorder));

                    add(label);
                }
            }
        }

    }

}