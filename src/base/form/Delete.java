package base.form;

import base.Controller;
import base.MainWindow;
import base.Product;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Delete implements Forms {

    VBox rootB = new VBox();
    ProductForm productForm;


    public Delete(Stage stage, Controller controller, MainWindow mainWindow) {
       productForm = new ProductForm(stage);
        productForm.getContinueB().setText("Удалить");
        productForm.getContinueB().setOnAction(event -> {
            Product del = controller.deleteProd(productForm.getProduct());
            if (!del.getName().equals("")){
                rootB.getChildren().addAll(new Text(del.getName()), new Text(del.getProd()),new Text(del.getProdItem()),
                        new Text(del.getCount()), new Text(del.getDir()));
                dialog();
                productForm.clearText();
                mainWindow.update();
            } else {
                rootB.getChildren().addAll(new Text("Товар не найден!"));
                dialog();
            }
        });
    }
    void dialog (){
        Stage st =new Stage();
        Scene scene = new Scene(rootB, 100,100);
        st.setTitle("Удаление");
        st.setScene(scene);
        st.show();
    }

    @Override
    public VBox getRoot() {
        return productForm.getRoot();
    }
}
