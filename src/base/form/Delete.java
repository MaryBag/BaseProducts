package base.form;

import base.Controller;
import base.MainWindow;
import base.Product;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

<<<<<<< HEAD
public class Delete implements Forms {

    VBox rootB = new VBox();
    ProductForm productForm;


    public Delete(Stage stage, Controller controller, MainWindow mainWindow) {
       productForm = new ProductForm(stage);
        productForm.getContinueB().setText("Удалить");
        productForm.getContinueB().setOnAction(event -> {
            Product del = controller.deleteProd(productForm.getProduct());
=======
public class Delete extends ProductForm {

    VBox rootB = new VBox();

    public Delete(Stage stage, Controller controller, MainWindow mainWindow) {
        super(stage);
        continueB.setText("Удалить");
        continueB.setOnAction(event -> {
            Product del = controller.deleteProd(getProduct());
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
            if (!del.getName().equals("")){
                rootB.getChildren().addAll(new Text(del.getName()), new Text(del.getProd()),new Text(del.getProdItem()),
                        new Text(del.getCount()), new Text(del.getDir()));
                dialog();
<<<<<<< HEAD
                productForm.clearText();
=======
                clearText();
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
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
<<<<<<< HEAD

    @Override
    public VBox getRoot() {
        return productForm.getRoot();
    }
=======
>>>>>>> 6fe6e995c99183008d07a4b996c37dc7db1dabff
}
