import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class dd extends JFrame {
    public dd() {
        super("JComponent의 공통 메소드 예제");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton b1 = new JButton("Magenta/Yellow Button");
        JButton b2 = new JButton("Disabled Button");
        JButton b3 = new JButton("getX(), getY()");

        b1.setBackground(Color.YELLOW);                // 배경색 노란색
        b1.setForeground(Color.MAGENTA);               // 글자색 마젠타
        b1.setFont(new Font("Arial", Font.ITALIC, 20));// Arial, 이탤릭, 20픽셀
        b2.setEnabled(false);                          // 비활성화 버튼

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                setTitle(b.getX() + "," + b.getY());
            }
        });

        c.add(b1);
        c.add(b2);
        c.add(b3);

        setSize(260, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new dd();
    }
}
