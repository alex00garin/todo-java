package todo.todoapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ToDoApp extends Application {

    public ToDoApp() {
        super();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("ToDo App");

        // Initialize the UI components
        FXMLLoader loader = new FXMLLoader(getClass().getResource("todo.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
