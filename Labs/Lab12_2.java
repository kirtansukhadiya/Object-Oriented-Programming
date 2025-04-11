import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Lab12_2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a circle
        Circle circle = new Circle(20, Color.BLUE);
        circle.setCenterX(100);
        circle.setCenterY(50);

        // Define a vertical path
        Line path = new Line(100, 50, 100, 300);

        // Create a path transition
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(circle);
        pathTransition.setPath(path);
        pathTransition.setDuration(Duration.seconds(4));
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        // Set up the scene
        javafx.scene.Group root = new javafx.scene.Group(circle);
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Path Transition Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
