package base;

import java.util.List;

public class Controller {
    Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void addProd (Product product){
        model.addProd(product);
    }

    public Product deleteProd (Product product){
        return model.deleteProd(product);
    }
    public List<Product> searchByName (Product product, boolean delete){
        return model.searchByName(product, delete);
    }
    public List<Product> searchByProd (Product product, boolean delete){
        return model.searchByProd(product, delete);
    }
    public List<Product> searchByAddress(Product product, boolean delete){
        return model.searchByAddress(product, delete);
    }
    public List<Product> getList (){
        return model.getList();
    }
    public void setList (List<Product> list) {model.setList(list);}
    public void clearList(){ model.clearList();}
}
