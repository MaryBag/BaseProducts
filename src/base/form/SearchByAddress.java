package base.form;

import base.Controller;
import base.Product;
import javafx.stage.Stage;

import java.util.List;

public class SearchByAddress extends FormByAddress {
    public SearchByAddress(Stage stage, Controller controller) {
        super(stage);
        continueB.setText("Поиск");
        continueB.setOnAction(event -> {
            List<Product> find = controller.searchByAddress(getProduct(), false);
            addTable(find);
        });
    }
}
