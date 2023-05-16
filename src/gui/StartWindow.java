package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartWindow extends JFrame implements ActionListener {
    JButton buttonGame;
    JButton buttonScore;
    JButton buttonExit;
    JLabel background;
    Font font;
    ImageIcon gifBackground = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\pacman1.gif");
    ImageIcon icon = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\unnamed.png");

    public StartWindow(){
        buttonGame = new JButton();
        buttonScore = new JButton();
        buttonExit = new JButton();
        background = new JLabel();
        try{
            font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));}
        catch (IOException | FontFormatException e){

        }
        Font sizedFont = font.deriveFont(25f);
        this.setSize(655,679);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        this.setLayout(null);
        this.setIconImage(icon.getImage());

        background.setBounds(0,0,640,640);
        background.setIcon(gifBackground);

        buttonGame.setText("NEW GAME");
        buttonGame.setBounds(170,70,300,140);
        buttonGame.setFont(sizedFont);
        buttonGame.setBackground(new Color(112, 41, 99));
        buttonGame.setForeground(Color.WHITE);
        buttonGame.setFocusable(false);
        buttonGame.setBorder(BorderFactory.createBevelBorder(1));
        buttonGame.addActionListener(this);

        buttonScore.setText("HIGH SCORES");
        buttonScore.setBounds(170,250,300,140);
        buttonScore.setFont(sizedFont);
        buttonScore.setBackground(new Color(112, 41, 99));
        buttonScore.setForeground(Color.WHITE);
        buttonScore.setFocusable(false);
        buttonScore.setBorder(BorderFactory.createBevelBorder(1));
        buttonScore.addActionListener(this);

        buttonExit.setText("EXIT");
        buttonExit.setBounds(170,430,300,140);
        buttonExit.setFont(sizedFont);
        buttonExit.setBackground(new Color(112, 41, 99));
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setFocusable(false);
        buttonExit.setBorder(BorderFactory.createBevelBorder(1));
        buttonExit.addActionListener(this);

        background.add(buttonGame);
        background.add(buttonScore);
        background.add(buttonExit);
        this.add(background);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonGame){
            try {
                GameSettings gameSettings = new GameSettings();
            } catch (IOException | FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        }else if (e.getSource() == buttonScore) {
            ScoreWindow scores = new ScoreWindow();
            this.dispose();
        } else if (e.getSource() == buttonExit) {
            this.dispose();
        }
    }
}

