package base;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Product> list;

    public Model (){
        list = new ArrayList<>();
    }


    private void setProdNumber(){
        int  num = 1;
        for (Product pr : list){
            pr.setNum(num);
            num++;
        }
    }

    public void addProd (Product product){
        boolean ch = false;
        for (Product pr: list){
            if (pr.equals(product)){
                pr.setCount(pr.getIntCount()+product.getIntCount());
                ch = true;
                break;
            }
        }
        if (!ch){
            list.add(product);
        }
        setProdNumber();
    }

    public Product deleteProd (Product product){
        Product del = new Product("","", "",0, new Address("","",""));
        for (Product pr: list){
            if (pr.equals(product)){
                if (pr.getIntCount()>product.getIntCount()){
                    pr.setCount(pr.getIntCount()+product.getIntCount());
                } else {
                    list.remove(pr);
                }
                del = pr;
                break;
            }
        }
        setProdNumber();
        return del;
    }

    public List<Product> searchByName (Product product, boolean delete){
        List<Product> find = new ArrayList<>();
        List<Product> l =new ArrayList<>(list);
        for (Product pr : l){
            if (pr.getName().equals(product.getName()) || pr.getIntCount()==product.getIntCount()){
                Product f = new Product(Integer.parseInt(pr.getNum()),pr.getName(), pr.getProd(), pr.getProdItem(),
                        Integer.parseInt(pr.getCount()),pr.getAddress());
                find.add(f);
                if (delete){
                    list.remove(pr);
                }
            }
        }
        if (delete)
            setProdNumber();
        return find;
    }

    public List<Product> searchByProd (Product product, boolean delete){
        List<Product> l =new ArrayList<>(list);
        List<Product> find = new ArrayList<>();
        for (Product pr : l){
            if (pr.getProd().equals(product.getProd()) || pr.getProdItem().equals(product.getProdItem())){
                Product f = new Product(Integer.parseInt(pr.getNum()),pr.getName(), pr.getProd(), pr.getProdItem(),
                        Integer.parseInt(pr.getCount()),pr.getAddress());
                find.add(f);
                if (delete){
                    list.remove(pr);
                }
            }
        }
        if (delete)
            setProdNumber();
        return find;
    }

    public  List<Product> searchByAddress (Product product, boolean delete){
        List<Product> find  = new ArrayList<>();
        List<Product> l =new ArrayList<>(list);
        for (Product pr : l){
            if (pr.getAddress().equals(product.getAddress())){
                Product f = new Product(Integer.parseInt(pr.getNum()), pr.getName(), pr.getProd(), pr.getProdItem(),
                        Integer.parseInt(pr.getCount()),pr.getAddress());
                find.add(f);
                if (delete){
                    list.remove(pr);
                }
            }
        }
        if (delete)
            setProdNumber();
        return find;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
        setProdNumber();
    }
    public void clearList(){
        list.clear();
    }
}
