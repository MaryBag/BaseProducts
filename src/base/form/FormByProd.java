package base.form;

import base.Address;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import base.Product;
import base.Table;

import java.util.List;

public class FormByProd implements Forms{

    VBox root = new VBox();
    TextField prod = new TextField();
    TextField prodItem = new TextField();
    Button continueB = new Button();

    public FormByProd(Stage stage){
        HBox line = new HBox();
        Button exit = new Button("Выйти");
        line.getChildren().addAll(new Text("Наименование производителя:"), prodItem, continueB, exit);
        root.getChildren().addAll(new Text("УНП производителя:"), prod, line);
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

    public Product getProduct (){
        return  new Product("",prod.getText(),prodItem.getText(), 0,new Address("", "", ""));
    }

    public Button getContinueB() {
        return continueB;
    }
}
