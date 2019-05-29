package base.form;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import base.Address;
import base.Product;

public class ProductForm implements Forms{
    VBox root = new VBox();
    TextField name = new TextField();
    TextField prod = new TextField();
    TextField prodItem = new TextField();
    TextField count = new TextField();
    TextField city = new TextField();
    TextField street = new TextField();
    TextField house = new TextField();
    Button continueB  = new Button();

    public ProductForm(Stage stage){
        HBox cityBox = new HBox();
        cityBox.getChildren().addAll(new Text("Город:"), city);
        HBox streetBox = new HBox();
        streetBox.getChildren().addAll(new Text("Улица:"), street);
        HBox houseBox = new HBox();
        houseBox.getChildren().addAll(new Text("Дом:"), house);
        HBox buttonBox = new HBox();
        Button exit = new Button("Выйти");
        buttonBox.getChildren().addAll(continueB, exit);
        root.getChildren().addAll(new Text("Название товара:"), name, new Text("Название производителя:"),
                prod, new Text("УНП производителя:"),prodItem, new Text("Количество на складе:"), count,
                new Text("Адрес склада"), cityBox, streetBox, houseBox, buttonBox);
        exit.setOnAction(event -> stage.close());
    }
    @Override
    public VBox getRoot() {
        return root;
    }

    public Product getProduct (){
        return new Product(name.getText(), prod.getText(), prodItem.getText(), Integer.parseInt(count.getText()),
                new Address(city.getText(), street.getText(), house.getText()));
    }
    void clearText(){
        name.clear();
        prod.clear();
        prodItem.clear();
        count.clear();
        city.clear();
        street.clear();
        house.clear();
    }
}
