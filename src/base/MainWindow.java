package base;

import base.form.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainWindow {
    Controller controller;
    BorderPane root = new BorderPane();
    Stage stage;
    Table table;

    public MainWindow(Controller controller, Stage stage){
        this.controller = controller;
        this.stage=stage;
        VBox mainBox = new VBox();
        root.setCenter(mainBox);
        makeMenu();
        FlowPane buttons = new FlowPane();

        Button addB = new Button("Добавить");
        Button deleteB = new Button("Удалить");
        Button searchNameB = new Button("Поиск по наименованию или количеству");
        Button searchProdB = new Button("Поиск по производителю или УНП производителя");
        Button searchAddressB = new Button("Поиск по адресу склада");
        Button delNameB = new Button("Удаление по наименованию или количеству");
        Button delProdB = new Button("Удаление по производителю или УНП производителя");
        Button delAddressB = new Button("Удаление по адресу склада");
        buttons.getChildren().addAll(addB, deleteB, searchNameB, searchProdB, searchAddressB, delNameB, delProdB, delAddressB);

        table = new Table(controller.getList());
        mainBox.getChildren().addAll(buttons, table.getRoot());

        addB.setOnAction(event -> eventAdd());
        deleteB.setOnAction(event -> eventDel());
        searchNameB.setOnAction(event -> eventSearchByName());
        searchProdB.setOnAction(event -> eventSearchByProd());
        searchAddressB.setOnAction(event -> eventSearchByAddress());
        delNameB.setOnAction(event -> eventDelByName());
        delProdB.setOnAction(event -> eventDelByProd());
        delAddressB.setOnAction(event -> eventDelByAddress());
    }

    private void makeMenu(){
        MenuBar menuBar = new MenuBar();
        root.setTop(menuBar);

        Menu fileMenu = new Menu("Файл");
        Menu editMenu = new Menu("Редактирование");
        Menu searchM = new Menu("Поиск по критериям");
        Menu deleteM = new Menu("Удаление по критериям");
        menuBar.getMenus().addAll(fileMenu, editMenu, searchM, deleteM);

        MenuItem newF = new MenuItem("Сохранить");
        MenuItem openF = new MenuItem("Открыть");
        MenuItem exitF = new MenuItem("Выйти");
        fileMenu.getItems().addAll(newF, openF, exitF);

        MenuItem addM = new MenuItem("Добавить");
        MenuItem delM = new MenuItem("Удалить");
        editMenu.getItems().addAll(addM, delM);

        MenuItem searchByName = new MenuItem("Поиск по наименованию или количеству");
        MenuItem searchByProd = new MenuItem("Поиск по производителю или УНП производителя");
        MenuItem searchByAddress = new MenuItem("Поиск по адресу склада");
        searchM.getItems().addAll(searchByName, searchByProd, searchByAddress);

        MenuItem delByName = new MenuItem("Удаление по наименованию или количеству");
        MenuItem delByProd = new MenuItem("Удаление по производителю или УНП производителя");
        MenuItem delByAddress = new MenuItem("Удаление по адресу склада");
        deleteM.getItems().addAll(delByName, delByProd, delByAddress);

        newF.setOnAction(event -> eventNewF());
        openF.setOnAction(event -> eventOpen());
        exitF.setOnAction(event -> {
            eventNewF();
            stage.close();
        });
        addM.setOnAction(event -> eventAdd());
        delM.setOnAction(event -> eventDel());
        searchByName.setOnAction(event -> eventSearchByName());
        searchByProd.setOnAction(event -> eventSearchByProd());
        searchByAddress.setOnAction(event -> eventSearchByAddress());
        delByName.setOnAction(event -> eventDelByName());
        delByProd.setOnAction(event -> eventDelByProd());
        delByAddress.setOnAction(event -> eventDelByAddress());
    }

    private void eventNewF (){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранение документа");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(stage);
        DomParser dom = new DomParser();
        try {
            dom.write(controller.getList(), file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.exists();
    }

    private void eventOpen(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        SaxParser saxParser = new SaxParser();
        controller.clearList();
        try {
            controller.setList(saxParser.read(file));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        file.exists();
        table.renTable(controller.getList());
        root.layout();

    }

    private void dialog (Forms form, Stage st){
        Scene scene = new Scene(form.getRoot(), root.getPrefWidth(),root.getPrefHeight());
        st.setScene(scene);
        st.show();
    }

    private void eventAdd(){
        Stage dialogStage = new Stage();
        Forms add = new Add(dialogStage, controller, MainWindow.this);
        dialogStage.setTitle("Добавление товара");
        dialog(add, dialogStage);
    }

    private void eventDel(){
        Stage dialogStage = new Stage();
        Forms del = new Delete(dialogStage, controller, MainWindow.this);
        dialogStage.setTitle("Удаление товара");
        dialog(del, dialogStage);
    }

    private void eventSearchByName(){
        Stage st = new Stage();
        Forms form = new SearchByName(st, controller);
        st.setTitle("Поиск по наименованию или количеству товара");
        dialog(form, st);
    }

    private void eventSearchByProd(){
        Stage st = new Stage();
        Forms form = new SearchByProd(st, controller);
        st.setTitle("Поиск по наименованию или УНП производителя");
        dialog(form, st);
    }

    private void eventSearchByAddress (){
        Stage st = new Stage();
        Forms form = new SearchByAddress(st, controller);
        st.setTitle("Поиск по адресу склада");
        dialog(form, st);
    }

    private void eventDelByName(){
        Stage st = new Stage();
        Forms form = new DeleteByName(st, controller,  MainWindow.this);
        st.setTitle("Удаление по наименованию или количеству товара");
        dialog(form, st);
    }

    private void eventDelByProd (){
        Stage st = new Stage();
        Forms form = new DeleteByProd(st, controller,  MainWindow.this);
        st.setTitle("Удаление по наименованию или УНП производителя");
        dialog(form, st);
    }

    private void eventDelByAddress(){
        Stage st = new Stage();
        Forms form = new DeleteByAddress(st, controller,  MainWindow.this);
        st.setTitle("Удаление по адресу склада");
        dialog(form, st);
    }

    public BorderPane getRoot() {
        return root;
    }

    public void update() {
        List<Product> list = controller.getList();
        table.renTable(list);
    }
}
