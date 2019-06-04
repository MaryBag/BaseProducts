package base.form;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import base.Address;
import base.Product;
import base.Table;

import java.util.List;

public class FormByAddress implements Forms{

    VBox root = new VBox();
    TextField city = new TextField();
    TextField street = new TextField();
    TextField house = new TextField();
    Button continueB = new Button();

    public FormByAddress(Stage stage){
        Button exit = new Button("Выйти");
        HBox cityBox = new HBox();
        cityBox.getChildren().addAll(new Text("Город:"), city);
        HBox streetBox = new HBox();
        streetBox.getChildren().addAll(new Text("Улица:"),street);
        HBox houseBox = new HBox();
        houseBox.getChildren().addAll(new Text("Дом:"), house,continueB, exit);
        root.getChildren().addAll(cityBox, streetBox, houseBox);
        exit.setOnAction(event -> stage.close());
    }
    @Override
    public VBox getRoot() {
        return root;
    }

    public void addTable(List<Product> list){
        Table table = new Table(list);
        root.getChildren().add(table.getRoot());
        root.layout();
    }
    public Product getProduct(){
        return new Product("", "", "", 0,
                new Address(city.getText(), street.getText(), house.getText()));
    }
<<<<<<< HEAD

    public Button getContinueB() {
        return continueB;
    }
=======
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
}
