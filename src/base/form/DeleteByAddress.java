package base.form;

import base.Controller;
import base.MainWindow;
import base.Product;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

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
}
