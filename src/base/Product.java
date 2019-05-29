package base;

import java.util.Objects;

public class Product {
    private int num;
    private String name;
    private String prod;
    private String prodItem;
    private int count;
    private Address address;
    private String dir;

    public Product(int number, String name, String prod, String prodItem, int count, Address address) {
        this.num=number;
        this.name = name;
        this.prod = prod;
        this.prodItem = prodItem;
        this.count = count;
//        try {
//            this.count = Integer.parseInt(count);
//        } catch (Exception e){
//           this.count=0;
//        }
        this.address = address;
        try {
            dir = address.toStringAddress();
        } catch (NullPointerException e){
            dir="";
        }
    }
    public Product(String name, String prod, String prodItem, int count, Address address) {
        this.name = name;
        this.prod = prod;
        this.prodItem = prodItem;
//        try {
//            this.count = Integer.parseInt(count);
//        } catch (Exception e){
//            this.count=0;
//        }
        this.count=count;
        this.address = address;
        try {
            dir = address.toStringAddress();
        } catch (NullPointerException e){
            dir="";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(prod, product.prod) &&
                Objects.equals(prodItem, product.prodItem) &&
                Objects.equals(address, product.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prod, prodItem, address);
    }

    public String getName() {
        return name;
    }

    public String getProd() {
        return prod;
    }

    public String getProdItem() {
        return prodItem;
    }

    public int getIntCount() {
        return count;
    }

    public String getCount(){
        return Integer.toString(count);
    }

    public Address getAddress() {
        return address;
    }

    public String getDir() {
        return dir;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNum() {
        return Integer.toString(num);
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setAddress(Address address) {
        this.address = address;
        dir = address.toStringAddress();
    }
}
