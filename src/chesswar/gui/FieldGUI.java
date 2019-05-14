package chesswar.gui;

import chesswar.entity.Chessman;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import chesswar.mechanic.board.Field;

public class FieldGUI extends Button {

    private Chessman chessman;
    private Color defaultColor;
    private Field field;

    public FieldGUI(Color color) {
        defaultColor = color;
        setMinSize(32,32);
        setMaxSize(32, 32);
        setBackground(new Background(new BackgroundFill(getDefaultColor(), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void update(){
        if(field.getChessman() != null){
            if(field.getChessman().isAlive()) {
                setGraphic(new ImageView(ResourceHolder.getInstance().getImage(field.getChessman())));
            } else {
                field.setChessman(null);
            }
        }
        //need to do before first then it maybe null
        if(field.getChessman() == null){
            try{
                setGraphic(new ImageView());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
    public Chessman getChessman() {
        return chessman;
    }

    public void setChessman(Chessman chessman) {
        this.chessman = chessman;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

}
