import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingBullet {
    private static int xPosition = 10;  // Початкова позиція кулі
    private static final int yPosition = 200;  // Вертикальна позиція кулі
    private static final int speed = 10;  // Швидкість руху кулі

    public static void main(String[] args) {
        JFrame frame = new JFrame("Наближається здалеку куля");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(xPosition, yPosition, 20, 20);  // Зображуємо кулю на панелі
            }
        };

        frame.add(panel);
        frame.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosition += speed;  // Збільшуємо позицію кулі згідно зі швидкістю
                panel.repaint();

                if (xPosition > frame.getWidth()) {
                    // Якщо куля досягла краю фрейму, зупиняємо таймер
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
}
