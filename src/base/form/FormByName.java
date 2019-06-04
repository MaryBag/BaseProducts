package base.form;

import base.Address;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import base.Product;
import base.Table;

import java.util.List;

public class FormByName implements Forms {

    VBox root = new VBox();
    TextField name = new TextField();
    TextField count = new TextField();
    Button continueB = new Button();

    public FormByName (Stage stage){
        HBox buttonBox = new HBox();
        Button exit = new Button("Выйти");
        buttonBox.getChildren().addAll(new Text("Количество на складе:"), count,continueB, exit);
        root.getChildren().addAll(new Text("Название товара:"), name, buttonBox);
        exit.setOnAction(event -> stage.close());
    }
    @Override
    public VBox getRoot() {
        return root;
    }

    public Product getProduct(){
        return new Product(name.getText(), "", "", Integer.parseInt(count.getText()),
                new Address("","",""));
    }

    public void addTable(List<Product> list){
        Table table = new Table(list);
        root.getChildren().add(table.getRoot());
        root.layout();
    }

    public Button getContinueB() {
        return continueB;
    }
}
