package base.form;

import base.Controller;
import base.Product;
import javafx.stage.Stage;

import java.util.List;

public class SearchByProd extends FormByProd {
    public SearchByProd(Stage stage, Controller controller) {
        super(stage);
        continueB.setText("Поиск");
        continueB.setOnAction(event -> {
            List<Product> find = controller.searchByProd(getProduct(), false);
            addTable(find);
        });
    }
}
