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
public class DeleteByName implements Forms {
    FormByName formByName;
    public DeleteByName(Stage stage, Controller controller, MainWindow mainWindow) {
        formByName= new FormByName(stage);
        formByName.getContinueB().setText("Удалить");
        formByName.getContinueB().setOnAction(event -> {
            List<Product> del = controller.searchByName(formByName.getProduct(),true);
            formByName.addTable(del);
            mainWindow.update();
        });
    }

    @Override
    public VBox getRoot() {
        return formByName.getRoot();
    }
=======
public class DeleteByName extends FormByName {
    public DeleteByName(Stage stage, Controller controller, MainWindow mainWindow) {
        super(stage);
        continueB.setText("Удалить");
        continueB.setOnAction(event -> {
            List<Product> del = controller.searchByName(getProduct(),true);
            addTable(del);
            mainWindow.update();
        });
    }
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
}
