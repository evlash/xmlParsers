package ua.org.evlash;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {

    Shop shop = null;
    Goods goods = null;
    String contant = null;

    @Override
    public void startDocument() throws SAXException {
       shop = new Shop();
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       switch (qName){
           case "goods":
               goods = new Goods();
               goods.setId(Integer.parseInt(attributes.getValue("id")));
           break;
           case "name":
               break;
           case "priсe":
               break;
           case "category":
               break;
           case "description":
               break;
       }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "goods":
                shop.getSklad().add(goods);
                break;
            case "name":
                goods.setName(contant);
                break;
            case "priсe":
                goods.setPriсe(Double.parseDouble(contant));
                break;
            case "category":
                goods.setCategory(contant);
                break;
            case "description":
                goods.setDescription(contant);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        contant = String.copyValueOf(ch, start, length);
    }
}
