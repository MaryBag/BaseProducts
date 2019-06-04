package base.form;

import base.Controller;
import base.MainWindow;
import base.Product;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class DeleteByProd implements Forms {
    FormByProd formByProd;
    public DeleteByProd(Stage stage, Controller controller, MainWindow mainWindow) {
        formByProd = new FormByProd(stage);
        formByProd.getContinueB().setText("Удалить");
        formByProd.getContinueB().setOnAction(event -> {
            List<Product> del = controller.searchByProd(formByProd.getProduct(), true);
            formByProd.addTable(del);
            mainWindow.update();
        });
    }

    @Override
    public VBox getRoot() {
        return formByProd.getRoot();
    }
}
