package base.form;

import base.Controller;
import base.MainWindow;
<<<<<<< HEAD
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
=======
import javafx.stage.Stage;

public class Add extends ProductForm {


    public Add(Stage stage, Controller controller, MainWindow mainWindow) {
        super(stage);
        continueB.setText("Добавить");
        continueB.setOnAction(event -> {
            controller.addProd(getProduct());
            clearText();
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
            mainWindow.update();
            //stage.close();
        });
    }
<<<<<<< HEAD

    @Override
    public VBox getRoot() {
        return productForm.getRoot();
    }
=======
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
}
