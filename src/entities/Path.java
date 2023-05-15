package entities;

import javax.swing.*;
import java.awt.*;

public class Path extends JPanel {
    private boolean hasFood;
    private boolean isAvailable;
    public Path() {
        this.hasFood = true;
        this.setBackground(new Color(40, 50, 128));
        this.setPreferredSize(new Dimension(50, 50));
        this.setLayout(null);
    }

    public boolean hasFood() {
        return hasFood;
    }

    public void removeFood() {
        this.remove(0);
        hasFood = false;
        this.revalidate();
        this.repaint();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
