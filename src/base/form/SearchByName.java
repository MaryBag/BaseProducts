package base.form;

import base.Controller;
import base.Product;
import javafx.stage.Stage;

import java.util.List;

public class SearchByName extends FormByName {
    public SearchByName(Stage stage, Controller controller) {
        super(stage);
        continueB.setText("Поиск");
        continueB.setOnAction(event -> {
            List<Product> find = controller.searchByName(getProduct(),false);
            addTable(find);
        });
    }
}
