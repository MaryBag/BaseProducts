package base;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Model model = new Model();
        Controller controller = new Controller(model);
        MainWindow mainWindow  = new MainWindow(controller, primaryStage);
        Scene scene = new Scene(mainWindow.getRoot(), mainWindow.getRoot().getPrefWidth(),
                mainWindow.getRoot().getPrefHeight());
        primaryStage.setTitle("База продуктов");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
