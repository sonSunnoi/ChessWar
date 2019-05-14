package chesswar.gui;

import chesswar.entity.*;
import chesswar.mechanic.Player;
import javafx.scene.image.Image;

import java.util.HashMap;

public class ResourceHolder {

    private static ResourceHolder ourInstance = new ResourceHolder();

    public static ResourceHolder getInstance() {
        return ourInstance;
    }

    private HashMap<Chessman, Image> chessImage;

    private ResourceHolder() {

        boolean preserveRatio = false;
        boolean smooth = true;
        chessImage = new HashMap<>();
        chessImage.put(new King(new Player("Black")), new Image(ClassLoader.getSystemResource("black_king.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Queen(new Player("Black")), new Image(ClassLoader.getSystemResource("black_queen.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Rook(new Player("Black")), new Image(ClassLoader.getSystemResource("black_rook.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Bishop(new Player("Black")), new Image(ClassLoader.getSystemResource("black_bishop.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Knight(new Player("Black")), new Image(ClassLoader.getSystemResource("black_knight.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Pawn(new Player("Black")), new Image(ClassLoader.getSystemResource("black_pawn.png").toString(), 32, 32, preserveRatio, smooth));

        chessImage.put(new King(new Player("White")), new Image(ClassLoader.getSystemResource("white_king.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Queen(new Player("White")), new Image(ClassLoader.getSystemResource("white_queen.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Rook(new Player("White")), new Image(ClassLoader.getSystemResource("white_rook.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Bishop(new Player("White")), new Image(ClassLoader.getSystemResource("white_bishop.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Knight(new Player("White")), new Image(ClassLoader.getSystemResource("white_knight.png").toString(), 32, 32, preserveRatio, smooth));
        chessImage.put(new Pawn(new Player("White")), new Image(ClassLoader.getSystemResource("white_pawn.png").toString(), 32, 32, preserveRatio, smooth));
    }

    public Image getImage(Chessman chessman) {
        return chessImage.get(chessman);
    }
}
