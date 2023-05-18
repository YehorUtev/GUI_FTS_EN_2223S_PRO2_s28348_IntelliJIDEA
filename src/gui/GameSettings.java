package gui;

import entities.Ghost;
import entities.TimeCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GameSettings extends JFrame implements ActionListener, KeyListener {
    public static Thread timeThread;
    public static Thread ghostThread;
    JButton buttonAccept;
    JTextField rowsTextField;
    JTextField columnsTextFIeld;
    int rows;
    int columns;
    final Font font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));
    ImageIcon icon = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\unnamed.png");
    JLabel background;

    public GameSettings() throws IOException, FontFormatException {
        background = new JLabel();
        background.setIcon(icon);
        background.setSize(new Dimension(350, 200));
        background.setVisible(true);

        this.setSize(350, 170);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SETTINGS");
        Font sizedFont = font.deriveFont(10f);
        Font sizedFontForText = font.deriveFont(35f);
        rowsTextField = new JTextField();
        rowsTextField.setFocusable(true);
        rowsTextField.setBounds(175, 10, 155, 50);
        rowsTextField.setFont(sizedFontForText);
        rowsTextField.setBackground(Color.WHITE);
        rowsTextField.setForeground(Color.BLACK);

        columnsTextFIeld = new JTextField();
        columnsTextFIeld.setFocusable(true);
        columnsTextFIeld.setBounds(5, 10, 160, 50);
        columnsTextFIeld.setFont(sizedFontForText);
        columnsTextFIeld.setBackground(Color.WHITE);
        columnsTextFIeld.setForeground(Color.BLACK);

        buttonAccept = new JButton();
        buttonAccept.setBackground(new Color(112, 41, 99));
        buttonAccept.setForeground(Color.WHITE);
        buttonAccept.setBounds(120, 70, 100, 50);
        buttonAccept.setFocusable(false);
        buttonAccept.setText("Accept");
        buttonAccept.setFont(sizedFont);
        buttonAccept.addActionListener(this);

        this.addKeyListener(this);
        this.setFocusable(true);
        this.add(background);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.add(rowsTextField);
        this.add(columnsTextFIeld);
        this.add(buttonAccept);
        this.setVisible(true);
        this.setResizable(false);
    }

    public int getColumns() {
        String amountOfColumns = columnsTextFIeld.getText();
        return columns = Integer.parseInt(amountOfColumns);
    }

    public int getRows() {
        String amountORows = rowsTextField.getText();
        return rows = Integer.parseInt(amountORows);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            StartWindow startWindow = new StartWindow();
            this.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int columns = getColumns();
        int rows = getRows();
        boolean isOkay = true;
        if (rows < 10) {
            isOkay = false;
        } else if (rows > 100) {
            isOkay = false;
        } else if (columns < 10) {
            isOkay = false;
        } else if (columns > 100) {
            isOkay = false;
        }
        if(!isOkay){
            JOptionPane.showMessageDialog(null, "Enter rows and columns bigger then 10 and less then 100", "Error", JOptionPane.WARNING_MESSAGE);
        }
        if(isOkay) {
            if (e.getSource() == buttonAccept) {
                this.dispose();
                GameWindow game = new GameWindow(getColumns(), getRows());
                TimeCounter timeCounter = new TimeCounter();
                timeThread = new Thread(timeCounter);
                timeThread.start();
                Ghost ghost = new Ghost();
                ghostThread = new Thread(ghost);
                ghostThread.start();
            }
        }
    }
}
