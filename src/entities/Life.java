package entities;

import javax.swing.*;

public class Life extends JPanel {
    ImageIcon life = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\hp.png");
    public Life() {

    }

    public ImageIcon getLife() {
        return life;
    }

    public void setLife(ImageIcon life) {
        this.life = life;
    }
}
