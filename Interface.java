import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Interface extends Application {
    double gety;
    double getx;
    double zoom;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world");
        Earth earth = new Earth();
        Pane pane = new Pane(earth);
        Scene ihm = new Scene(pane, 600, 400, true);
        primaryStage.setScene(ihm);
        primaryStage.show();
      //  Event event = new Event();

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1500);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(40);
        ihm.setCamera(camera);

        ihm.addEventHandler(MouseEvent.ANY, event -> {

            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                gety = event.getSceneY();
                getx = event.getSceneX();
                System.out.println("Clicked on : (" + event.getSceneX() + ", " + event.getSceneY() + ")");
            }

            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                zoom = gety - event.getSceneY();
                camera.setTranslateZ(-1500 + zoom);
            }

        });

    }
        public static void main(String[] args){
            launch(args);

        }
}