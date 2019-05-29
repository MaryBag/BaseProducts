package base.form;

import base.Controller;
import base.MainWindow;
import base.Product;
import javafx.stage.Stage;

import java.util.List;

public class DeleteByProd extends FormByProd {
    public DeleteByProd(Stage stage, Controller controller, MainWindow mainWindow) {
        super(stage);
        continueB.setText("Удалить");
        continueB.setOnAction(event -> {
            List<Product> del = controller.searchByProd(getProduct(), true);
            addTable(del);
            mainWindow.update();
        });
    }
}
