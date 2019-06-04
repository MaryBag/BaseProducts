package base.form;

import base.Controller;
import base.MainWindow;
import base.Product;
<<<<<<< HEAD
import javafx.scene.layout.VBox;
=======
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
import javafx.stage.Stage;

import java.util.List;

<<<<<<< HEAD
public class DeleteByAddress implements Forms {
    FormByAddress formByAddress;
    public DeleteByAddress(Stage stage, Controller controller, MainWindow mainWindow) {
        formByAddress = new FormByAddress(stage);
        formByAddress.getContinueB().setText("Удалить");
        formByAddress.getContinueB().setOnAction(event -> {
            List<Product> del = controller.searchByAddress(formByAddress.getProduct(), true);
            formByAddress.addTable(del);
            mainWindow.update();
        });
    }

    @Override
    public VBox getRoot() {
        return formByAddress.getRoot();
    }
=======
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
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
}
