import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Interface extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("Hello world");
            Earth earth = new Earth();
            Pane pane = new Pane(earth);
            Scene ihm = new Scene(pane, 600, 400, true);
            primaryStage.setScene(ihm);
            primaryStage.show();
            Event event = new Event();

            PerspectiveCamera camera = new PerspectiveCamera(true);
            camera.setTranslateZ(-1000);
            camera.setNearClip(0.1);
            camera.setFarClip(2000.0);
            camera.setFieldOfView(40);
            ihm.setCamera(camera);
        }
        ihm.add EventHandler(MouseEvent.ANY, event ->)

    {
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            System.out.println("Clicked on : (" + event.getSceneX() + ", " + event.getSceneY() + ")");
        }
        if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            camera.getTransforms().add("Clicked on : (" + event.getSceneX() + ", " + event.getSceneY() + ")");
        }

    }
        public static void main(String[] args) {
            launch(args);
        }

}
