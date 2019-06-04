package base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<List<Product>> listL = new ArrayList<>();
    private List<Product> all;
    private int page;
    private int amount;
    private VBox root = new VBox();
    private TableView tableView = new TableView();
    private Text numPage = new Text("стр."+page);
    private HBox hBox2 = new HBox();
    private HBox hBox1 = new HBox();
    private Button lastPage = new Button("стр."+listL.size());
    private Text countPr = new Text();


    public Table(List<Product> list) {
        all=list;
        TextField linePage = new TextField();
        TextField lineCountPr = new TextField();
        Button pageB = new Button("<-перейти");
        Button countPrB = new Button("<-задать");
        countPr.setText("Количество доступных найменований: " + all.size());
        hBox1.getChildren().addAll(new Text("Перейти на стр.:"), linePage, pageB,
                new Text("Количество наименований на стр.:"), lineCountPr, countPrB, countPr);
        amount=10;
        makePage(all);
        makeTable(1);
        HBox prevBox = new HBox();
        HBox nextBox = new HBox();
        Button prev = new Button("<<");
        Button next = new Button(">>");
        Button firstPage = new Button("стр.1");
        lastPage.layout();
        prevBox.getChildren().addAll(firstPage, prev);
        nextBox.getChildren().addAll(next, lastPage);
        numPage.setText("стр."+page);
        hBox2.getChildren().addAll(prevBox, numPage, nextBox);
        root.getChildren().addAll(hBox1, tableView,hBox2);

        pageB.setOnAction(event -> {
            toPage(Integer.parseInt(linePage.getText()));
            linePage.clear();
        });
        countPrB.setOnAction(event -> {
            amount =Integer.parseInt(lineCountPr.getText());
            lineCountPr.clear();
            makePage(all);
            toPage(1);
            lastPage.layout();
            numPage.setText("стр."+page);
            hBox2.layout();
            countPr.setText("Количество доступных найменований: " + list.size());
            hBox1.layout();
            root.layout();
        });
        firstPage.setOnAction(event -> toPage(1));
        prev.setOnAction(event -> toPage(page-1));
        next.setOnAction(event -> toPage(page+1));
        lastPage.setOnAction(event -> toPage(listL.size()));
    }

    private void makeTable(int p){
        page = p;
        ObservableList<Product> tableList;
        try {
            tableList = FXCollections.observableList(listL.get(page-1));
        } catch (Exception e){
            tableList = FXCollections.observableArrayList();
        }
        tableView.setItems(tableList);
        tableView.setFixedCellSize(30);
        TableColumn<Product, Integer> number = new TableColumn<>("№");
        TableColumn<Product, String> name = new TableColumn<>("Название товара");
        TableColumn<Product, String> prod = new TableColumn<>("Название производителя");
        TableColumn<Product, String> prodItem = new TableColumn<>("УНП производителя");
        TableColumn<Product, Integer> count = new TableColumn<>("Количество на складе");
        TableColumn<Product, String> address = new TableColumn<>("Адрес склада");
        number.setCellValueFactory(new PropertyValueFactory<>("num"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        prod.setCellValueFactory(new PropertyValueFactory<>("prod"));
        prodItem.setCellValueFactory(new PropertyValueFactory<>("prodItem"));
        count.setCellValueFactory(new PropertyValueFactory<>("count"));
        address.setCellValueFactory(new PropertyValueFactory<>("dir"));
        tableView.getColumns().addAll(number, name, prod, prodItem, count, address);

        tableView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        number.setMaxWidth(1f * Integer.MAX_VALUE * 3);
        name.setMaxWidth( 1f * Integer.MAX_VALUE * 20);
        prod.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
        prodItem.setMaxWidth( 1f * Integer.MAX_VALUE * 18);
        count.setMaxWidth( 1f * Integer.MAX_VALUE * 14 );
        address.setMaxWidth( 1f * Integer.MAX_VALUE * 25 );

        number.setSortType(TableColumn.SortType.DESCENDING);
        tableView.layout();
     }

     private void toPage (int p){
        if(p>=1 && p<=listL.size()){
            page=p;
            ObservableList<Product> tableList;
            try {
                tableList = FXCollections.observableList(listL.get(page-1));
            } catch (Exception e){
                tableList = FXCollections.observableArrayList();
            }
            tableView.setItems(tableList);
            tableView.layout();
            root.layout();
            numPage.setText("стр."+page);
            hBox2.layout();
        }
     }

    private void makePage (List<Product> all){
        this.all = all;
        listL.clear();
        if(!all.isEmpty()){
            int pageCount = (int) Math.floor(all.size()/amount);
            for (int pageN=0, objNum=0; pageN<pageCount; pageN++){
                List<Product> l = new ArrayList<>();
                for (int y=0; y<amount; y++ ){
                    l.add(all.get(objNum));
                    objNum++;
                }
                listL.add(l);
            }
            if (all.size()%amount!=0) {
                List<Product> l = new ArrayList<>();
                l.clear();
                for (int objNum = all.size() - all.size() % amount; objNum < all.size(); objNum++) {
                    l.add(all.get(objNum));
                }
                listL.add(l);
            }
            lastPage.setText("стр."+listL.size());
        }
        else listL.add(new ArrayList<>());
    }

//    private void makePage (List<Product> all){
//        listL.clear();
//        List<Product> l = new ArrayList<>();
//        int pr=0;
//        for (int pages = 0; pages<Math.floor(all.size()/amount); pages++){
//            l.clear();
//            for(int prL = 0; prL<amount; prL++){
//                l.add(all.get(pr));
//                pr++;
//            }
//            listL.add(l);
//        }
//        if (all.size()%amount!=0){
//            l.clear();
//            for (int prod = pr; prod<all.size(); prod++){
//                l.add(all.get(prod));
//            }
//            listL.add(l);
//        }
//    }

    public void renTable (List<Product> list){
        makePage(list);
        toPage(page);
        lastPage.layout();
        numPage.setText("стр."+page);
        hBox2.layout();
        countPr.setText("Количество доступных найменований: " + list.size());
        hBox1.layout();
        root.layout();

    }


    public VBox getRoot() {
        return root;
    }

}
