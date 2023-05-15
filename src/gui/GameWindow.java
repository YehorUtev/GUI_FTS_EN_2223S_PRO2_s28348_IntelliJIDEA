package gui;

import entities.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GameWindow extends AbstractTableModel implements KeyListener {
    private int foodCounter;
    private Font font;
    private int score;
    private JLabel scoreLabel;
    private static JTable gameTable;
    private final int rows;
    private final int columns;
    private Wall wall;
    private Path path;
    private boolean isAdded = false;
    private static int pacmanRow;
    private static int pacmanColumn;
    private static JLabel pacmanLabel;
    private Pacman pacman;
    private TimeCounter timeCounter;
    private final ImageIcon food = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\kisspng-united-states-plan-win-the-white-house-business-ma-white-dot-5b246c763a0901.4391441115291137182377.jpg");
    private boolean isPlayable = true;
    private static JFrame gameFrame;
    private JLabel label;
    private static JPanel[][] gameBoard;
    private JPanel game;
    private JLabel timer;
    private final ImageIcon icon = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\unnamed.png");

    public GameWindow(int columns, int rows) {
        foodCounter = 0;
        score = 0;
        scoreLabel = new JLabel();
        gameTable = new JTable(this);
        gameTable.setRowHeight(50);
        gameTable.setDefaultRenderer(JPanel.class, new Renderer());
        gameTable.setVisible(true);
        this.rows = rows;
        this.columns = columns;
        timeCounter = new TimeCounter();
        gameFrame = new JFrame("PACMAN");
        gameBoard = new JPanel[rows * gameTable.getRowHeight()][columns * gameTable.getRowHeight()];
        label = new JLabel();
        game = new JPanel();
        pacman = new Pacman();

        try{
            font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));}
        catch (IOException | FontFormatException e){

        }
        Font sizedFont = font.deriveFont(45f);

        game.setBounds(50,50,(columns * gameTable.getRowHeight()) - 50, (rows * gameTable.getRowHeight()) - 50);
        game.setLayout(new GridLayout(rows, columns));

        gameFrame.setIconImage(icon.getImage());
        gameFrame.setResizable(false);
        gameFrame.setSize(columns * gameTable.getRowHeight() + 100, (rows * gameTable.getRowHeight()) + 100);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

        label.setBounds(0, 0, columns * gameTable.getRowHeight(), rows * gameTable.getRowHeight() );
        label.setLayout(new BorderLayout(0, 0));
        label.add(game,BorderLayout.CENTER);

        JPanel up = new JPanel();
        scoreLabel.setBounds(10,10,100,100);
        scoreLabel.setFont(sizedFont);
        timer = new JLabel(timeCounter.toString());
        timer.setBounds(10,10,rows/4,30);
        up.add(scoreLabel);
        up.setBackground(new Color(112, 41, 99));
        up.setPreferredSize(new Dimension(columns * gameTable.getRowHeight(), 50));

        JPanel down = new JPanel();
        down.setBackground(new Color(112, 41, 99));
        down.setPreferredSize(new Dimension(columns * gameTable.getRowHeight(), 50));

        JPanel left = new JPanel();
        left.setBackground(new Color(112, 41, 99));
        left.setPreferredSize(new Dimension(50, rows * gameTable.getRowHeight()));

        JPanel right = new JPanel();
        right.setBackground(new Color(112, 41, 99));
        right.setPreferredSize(new Dimension(50, rows * gameTable.getRowHeight()));

        label.add(up, BorderLayout.NORTH);
        label.add(down, BorderLayout.SOUTH);
        label.add(left, BorderLayout.EAST);
        label.add(right, BorderLayout.WEST);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                wall = new Wall();
                path = new Path();
                double randomNumber = Math.random() * 10;
                if (randomNumber < 0.7) {
                    gameBoard[i][j] = wall;
                    game.add(wall);
                } else {
                    path.setLayout(null);
                    if (isAdded == true) {
                        Foodies foodies = new Foodies(food);
                        foodies.setBounds(20, 20, 10, 10);
                        foodies.setOpaque(true);
                        foodCounter++;
                        path.add(foodies);
                        game.add(path);
                    } else if (isAdded == false) {
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
        gameFrame.setFocusable(true);
        gameFrame.addKeyListener(this);
        gameFrame.setResizable(true);
        game.setVisible(true);
        gameFrame.add(label);
    }

    public GameWindow(int columns, int rows, int scores){
        foodCounter = 0;
        this.score = scores;
        scoreLabel = new JLabel();
        gameTable = new JTable(this);
        gameTable.setRowHeight(50);
        gameTable.setDefaultRenderer(JPanel.class, new Renderer());
        gameTable.setVisible(true);
        this.rows = rows;
        this.columns = columns;
        timeCounter = new TimeCounter();
        gameFrame = new JFrame("PACMAN");
        gameBoard = new JPanel[rows * gameTable.getRowHeight()][columns * gameTable.getRowHeight()];
        label = new JLabel();
        game = new JPanel();
        pacman = new Pacman();

        try{
            font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));}
        catch (IOException | FontFormatException e){

        }
        Font sizedFont = font.deriveFont(45f);

        game.setBounds(50,50,(columns * gameTable.getRowHeight()) - 50, (rows * gameTable.getRowHeight()) - 50);
        game.setLayout(new GridLayout(rows, columns));

        gameFrame.setIconImage(icon.getImage());
        gameFrame.setResizable(false);
        gameFrame.setSize(columns * gameTable.getRowHeight() + 100, (rows * gameTable.getRowHeight()) + 100);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

        label.setBounds(0, 0, columns * gameTable.getRowHeight(), rows * gameTable.getRowHeight() );
        label.setLayout(new BorderLayout(0, 0));
        label.add(game,BorderLayout.CENTER);

        JPanel up = new JPanel();
        scoreLabel.setBounds(10,10,100,100);
        scoreLabel.setFont(sizedFont);
        timer = new JLabel(timeCounter.toString());
        timer.setBounds(10,10,rows/4,30);
        up.add(scoreLabel);
        up.setBackground(new Color(112, 41, 99));
        up.setPreferredSize(new Dimension(columns * gameTable.getRowHeight(), 50));

        JPanel down = new JPanel();
        down.setBackground(new Color(112, 41, 99));
        down.setPreferredSize(new Dimension(columns * gameTable.getRowHeight(), 50));

        JPanel left = new JPanel();
        left.setBackground(new Color(112, 41, 99));
        left.setPreferredSize(new Dimension(50, rows * gameTable.getRowHeight()));

        JPanel right = new JPanel();
        right.setBackground(new Color(112, 41, 99));
        right.setPreferredSize(new Dimension(50, rows * gameTable.getRowHeight()));

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
                    if (isAdded == true) {
                        Foodies foodies = new Foodies(food);
                        foodies.setBounds(20, 20, 10, 10);
                        foodies.setOpaque(true);
                        foodCounter++;
                        path.add(foodies);
                        game.add(path);
                    } else if (isAdded == false) {
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
        movePacman(e);
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
                score += 10;
                setScore(score);
            }
            newPath.add(pacmanLabel);
            newPath.revalidate();
            newPath.repaint();
        }
        pacmanRow = newPacmanRow;
        pacmanColumn = newPacmanColumn;
        gameTable.repaint();
        if(!hasFood()){
            reset();
        }
    }
    public boolean hasFood(){
        if(foodCounter == 0){
            return false;
        }
        return true;
    }

    public void reset(){
        gameFrame.dispose();
        GameWindow gameWindow = new GameWindow(columns, rows, score);
    }
    public void setScore(int score){
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


}