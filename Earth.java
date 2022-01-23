import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class Earth extends Group {

    private Rotate ry = new Rotate(0, new Point3D(0, 1, 0));
    private Sphere sph = new Sphere();
    private Sphere s = new Sphere(5);

    PhongMaterial material = new PhongMaterial();
    //private Scene ihm = new Scene();


    public Sphere createSphere(aeroport a, Color c){
        double X,Y,Z;
        X = sph.getRadius()*Math.cos(Math.toRadians(a.getLatitude()-13))*Math.sin(Math.toRadians(a.getLongitude()));
        Y = -(sph.getRadius()*Math.sin(Math.toRadians(a.getLatitude()-13)));
        Z = -(sph.getRadius()*Math.cos(Math.toRadians(a.getLatitude()-13))*Math.cos(Math.toRadians(a.getLongitude())));

        s.setMaterial(new PhongMaterial(c));
        s.getTransforms().add(new Translate(X,Y,Z));
        return s;
    }


    public void displayRedSphere(aeroport a){
        Sphere s1 = createSphere(a, Color.RED);
        this.getChildren().add(s1);
    }

    public Earth() {
        super();
        Image im = new Image("/earth_lights_4800.png");
        sph.setRadius(300);
        sph.getTransforms().add(ry);
        s.getTransforms().add(ry);
        material.setDiffuseMap(im);
        sph.setMaterial(material);
        this.getChildren().add(sph);
        animationTimer.start();

    }
    AnimationTimer animationTimer = new AnimationTimer() {
       double angle = 0;
        @Override
        public void handle(long time) {
           ry.setAngle(time/50000000);
       }
    };
}



