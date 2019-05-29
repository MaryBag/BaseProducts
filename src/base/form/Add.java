package base.form;

import base.Controller;
import base.MainWindow;
import javafx.stage.Stage;

public class Add extends ProductForm {


    public Add(Stage stage, Controller controller, MainWindow mainWindow) {
        super(stage);
        continueB.setText("Добавить");
        continueB.setOnAction(event -> {
            controller.addProd(getProduct());
            clearText();
            mainWindow.update();
            //stage.close();
        });
    }
}
