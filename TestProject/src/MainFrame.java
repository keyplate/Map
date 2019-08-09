import javax.swing.*;
import java.awt.*;

public class MainFrame extends Canvas {

    public MainFrame() {
        JFrame frame = new JFrame();
        this.setBackground(Color.BLACK);
        frame.addKeyListener(GameLogic.gm);
        frame.setMinimumSize(new Dimension(500, 500));
        this.setSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(Apple.X, Apple.Y, Apple.height, Apple.width);
        g.setColor(Color.GREEN);
        for(int i = 0; i < Snake.length; i++) {
            g.fillRect(Snake.dots_X[i],Snake.dots_Y[i], Snake.height, Snake.width);
        }
        g.setColor(Color.WHITE);
        g.drawRect(0,0,498,498);
    }
}
