
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameLogic extends KeyAdapter{

    public static int direction_X = 10;
    public static int direction_Y = 0;
    protected static GameLogic gm = new GameLogic();

    private static void checkApple() {
        if (Snake.dots_X[0] == Apple.X && Snake.dots_Y[0] == Apple.Y) {
            Apple.X = new Random().nextInt(50) * 10;
            Apple.Y = new Random().nextInt(50) * 10;
            Snake.length++;
        }
    }

    private static void move() {
        for (int i = Snake.length; i > 0; i--) {
            Snake.dots_X[i] = Snake.dots_X[i - 1];
            Snake.dots_Y[i] = Snake.dots_Y[i - 1];
        }
        if (direction_X == 10) {
            Snake.dots_X[0] += 10;
        }
        if (direction_X == -10) {
            Snake.dots_X[0] -= 10;
        }
        if (direction_Y == 10) {
            Snake.dots_Y[0] += 10;
        }
        if (direction_Y == -10) {
            Snake.dots_Y[0] -= 10;
        }
    }

    private static void initSnake() {
        for (int i = 0; i < Snake.length; i++) {
            Snake.dots_X[i] = 10 + 10 * i;
            Snake.dots_Y[i] = 10 + 10 * i;
        }
    }

    private static boolean isCollision() {
        if (Snake.dots_Y[0] < 0 || Snake.dots_Y[0] > 495) {
            return true;
        }
        if (Snake.dots_X[0] < 0 || Snake.dots_X[0] > 495) {
            return true;
        }
        return false;
    }

    private static boolean isSelfCrash() {
        for (int i = 1; i < Snake.length; i++){
            if(Snake.dots_X[i] == Snake.dots_X[0] && Snake.dots_Y[i] == Snake.dots_Y[0]){
                return true;
            }
        }
        return false;
    }

    public static void startGame() throws InterruptedException {
        initSnake();
        while (true) {
            Main.mainFrame.repaint();
            checkApple();
            move();
            if (isCollision() || isSelfCrash()) {
                break;
            }

            Thread.sleep(200);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37 && direction_X != 10) {
            direction_X = -10;
            direction_Y = 0;
        }
        if (e.getKeyCode() == 38 && direction_Y != 10) {
            direction_X = 0;
            direction_Y = -10;
        }
        if (e.getKeyCode() == 39 && direction_X != -10) {
            direction_Y = 0;
            direction_X = 10;
        }
        if (e.getKeyCode() == 40 && direction_Y != -10) {
            direction_X = 0;
            direction_Y = 10;
        }
    }

}
