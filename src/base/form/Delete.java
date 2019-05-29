package base.form;

import base.Controller;
import base.MainWindow;
import base.Product;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Delete extends ProductForm {

    VBox rootB = new VBox();

    public Delete(Stage stage, Controller controller, MainWindow mainWindow) {
        super(stage);
        continueB.setText("Удалить");
        continueB.setOnAction(event -> {
            Product del = controller.deleteProd(getProduct());
            if (!del.getName().equals("")){
                rootB.getChildren().addAll(new Text(del.getName()), new Text(del.getProd()),new Text(del.getProdItem()),
                        new Text(del.getCount()), new Text(del.getDir()));
                dialog();
                clearText();
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
}
