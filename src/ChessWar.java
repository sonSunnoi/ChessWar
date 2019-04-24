import javafx.application.Application;
import javafx.stage.Stage;
import mechanic.event.EntityAttackEvent;
import mechanic.event.EntityMoveEvent;
import mechanic.event.EventHandler;
import mechanic.event.Listener;

public class ChessWar extends Application {

    private EventSystem eventSystem;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    @Override
    public void init() throws Exception {

        eventSystem = new EventSystem();
        eventSystem.register(new Listener() {

            @EventHandler
            public void onMoveEvent(EntityMoveEvent event){
                //sound play
            }

        });
        eventSystem.register(new Listener() {

            @EventHandler
            public void onAttackEvent(EntityAttackEvent event){
                //sound play
            }

        });

    }

}
