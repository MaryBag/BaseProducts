package base;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DomParser {

    public void write (List<Product> list, File file) throws ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element listD = document.createElement("list");

        document.appendChild(listD);

        for(Product pr : list){
            Element product = document.createElement("product");
            product.setAttribute("number", pr.getNum());
            product.setAttribute("name", pr.getName());
            product.setAttribute("prod", pr.getProd());
            product.setAttribute("prodItem", pr.getProdItem());
            product.setAttribute("count", pr.getCount());
            Element address = document.createElement("address");
            address.setAttribute("city", pr.getAddress().getCity());
            address.setAttribute("street", pr.getAddress().getStreet());
            address.setAttribute("house", pr.getAddress().getHouse());
            product.appendChild(address);
            listD.appendChild(product);
        }


        DOMImplementation implementation = document.getImplementation();
        DOMImplementationLS implLS = (DOMImplementationLS) implementation.getFeature("LS", "3.0");
        LSSerializer serializer = implLS.createLSSerializer();
        serializer.getDomConfig().setParameter("format-pretty-print",true);

        String str = serializer.writeToString(document);

        LSOutput output = implLS.createLSOutput();
        output.setEncoding("UTF-8");
        output.setByteStream(Files.newOutputStream(file.toPath()));
        serializer.write(document,output);

        file.exists();

    }
}
