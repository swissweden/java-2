import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseAdapterEx2 extends JFrame {
    private JLabel la = new JLabel("Hello"); // "Hello" 레이블

    public MouseAdapterEx2() {
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        la.setSize(50, 20);
        la.setLocation(30, 30);
        c.add(la);

        c.addMouseListener(new Ex9_5MyMouseAdapter());

        setSize(200, 200);
        setVisible(true);
    }

    class Ex9_5MyMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
        }
    }

    public static void main(String[] args) {
        new MouseAdapterEx2();
    }
}
