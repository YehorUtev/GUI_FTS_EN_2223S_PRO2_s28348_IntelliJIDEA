package entities;

import gui.GameWindow;

import javax.swing.*;

public class Ghost extends JPanel implements Runnable {
    private ImageIcon ghost;

    private int speed;

    public Ghost() {
        ghost = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\ghost.png");
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
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            int dir = (int) (Math.random() * 4);

            int maxRow = GameWindow.rows - 1;
            int maxColumn = GameWindow.columns - 1;

            switch (dir) {
                case 0:
                    newGhostRow = Math.max(0, newGhostRow - 1);
                    break;
                case 1:
                    newGhostRow = Math.min(maxRow, newGhostRow + 1);
                    break;
                case 2:
                    newGhostColumn = Math.max(0, newGhostColumn - 1);
                    break;
                case 3:
                    newGhostColumn = Math.min(maxColumn, newGhostColumn + 1);
                    break;
            }

            JPanel curPanel = GameWindow.gameBoard[GameWindow.ghostRow][GameWindow.ghostColumn];
            JPanel newPanel = GameWindow.gameBoard[newGhostRow][newGhostColumn];

            curPanel.remove(GameWindow.ghostLabel);
            curPanel.revalidate();
            curPanel.repaint();

            if (newPanel instanceof Path) {
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


    public void moveGhost() {

    }
}
