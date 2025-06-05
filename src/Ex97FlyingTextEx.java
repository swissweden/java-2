import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex97FlyingTextEx extends JFrame {
    public Ex97FlyingTextEx() {
        setLocation(50, 50);
        setSize(100, 100);
        add(l);

        setSize(width: 200, height: 200);
        setVisible(true);

        c.setFocusable(focusable:true); // 컨텐트팬이 포커스를 받을 수 있도록 설정
        c.requestFocus(); // 포커스 설정
    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode(); // 입력된 키코드
            switch (keycode) {
                case KeyEvent.VK_UP:
                    l.setLocation(l.getX(), l.getY() - 10);
                    break;
                case KeyEvent.VK_DOWN:
                    l.setLocation(l.getX(), l.getY() + 10);
                    break;
                case KeyEvent.VK_LEFT:
                    l.setLocation(l.getX() - 10, l.getY());
                    break;
                case KeyEvent.VK_RIGHT:
                    l.setLocation(l.getX() + 10, l.getY());
                    break;
            }
        }
    }
}
