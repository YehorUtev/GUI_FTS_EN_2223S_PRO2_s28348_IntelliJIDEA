package gui;

import entities.ScoreLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AfterGameWindow extends JFrame implements ActionListener {
    JLabel background;
    private String nickname;
    private int score;
    private JTextField spaceForNickname;
    private JButton submitButton;
    private final Font font;
    private ImageIcon icon = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\unnamed.png");
    public AfterGameWindow(int score){
        spaceForNickname = new JTextField();
        submitButton = new JButton();
        background = new JLabel(icon);
        this.score = score;
        this.setLayout(null);
        this.setResizable(false);

        this.setSize(new Dimension(300,200));

        background.setVisible(true);
        background.setSize(new Dimension(300,200));

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }

        Font sizedFont = font.deriveFont(35f);
        Font sizedFontForButton = font.deriveFont(11f);

        spaceForNickname.setFont(sizedFont);
        spaceForNickname.setBounds(50,10,200,60);
        spaceForNickname.setVisible(true);
        spaceForNickname.setBackground(Color.WHITE);
        spaceForNickname.setForeground(Color.BLACK);

        submitButton.setText("SUBMIT");
        submitButton.setLayout(null);
        submitButton.setFont(sizedFontForButton);
        submitButton.setVisible(true);
        submitButton.setBackground(new Color(112, 41, 99));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(100,100,100,50);
        submitButton.setHorizontalAlignment(SwingConstants.CENTER);
        submitButton.setVerticalAlignment(SwingConstants.CENTER);
        submitButton.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(background);
        this.setVisible(true);
        this.add(spaceForNickname);
        this.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton){
            this.nickname = spaceForNickname.getText();
            this.dispose();
            ScoreWindow scoreWindow = new ScoreWindow();
            ScoreLabel scoreLabel = new ScoreLabel(nickname, score);
            scoreWindow.addScores(scoreLabel);
        }
    }
}
