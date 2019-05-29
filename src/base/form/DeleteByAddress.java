package base.form;

import base.Controller;
import base.MainWindow;
import base.Product;
import javafx.stage.Stage;

import java.util.List;

public class DeleteByAddress extends FormByAddress {
    public DeleteByAddress(Stage stage, Controller controller, MainWindow mainWindow) {
        super(stage);
        continueB.setText("Удалить");
        continueB.setOnAction(event -> {
            List<Product> del = controller.searchByAddress(getProduct(), true);
            addTable(del);
            mainWindow.update();
        });
    }
}
