package chesswar;

import chesswar.mechanic.ChessWarGameController;
import javafx.application.Application;
import javafx.stage.Stage;
import chesswar.mechanic.event.EntityAttackEvent;
import chesswar.mechanic.event.EntityMoveEvent;
import chesswar.mechanic.event.EventHandler;
import chesswar.mechanic.event.EventSystem;
import chesswar.mechanic.listener.Listener;

public class ChessWar extends Application {

    private ChessWarGameController gameController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stac root = new StackPane();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tank game");

        AnimationTimer animation = new AnimationTimer() {
            public void handle(long now) {
                gameScreen.paintComponent();
                logic.logicUpdate();
                RenderableHolder.getInstance().update();
                InputUtility.updateInputState();
            }
        };
        animation.start();
    }

    @Override
    public void init() throws Exception {
        gameController = new ChessWarGameController();
        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tank game");

        GameLogic logic = new GameLogic();
        GameScreen gameScreen = new GameScreen(640, 480);
        root.getChildren().add(gameScreen);
        gameScreen.requestFocus();

        stage.show();


    }

}
