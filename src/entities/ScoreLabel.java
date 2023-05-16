package entities;

import gui.ScoreWindow;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScoreLabel extends JLabel {
    private String text;
    private String nickname;
    private int score;
    private Font font;
    public ScoreLabel(String nickname, int score){
        this.nickname = nickname;
        this.score = score;

        try{
            font = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\fonts\\PressStart2P.ttf"));}
        catch (IOException | FontFormatException e){

        }
        Font sizedFont = font.deriveFont(20f);
        text = String.format(" %s, score: %d", nickname, score);

        this.setForeground(Color.WHITE);
        this.setVisible(true);
        this.setFont(sizedFont);
        this.setText(text);
    }
}
