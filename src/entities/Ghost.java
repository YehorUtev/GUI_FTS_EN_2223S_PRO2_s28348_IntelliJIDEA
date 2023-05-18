package entities;

import boosts.DecreaseSpeedForGhost;
import boosts.ExtraPoints;
import gui.GameWindow;

import javax.swing.*;

public class Ghost extends JPanel implements Runnable {
    private double chanceToSpawn;
    private int time;
    private JPanel curPanel;
    private JPanel newPanel;
    private ImageIcon ghost;

    private int speed;

    public Ghost() {
        this.speed = 200;
        ghost = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\ghost.png");

    }

    public double getChanceToSpawn() {
        return chanceToSpawn;
    }

    public void setChanceToSpawn(double chanceToSpawn) {
        this.chanceToSpawn = chanceToSpawn;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ImageIcon getGhost() {
        return ghost;
    }

    public void setGhost(ImageIcon ghost) {
        this.ghost = ghost;
    }


    @Override
    public void run() {
        int newGhostRow = GameWindow.ghostRow;
        int newGhostColumn = GameWindow.ghostColumn;
        while (true) {
            int dir = (int)(Math.random()*4);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            time += 200;
            int maxRow = GameWindow.rows - 1;
            int maxColumn = GameWindow.columns - 1;

            switch (dir) {
                case (0):
                    System.out.println("0");
                    newGhostRow = Math.max(0, newGhostRow - 1);
                    break;
                case (1):
                    System.out.println("1");
                    newGhostRow = Math.min(maxRow, newGhostRow + 1);
                    break;
                case (2):
                    System.out.println("2");
                    newGhostColumn = Math.max(0, newGhostColumn - 1);
                    break;
                case (3):
                    System.out.println("3");
                    newGhostColumn = Math.min(maxColumn, newGhostColumn + 1);
                    break;
            }

            curPanel = GameWindow.gameBoard[GameWindow.ghostRow][GameWindow.ghostColumn];
            newPanel = GameWindow.gameBoard[newGhostRow][newGhostColumn];

            if(time == 5000){
                time = 0;
                createBoost();
            }

            if (newPanel instanceof Path && !(newPanel instanceof Wall)) {
                curPanel.remove(GameWindow.ghostLabel);
                curPanel.revalidate();
                curPanel.repaint();
                Path newPath = (Path) newPanel;
                newPath.add(GameWindow.ghostLabel);
                newPath.revalidate();
                newPath.repaint();

                GameWindow.ghostRow = newGhostRow;
                GameWindow.ghostColumn = newGhostColumn;
                GameWindow.gameTable.repaint();
            }
        }
    }


    public void createBoost() {
        double chance = Math.random();
        if(chance < chanceToSpawn){
            int randomBoost = (int)(Math.ceil(Math.random() * 4));
            switch (randomBoost){
                case (1):
                    curPanel.add(GameWindow.boostForSpeedLabel);
                    break;
                case (2):
                    curPanel.add(GameWindow.extraPointsBoost);
                    break;
                case (3):
                    curPanel.add(GameWindow.increaseSpawnRateLabel);
                    break;
                case (4):
                    break;
            }
        }
    }
}
