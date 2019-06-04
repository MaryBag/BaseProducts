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
=======
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
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
}
