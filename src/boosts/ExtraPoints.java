package boosts;

import javax.swing.*;

public class ExtraPoints extends JPanel{
    private int boostRow;
    private int boostColumn;
    ImageIcon boostIcon = new ImageIcon("E:\\GUI_FTS_EN_2223S_PRO2_s28348_IntelliJIDEA\\src\\images\\boost1.png");
    public ExtraPoints(int boostRow, int boostColumn){
        this.boostRow = boostRow;
        this.boostColumn = boostColumn;
    }

    public int getBoostRow() {
        return boostRow;
    }

    public void setBoostRow(int boostRow) {
        this.boostRow = boostRow;
    }

    public int getBoostColumn() {
        return boostColumn;
    }

    public void setBoostColumn(int boostColumn) {
        this.boostColumn = boostColumn;
    }

    public ImageIcon getBoostIcon() {
        return boostIcon;
    }

    public void setBoostIcon(ImageIcon boostIcon) {
        this.boostIcon = boostIcon;
    }
}
