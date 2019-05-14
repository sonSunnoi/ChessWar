package chesswar;

import chesswar.mechanic.ChessWarGame;
import chesswar.mechanic.ChessWarGameController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChessWar extends Application {

    private ChessWarGameController gameController;
    private ChessWarGame chessWarGame;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        Scene scene = new Scene(root);
        root.setPadding(new Insets(10));
        init();
        root.setPrefSize(600,400);
        root.getChildren().addAll(chessWarGame.getBoardController().getBoardGUI(),
                chessWarGame.getTurnController().getTurnControllerGUI());

//        AnimationTimer animation = new AnimationTimer() {
//
//            public void handle(long now) {
//                gameScreen.paintComponent();
//                logic.logicUpdate();
//                RenderableHolder.getInstance().update();
//                InputUtility.updateInputState();
//            }
//        };
//        animation.start();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chess War");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void init() {
        gameController = new ChessWarGameController();
        chessWarGame = gameController.getChessWarGame();
//        StackPane root = new StackPane();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setTitle("Tank game");
//
//        GameLogic logic = new GameLogic();
//        GameScreen gameScreen = new GameScreen(640, 480);
//        root.getChildren().add(gameScreen);
//        gameScreen.requestFocus();
//
//        stage.show();


    }

}
