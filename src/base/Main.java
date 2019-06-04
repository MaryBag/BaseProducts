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
<<<<<<< HEAD
        Scene scene = new Scene(mainWindow.getRoot());
        primaryStage.setTitle("База продуктов");
        primaryStage.setScene(scene);
        primaryStage.show();

        // add commits
=======
        Scene scene = new Scene(mainWindow.getRoot(), mainWindow.getRoot().getPrefWidth(),
                mainWindow.getRoot().getPrefHeight());
        primaryStage.setTitle("База продуктов");
        primaryStage.setScene(scene);
        primaryStage.show();
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
    }


    public static void main(String[] args) {
        launch(args);
    }
}
