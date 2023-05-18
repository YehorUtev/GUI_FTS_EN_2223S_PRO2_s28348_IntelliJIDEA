package gui;

import entities.Result;
import entities.ResultLoader;
import entities.ResultSaver;
import entities.ScoreLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreWindow extends JFrame implements ActionListener, KeyListener {
    private List<Result> scoreLabels;
    private JPanel contentPanel;
    private JScrollPane scrollPane;
    private JButton buttonExit;
    private Font font;
    private ImageIcon icon = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\unnamed.png");
    private JLabel background;
    private ImageIcon backgroundGif = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\pacman1.gif");

    public ScoreWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        this.setTitle("SCORES");

        background = new JLabel();
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        Font sizedFont = font.deriveFont(16f);
        buttonExit = new JButton();

        this.setSize(655, 679);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setIconImage(icon.getImage());

        List<Result> results = ResultLoader.load("results.dat");
        addScores(results);

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        background.setBounds(0, 0, 640, 640);
        background.setIcon(backgroundGif);

        buttonExit.setBounds(10, 10, 100, 50);
        buttonExit.setFont(sizedFont);
        buttonExit.setText("Back");
        buttonExit.setBackground(new Color(112, 41, 99));
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setFocusable(false);
        buttonExit.setBorder(BorderFactory.createBevelBorder(1));
        buttonExit.addActionListener(this);

        scrollPane.setBounds(20, 80, 600, 550);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        background.setLayout(null);
        background.add(scrollPane);
        background.add(buttonExit);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.add(background);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void addScores(List<Result> results) {
        for (Result result : results) {
            ScoreLabel scoreLabel = new ScoreLabel(result.getNickname(), result.getScore());
            scoreLabel.setPreferredSize(new Dimension(500, 100));
            scoreLabel.setMaximumSize(new Dimension(600, 100));
            scoreLabel.setBackground(new Color(112, 41, 99));
            scoreLabel.setOpaque(true);
            scoreLabel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(10, 10, 10, 10),
                    BorderFactory.createBevelBorder(1)));
            contentPanel.add(scoreLabel);
        }
        contentPanel.revalidate();
        contentPanel.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonExit) {
            StartWindow startWindow = new StartWindow();
            this.dispose();
        }
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
}
