import javax.swing.*;
import java.awt.*;
import java.util.*;

class Window extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;
    private boolean gameStarted = false;

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

        buttonStart.addActionListener(e -> {
            buttonStart.setVisible(false);
            buttonExit.setVisible(false);
            label.setVisible(false);

            gameStarted = true;
            repaint();
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (gameStarted) {
            Random rand = new Random();
            int x = rand.nextInt(DEFAULT_WIDTH - 50);
            int y = rand.nextInt(DEFAULT_HEIGHT - 50);

            ImageIcon icon = new ImageIcon("./img/apple.png");
            Image image = icon.getImage();

            g.drawImage(image, x, y, this);
        }
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;

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
