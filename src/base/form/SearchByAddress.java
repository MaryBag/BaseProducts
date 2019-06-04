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
=======
public class SearchByAddress extends FormByAddress {
    public SearchByAddress(Stage stage, Controller controller) {
        super(stage);
        continueB.setText("Поиск");
        continueB.setOnAction(event -> {
            List<Product> find = controller.searchByAddress(getProduct(), false);
            addTable(find);
        });
    }
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
}
