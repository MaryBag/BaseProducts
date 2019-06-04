package base.form;

import base.Controller;
import base.MainWindow;
import base.Product;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

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
}
