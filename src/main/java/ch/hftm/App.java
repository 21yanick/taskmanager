package ch.hftm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Taskmanager taskmanager = new Taskmanager();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/task_overview.fxml"));
            TaskOverviewController controller = new TaskOverviewController(taskmanager);
            loader.setController(controller);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Aufgabenmanager");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
