package base.form;

import base.Controller;
import base.Product;
<<<<<<< HEAD
import javafx.scene.layout.VBox;
=======
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
import javafx.stage.Stage;

import java.util.List;

<<<<<<< HEAD
public class SearchByProd implements Forms {
    FormByProd formByProd;
    public SearchByProd(Stage stage, Controller controller) {
        formByProd = new FormByProd(stage);
        formByProd.getContinueB().setText("Поиск");
        formByProd.getContinueB().setOnAction(event -> {
            List<Product> find = controller.searchByProd(formByProd.getProduct(), false);
            formByProd.addTable(find);
        });
    }

    @Override
    public VBox getRoot() {
        return formByProd.getRoot();
    }
=======
public class SearchByProd extends FormByProd {
    public SearchByProd(Stage stage, Controller controller) {
        super(stage);
        continueB.setText("Поиск");
        continueB.setOnAction(event -> {
            List<Product> find = controller.searchByProd(getProduct(), false);
            addTable(find);
        });
    }
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
}
