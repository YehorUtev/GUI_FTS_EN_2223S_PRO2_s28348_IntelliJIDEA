package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Pacman extends JPanel{
    ImageIcon left;
    ImageIcon right;
    ImageIcon up;
    ImageIcon down;
    private static int speed;
    public Pacman(){
        left = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\left.png");
        right = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\right.png");
        up = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\up.png");
        down = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\down.png");
    }

    public ImageIcon getLeft() {
        return left;
    }

    public void setLeft(ImageIcon left) {
        this.left = left;
    }

    public ImageIcon getRight() {
        return right;
    }

    public void setRight(ImageIcon right) {
        this.right = right;
    }

    public ImageIcon getUp() {
        return up;
    }

    public void setUp(ImageIcon up) {
        this.up = up;
    }

    public ImageIcon getDown() {
        return down;
    }

    public void setDown(ImageIcon down) {
        this.down = down;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillArc(0, 0, getWidth(), getHeight(), 45, 270);
    }
}
