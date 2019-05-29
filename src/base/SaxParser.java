package base;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser extends DefaultHandler {
    private static List<Product> list = new ArrayList<>();

    public List<Product> read (File file) throws ParserConfigurationException, SAXException, IOException {
        list.clear();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(file, handler);
        file.exists();
        return list;
    }
    private static class XMLHandler extends DefaultHandler {
        boolean prod = false;
        boolean dir = false;
        Product product;
        Address address = new Address("","","");
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("product")) {
                prod = true;
                dir=false;
                String number = attributes.getValue("number");
                String name = attributes.getValue("name");
                String manufacture = attributes.getValue("prod");
                String manufactureItem = attributes.getValue("prodItem");
                String count = attributes.getValue("count");
                product = new Product(Integer.parseInt(number),name, manufacture, manufactureItem,
                        Integer.parseInt(count),address);
            }
            if (qName.equals("address")){
                dir = true;
                String city = attributes.getValue("city");
                String street = attributes.getValue("street");
                String building = attributes.getValue("house");
                address = new Address(city,street,building);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if(dir){
                dir=false;
                product.setAddress(address);
            }
            if(prod){
                prod=false;
                list.add(product);
            }
        }


    }
}
