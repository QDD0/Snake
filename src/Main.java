import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;

    public void button() {
        String message = "Snake";
        Font f = new Font("Century", Font.BOLD, 36);

        JLabel label = new JLabel(message);
        label.setFont(f);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        label.setSize(label.getPreferredSize());
        label.setLocation(DEFAULT_WIDTH / 2 - label.getWidth() / 2, 100);
        add(label);

        JButton buttonStart = new JButton("Start");
        JButton buttonExit = new JButton("Exit");

        buttonStart.setSize(95, 30);
        buttonExit.setSize(95, 30);

        int startButtonX = DEFAULT_WIDTH / 2 - buttonStart.getWidth() / 2;
        int startButtonY = 200;
        buttonStart.setBounds(startButtonX, startButtonY, buttonStart.getWidth(), buttonStart.getHeight());

        int exitButtonX = DEFAULT_WIDTH / 2 - buttonExit.getWidth() / 2;
        int exitButtonY = startButtonY + buttonStart.getHeight() + 20;
        buttonExit.setBounds(exitButtonX, exitButtonY, buttonExit.getWidth(), buttonExit.getHeight());

        add(buttonStart);
        add(buttonExit);

        buttonExit.addActionListener(e -> System.exit(0));
    }

    public Window() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 200);
        setTitle("Snake");
        setLayout(null);

        button();
    }
}

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Window frame = new Window();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
