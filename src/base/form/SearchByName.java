package base.form;

import base.Controller;
import base.Product;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class SearchByName implements Forms {
    FormByName formByName;
    public SearchByName(Stage stage, Controller controller) {
        formByName = new FormByName(stage);
        formByName.getContinueB().setText("Поиск");
        formByName.getContinueB().setOnAction(event -> {
            List<Product> find = controller.searchByName(formByName.getProduct(),false);
            formByName.addTable(find);
        });
    }

    @Override
    public VBox getRoot() {
        return formByName.getRoot();
    }
}
