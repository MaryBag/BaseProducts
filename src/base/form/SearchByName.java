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
=======
public class SearchByName extends FormByName {
    public SearchByName(Stage stage, Controller controller) {
        super(stage);
        continueB.setText("Поиск");
        continueB.setOnAction(event -> {
            List<Product> find = controller.searchByName(getProduct(),false);
            addTable(find);
        });
    }
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
}
