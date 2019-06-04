package base.form;

import base.Controller;
import base.MainWindow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Add implements Forms  {

    ProductForm productForm;

    public Add(Stage stage, Controller controller, MainWindow mainWindow) {
        productForm = new ProductForm(stage);
        productForm.getContinueB().setText("Добавить");
        productForm.getContinueB().setOnAction(event -> {
            controller.addProd(productForm.getProduct());
            productForm.clearText();
            mainWindow.update();
            //stage.close();
        });
    }

    @Override
    public VBox getRoot() {
        return productForm.getRoot();
    }
}
