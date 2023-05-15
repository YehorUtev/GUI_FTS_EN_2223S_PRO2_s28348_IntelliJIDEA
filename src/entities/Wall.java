package entities;

import javax.swing.*;
import java.awt.*;

public class Wall extends JPanel {
    private boolean isAvailable;

    public Wall() {
        this.isAvailable = false;
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(50, 50));
        this.setBorder(BorderFactory.createLineBorder(new Color(80,0,128),4));
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
