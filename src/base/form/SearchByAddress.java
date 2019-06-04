package base.form;

import base.Controller;
import base.Product;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class SearchByAddress implements Forms {
    FormByAddress formByAddress;
    public SearchByAddress(Stage stage, Controller controller) {
        formByAddress = new FormByAddress(stage);
        formByAddress.getContinueB().setText("Поиск");
        formByAddress.getContinueB().setOnAction(event -> {
            List<Product> find = controller.searchByAddress(formByAddress.getProduct(), false);
            formByAddress.addTable(find);
        });
    }

    @Override
    public VBox getRoot() {
        return formByAddress.getRoot();
    }
}
