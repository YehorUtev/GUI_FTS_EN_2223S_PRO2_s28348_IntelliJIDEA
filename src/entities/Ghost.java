package entities;

import javax.swing.*;

public class Ghost extends JPanel implements Runnable{
    private ImageIcon ghost;
    private int ghostRow;
    private int ghostColumn;
    private int speed;
    public Ghost(){
        ghost = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\ghost.png");
    }

    public ImageIcon getGhost() {
        return ghost;
    }

    public void setGhost(ImageIcon ghost) {
        this.ghost = ghost;
    }

    public int getGhostRow() {
        return ghostRow;
    }

    public void setGhostRow(int ghostRow) {
        this.ghostRow = ghostRow;
    }

    public int getGhostColumn() {
        return ghostColumn;
    }

    public void setGhostColumn(int ghostColumn) {
        this.ghostColumn = ghostColumn;
    }

    @Override
    public void run() {

    }

    public void moveGhost(){

    }
}
