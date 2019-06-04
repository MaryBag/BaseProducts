package base.form;

import base.Controller;
import base.Product;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

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
}
