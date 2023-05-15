package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ScoreWindow extends JFrame implements ActionListener {
    JButton buttonExit;
    Font font;
    ImageIcon icon = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\unnamed.png");
    JLabel background;
    ImageIcon backgroundGif = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\pacman1.gif");
    public ScoreWindow(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        background = new JLabel();
        try{
            font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));}
        catch (IOException | FontFormatException e){

        }
        Font sizedFont = font.deriveFont(16f);
        buttonExit = new JButton();

        this.setSize(655,679);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setIconImage(icon.getImage());

        background.setBounds(0,0,640,640);
        background.setIcon(backgroundGif);

        buttonExit.setBounds(10,10,100,50);
        buttonExit.setFont(sizedFont);
        buttonExit.setText("Back");
        buttonExit.setBackground(new Color(112, 41, 99));
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setFocusable(false);
        buttonExit.setBorder(BorderFactory.createBevelBorder(1));
        buttonExit.addActionListener(this);

        background.add(buttonExit);
        this.add(background);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonExit){
            StartWindow startWindow = new StartWindow();
            this.dispose();
        }
    }
}