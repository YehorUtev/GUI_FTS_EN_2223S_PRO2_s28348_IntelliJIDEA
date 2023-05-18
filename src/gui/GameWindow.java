package gui;

import boosts.DecreaseSpeedForGhost;
import boosts.ExtraPoints;
import boosts.IncreasePercentageOfSpawningBoost;
import entities.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GameWindow extends AbstractTableModel implements KeyListener {
    public static IncreasePercentageOfSpawningBoost increaseSpawnRate;
    public static JLabel increaseSpawnRateLabel;
    private final JLabel timeCounterLabel;
    private final JLabel hp3Label;
    private final JLabel hp2Label;
    private final JLabel hpLabel;
    private int amountOfLIfes;
    private final Life hp = new Life();
    public static JLabel boostForSpeedLabel;
    public static DecreaseSpeedForGhost decreaseSpeedForGhostBoost;
    public static ExtraPoints extraPoints;
    public static JLabel extraPointsBoost;
    public static int ghostColumn;
    public static int ghostRow;
    public static JLabel ghostLabel;
    private final Ghost ghost;
    private int foodCounter;
    private Font font;
    private int score;
    private final JLabel scoreLabel;
    public static JTable gameTable;
    public static int rows;
    public static int columns;
    private Wall wall;
    private Path path;
    private boolean isAdded = false;
    public static int pacmanRow;
    public static int pacmanColumn;
    private static JLabel pacmanLabel;
    private final Pacman pacman;
    private final TimeCounter timeCounter;
    private final ImageIcon food = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\kisspng-united-states-plan-win-the-white-house-business-ma-white-dot-5b246c763a0901.4391441115291137182377.jpg");
    private static JFrame gameFrame;
    private final JLabel label;
    public static JPanel[][] gameBoard;
    private final JPanel game;
    private final ImageIcon icon = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\unnamed.png");

    public GameWindow(int columns, int rows) {
        foodCounter = 0;
        score = 0;
        scoreLabel = new JLabel();
        gameTable = new JTable(this);
        gameTable.setRowHeight(50);
        gameTable.setDefaultRenderer(JPanel.class, new Renderer());
        gameTable.setVisible(true);
        GameWindow.rows = rows;
        GameWindow.columns = columns;
        timeCounter = new TimeCounter();
        gameFrame = new JFrame("PACMAN");
        gameBoard = new JPanel[rows * gameTable.getRowHeight()][columns * gameTable.getRowHeight()];
        label = new JLabel();
        game = new JPanel();
        pacman = new Pacman();
        ghostLabel = new JLabel();
        ghost = new Ghost();
        amountOfLIfes = 3;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));
        } catch (IOException | FontFormatException e) {

        }
        Font sizedFont = font.deriveFont(45f);

        game.setBounds(50, 50, (columns * gameTable.getRowHeight()) - 50, (rows * gameTable.getRowHeight()) - 50);
        game.setLayout(new GridLayout(rows, columns));

        gameFrame.setIconImage(icon.getImage());
        gameFrame.setResizable(false);
        gameFrame.setSize(columns * gameTable.getRowHeight() + 100, (rows * gameTable.getRowHeight()) + 100);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

        label.setBounds(0, 0, columns * gameTable.getRowHeight(), rows * gameTable.getRowHeight());
        label.setLayout(new BorderLayout(0, 0));
        label.add(game, BorderLayout.CENTER);

        hpLabel = new JLabel();
        hpLabel.setIcon(hp.getLife());
        hpLabel.setOpaque(false);
        hpLabel.setVisible(true);
        hpLabel.setBounds(10, 10, 30, 30);

        hp2Label = new JLabel();
        hp2Label.setIcon(hp.getLife());
        hp2Label.setOpaque(false);
        hp2Label.setVisible(true);
        hp2Label.setBounds(10, 60, 30, 30);

        hp3Label = new JLabel();
        hp3Label.setIcon(hp.getLife());
        hp3Label.setOpaque(false);
        hp3Label.setVisible(true);
        hp3Label.setBounds(10, 110, 30, 30);

        JPanel up = new JPanel();
        scoreLabel.setBounds(10, 10, 100, 100);
        scoreLabel.setFont(sizedFont);
        up.add(scoreLabel);
        up.setBackground(new Color(112, 41, 99));
        up.setPreferredSize(new Dimension(columns * gameTable.getRowHeight(), 50));

        JPanel down = new JPanel();
        down.setBackground(new Color(112, 41, 99));
        down.setPreferredSize(new Dimension(columns * gameTable.getRowHeight(), 50));
        timeCounterLabel = new JLabel();
        timeCounterLabel.setLayout(null);
        timeCounterLabel.setVisible(true);
        timeCounterLabel.setBounds(10, 10, 100, 30);
        timeCounterLabel.setFont(sizedFont);
        down.add(timeCounterLabel);

        JPanel left = new JPanel();
        left.setBackground(new Color(112, 41, 99));
        left.setPreferredSize(new Dimension(50, rows * gameTable.getRowHeight()));

        JPanel right = new JPanel();
        right.setBackground(new Color(112, 41, 99));
        right.setPreferredSize(new Dimension(50, rows * gameTable.getRowHeight()));
        right.add(hpLabel);
        right.add(hp2Label);
        right.add(hp3Label);

        label.add(up, BorderLayout.NORTH);
        label.add(down, BorderLayout.SOUTH);
        label.add(left, BorderLayout.EAST);
        label.add(right, BorderLayout.WEST);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                wall = new Wall();
                path = new Path();
                double randomNumber = Math.random() * 10;
                if (randomNumber < 1.3) {
                    gameBoard[i][j] = wall;
                    game.add(wall);
                } else {
                    path.setLayout(null);
                    if (isAdded) {
                        Foodies foodies = new Foodies(food);
                        foodies.setBounds(20, 20, 10, 10);
                        foodies.setOpaque(true);
                        foodCounter++;
                        ghostLabel.setIcon(ghost.getGhost());
                        ghostLabel.setLayout(null);
                        ghostLabel.setBounds(10, 10, 30, 30);
                        ghostLabel.setVisible(true);
                        ghostLabel.setOpaque(false);
                        ghostRow = i;
                        ghostColumn = j;
                        path.add(foodies);
                        path.add(ghostLabel);
                        game.add(path);
                    } else if (!isAdded) {
                        pacmanLabel = new JLabel();
                        pacmanLabel.setIcon(pacman.getRight());
                        pacmanLabel.setLayout(null);
                        pacmanLabel.setBounds(10, 10, 30, 30);
                        pacmanLabel.setVisible(true);
                        pacmanLabel.setOpaque(false);
                        path.add(pacmanLabel);
                        pacmanRow = i;
                        pacmanColumn = j;
                    }
                    gameBoard[i][j] = path;
                    game.add(path);
                    isAdded = true;
                }
            }
        }
        extraPoints = new ExtraPoints(ghostRow, ghostColumn);
        extraPointsBoost = new JLabel();
        extraPointsBoost.setVisible(true);
        extraPointsBoost.setLayout(null);
        extraPointsBoost.setBounds(10, 10, 30, 30);
        extraPointsBoost.setIcon(extraPoints.getBoostIcon());
        extraPointsBoost.setOpaque(false);

        decreaseSpeedForGhostBoost = new DecreaseSpeedForGhost(ghostRow, ghostColumn);
        boostForSpeedLabel = new JLabel();
        boostForSpeedLabel.setVisible(true);
        boostForSpeedLabel.setLayout(null);
        boostForSpeedLabel.setBounds(10, 10, 30, 30);
        boostForSpeedLabel.setIcon(decreaseSpeedForGhostBoost.getBoostIcon());
        boostForSpeedLabel.setOpaque(false);

        increaseSpawnRate = new IncreasePercentageOfSpawningBoost(ghostRow, ghostColumn);
        increaseSpawnRateLabel = new JLabel();
        increaseSpawnRateLabel.setVisible(true);
        increaseSpawnRateLabel.setLayout(null);
        increaseSpawnRateLabel.setBounds(10, 10, 30, 30);
        increaseSpawnRateLabel.setIcon(decreaseSpeedForGhostBoost.getBoostIcon());
        increaseSpawnRateLabel.setOpaque(false);

        gameFrame.setFocusable(true);
        gameFrame.addKeyListener(this);
        gameFrame.setResizable(true);
        game.setVisible(true);
        gameFrame.add(label);
    }

    public GameWindow(int columns, int rows, int scores) {
        foodCounter = 0;
        this.score = scores;
        scoreLabel = new JLabel();
        gameTable = new JTable(this);
        gameTable.setRowHeight(50);
        gameTable.setDefaultRenderer(JPanel.class, new Renderer());
        gameTable.setVisible(true);
        GameWindow.rows = rows;
        GameWindow.columns = columns;
        timeCounter = new TimeCounter();
        gameFrame = new JFrame("PACMAN");
        gameBoard = new JPanel[rows * gameTable.getRowHeight()][columns * gameTable.getRowHeight()];
        label = new JLabel();
        game = new JPanel();
        pacman = new Pacman();
        ghostLabel = new JLabel();
        ghost = new Ghost();
        amountOfLIfes = 3;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));
        } catch (IOException | FontFormatException e) {

        }
        Font sizedFont = font.deriveFont(45f);

        game.setBounds(50, 50, (columns * gameTable.getRowHeight()) - 50, (rows * gameTable.getRowHeight()) - 50);
        game.setLayout(new GridLayout(rows, columns));

        gameFrame.setIconImage(icon.getImage());
        gameFrame.setResizable(false);
        gameFrame.setSize(columns * gameTable.getRowHeight() + 100, (rows * gameTable.getRowHeight()) + 100);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

        label.setBounds(0, 0, columns * gameTable.getRowHeight(), rows * gameTable.getRowHeight());
        label.setLayout(new BorderLayout(0, 0));
        label.add(game, BorderLayout.CENTER);

        hpLabel = new JLabel();
        hpLabel.setIcon(hp.getLife());
        hpLabel.setOpaque(false);
        hpLabel.setVisible(true);
        hpLabel.setBounds(10, 10, 30, 30);

        hp2Label = new JLabel();
        hp2Label.setIcon(hp.getLife());
        hp2Label.setOpaque(false);
        hp2Label.setVisible(true);
        hp2Label.setBounds(10, 60, 30, 30);

        hp3Label = new JLabel();
        hp3Label.setIcon(hp.getLife());
        hp3Label.setOpaque(false);
        hp3Label.setVisible(true);
        hp3Label.setBounds(10, 110, 30, 30);

        JPanel up = new JPanel();
        scoreLabel.setBounds(10, 10, 100, 100);
        scoreLabel.setFont(sizedFont);
        up.add(scoreLabel);
        up.setBackground(new Color(112, 41, 99));
        up.setPreferredSize(new Dimension(columns * gameTable.getRowHeight(), 50));

        JPanel down = new JPanel();
        down.setBackground(new Color(112, 41, 99));
        down.setPreferredSize(new Dimension(columns * gameTable.getRowHeight(), 50));
        timeCounterLabel = new JLabel();
        timeCounterLabel.setLayout(null);
        timeCounterLabel.setVisible(true);
        timeCounterLabel.setBounds(10, 10, 100, 30);
        timeCounterLabel.setFont(sizedFont);
        down.add(timeCounterLabel);

        JPanel left = new JPanel();
        left.setBackground(new Color(112, 41, 99));
        left.setPreferredSize(new Dimension(50, rows * gameTable.getRowHeight()));

        JPanel right = new JPanel();
        right.setBackground(new Color(112, 41, 99));
        right.setPreferredSize(new Dimension(50, rows * gameTable.getRowHeight()));
        right.add(hpLabel);
        right.add(hp2Label);
        right.add(hp3Label);

        label.add(up, BorderLayout.NORTH);
        label.add(down, BorderLayout.SOUTH);
        label.add(left, BorderLayout.EAST);
        label.add(right, BorderLayout.WEST);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                wall = new Wall();
                path = new Path();
                double randomNumber = Math.random() * 10;
                if (randomNumber < 1.3) {
                    gameBoard[i][j] = wall;
                    game.add(wall);
                } else {
                    path.setLayout(null);
                    if (isAdded) {
                        Foodies foodies = new Foodies(food);
                        foodies.setBounds(20, 20, 10, 10);
                        foodies.setOpaque(true);
                        foodCounter++;
                        ghostLabel.setIcon(ghost.getGhost());
                        ghostLabel.setLayout(null);
                        ghostLabel.setBounds(10, 10, 30, 30);
                        ghostLabel.setVisible(true);
                        ghostLabel.setOpaque(false);
                        ghostRow = i;
                        ghostColumn = j;
                        path.add(foodies);
                        path.add(ghostLabel);
                        game.add(path);
                    } else if (!isAdded) {
                        pacmanLabel = new JLabel();
                        pacmanLabel.setIcon(pacman.getRight());
                        pacmanLabel.setLayout(null);
                        pacmanLabel.setBounds(10, 10, 30, 30);
                        pacmanLabel.setVisible(true);
                        pacmanLabel.setOpaque(false);
                        path.add(pacmanLabel);
                        pacmanRow = i;
                        pacmanColumn = j;
                    }
                    gameBoard[i][j] = path;
                    game.add(path);
                    isAdded = true;
                }
            }
        }
        extraPoints = new ExtraPoints(ghostRow, ghostColumn);
        extraPointsBoost = new JLabel();
        extraPointsBoost.setVisible(true);
        extraPointsBoost.setLayout(null);
        extraPointsBoost.setBounds(10, 10, 30, 30);
        extraPointsBoost.setIcon(extraPoints.getBoostIcon());
        extraPointsBoost.setOpaque(false);

        decreaseSpeedForGhostBoost = new DecreaseSpeedForGhost(GameWindow.ghostRow, GameWindow.ghostColumn);
        boostForSpeedLabel = new JLabel();
        boostForSpeedLabel.setVisible(true);
        boostForSpeedLabel.setLayout(null);
        boostForSpeedLabel.setBounds(10, 10, 30, 30);
        boostForSpeedLabel.setIcon(decreaseSpeedForGhostBoost.getBoostIcon());
        boostForSpeedLabel.setOpaque(false);

        increaseSpawnRate = new IncreasePercentageOfSpawningBoost(ghostRow, ghostColumn);
        increaseSpawnRateLabel = new JLabel();
        increaseSpawnRateLabel.setVisible(true);
        increaseSpawnRateLabel.setLayout(null);
        increaseSpawnRateLabel.setBounds(10, 10, 30, 30);
        increaseSpawnRateLabel.setIcon(decreaseSpeedForGhostBoost.getBoostIcon());
        increaseSpawnRateLabel.setOpaque(false);

        gameFrame.setFocusable(true);
        gameFrame.addKeyListener(this);
        gameFrame.setResizable(true);
        game.setVisible(true);
        gameFrame.add(label);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            movePacman(e);
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_W):
                changeImage(pacman.getUp());
                break;
            case (KeyEvent.VK_A):
                changeImage(pacman.getLeft());
                break;
            case (KeyEvent.VK_S):
                changeImage(pacman.getDown());
                break;
            case (KeyEvent.VK_D):
                changeImage(pacman.getRight());
                break;
        }
        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            StartWindow startWindow = new StartWindow();
            gameFrame.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void changeImage(ImageIcon move) {
        pacmanLabel.setIcon(move);
    }

    public void movePacman(KeyEvent e) {
        int newPacmanRow = pacmanRow;
        int newPacmanColumn = pacmanColumn;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                newPacmanRow = Math.max(0, pacmanRow - 1);
                break;
            case KeyEvent.VK_A:
                newPacmanColumn = Math.max(0, pacmanColumn - 1);
                break;
            case KeyEvent.VK_S:
                newPacmanRow = Math.min(rows - 1, pacmanRow + 1);
                break;
            case KeyEvent.VK_D:
                newPacmanColumn = Math.min(columns - 1, pacmanColumn + 1);
                break;
        }
        JPanel currentPanel = gameBoard[pacmanRow][pacmanColumn];
        JPanel newPanel = gameBoard[newPacmanRow][newPacmanColumn];
        if (newPanel instanceof Wall) {
            return;
        }
        if (currentPanel != null) {
            currentPanel.remove(pacmanLabel);
            currentPanel.revalidate();
            currentPanel.repaint();
        }
        if (newPanel instanceof Path) {
            Path newPath = (Path) newPanel;
            if (newPath.hasFood()) {
                newPath.removeFood();
                foodCounter--;
                score += 15;
                setScore(score);
            }
            newPath.add(pacmanLabel);
            newPath.revalidate();
            newPath.repaint();
        }
        if (checkPos()) {
            amountOfLIfes--;
            switch (amountOfLIfes) {
                case (2):
                    hp3Label.setVisible(false);
                    break;
                case (1):
                    hp2Label.setVisible(false);
                    break;
                case (0):
                    GameSettings.ghostThread.stop();
                    GameSettings.timeThread.stop();
                    hpLabel.setVisible(false);
                    gameFrame.dispose();
                    AfterGameWindow afterGameWindow = new AfterGameWindow(score);
                    break;
            }
        }

        if (check1Boost()) {
            int speed = ghost.getSpeed();
            currentPanel.remove(boostForSpeedLabel) ;
            ghost.setSpeed(speed + 200);
        }
        if(check2Boost()){
            score += 500;
            currentPanel.remove(extraPointsBoost);
        }
        if(check3Boost()){
            double chance = ghost.getChanceToSpawn();
            ghost.setChanceToSpawn(chance + 0.1);
        }

        pacmanRow = newPacmanRow;
        pacmanColumn = newPacmanColumn;
        gameTable.repaint();
        if (!hasFood()) {
            reset();
        }
    }


    public boolean hasFood() {
        return foodCounter != 0;
    }

    public void reset() {
        gameFrame.dispose();
        GameWindow gameWindow = new GameWindow(columns, rows, score);
    }

    public void setScore(int score) {
        this.score = score;
        scoreLabel.setText(Integer.toString(score));
    }

    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getColumnCount() {
        return columns;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return gameBoard[rowIndex][columnIndex];
    }

    public boolean checkPos() {
        return pacmanRow == ghostRow && pacmanColumn == ghostColumn;
    }

    public boolean check1Boost() {
        return pacmanRow == decreaseSpeedForGhostBoost.getBoostRow() && pacmanColumn == decreaseSpeedForGhostBoost.getBoostColumn();
    }
    public boolean check2Boost(){
        return pacmanRow == extraPoints.getBoostRow() && pacmanColumn == extraPoints.getBoostColumn();
    }
    public boolean check3Boost(){
        return pacmanRow == increaseSpawnRate.getBoostRow() && pacmanColumn == increaseSpawnRate.getBoostColumn();
    }

    private void updateCounter() {
        timeCounterLabel.setText(timeCounter.toString());
    }
}