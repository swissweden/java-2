import javax.swing.*;
import java.awt.*;

public class qwe extends JFrame {
    public qwe() {
        setTitle("FlowLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane(); // 컨텐트팬 알아내기

        // FlowLayout 생성 (왼쪽 정렬, 수평 간격 30, 수직 간격 40)
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));

        contentPane.add(new JButton("add"));
        contentPane.add(new JButton("sub"));
        contentPane.add(new JButton("mul"));
        contentPane.add(new JButton("div"));
        contentPane.add(new JButton("Calculate"));

        setSize(300, 200); // 프레임 크기 300x200 설정
        setVisible(true);  // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new qwe();
    }
}
