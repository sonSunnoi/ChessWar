package chesswar;

import chesswar.mechanic.ChessWarGame;
import chesswar.mechanic.ChessWarGameController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChessWar extends Application {

    private ChessWarGameController gameController;
    private ChessWarGame chessWarGame;
    private VBox leftPanel;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        Scene scene = new Scene(root);
        root.setPadding(new Insets(10));
        init();
        root.setPrefSize(650,420);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(chessWarGame.getBoardController().getBoardGUI(), leftPanel);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Chess War");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void init() {
        gameController = new ChessWarGameController();
        chessWarGame = gameController.getChessWarGame();
        chessWarGame.getBoardController().getBoardGUI().setAlignment(Pos.BOTTOM_CENTER);
        chessWarGame.getTurnController().getTurnControllerGUI().setAlignment(Pos.BOTTOM_CENTER);
        chessWarGame.getTurnController().getTurnControllerGUI().setPadding(new Insets(20,20,20,30));
        chessWarGame.getChessmanDataFirst().setPadding(new Insets(20));
        chessWarGame.getChessmanDataSecond().setPadding(new Insets(20));
        leftPanel = new VBox();
        leftPanel.getChildren().addAll(chessWarGame.getChessmanDataFirst(),
                chessWarGame.getChessmanDataSecond(),
                chessWarGame.getTurnController().getTurnControllerGUI());

    }

}
