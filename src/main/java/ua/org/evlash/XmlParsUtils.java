package ua.org.evlash;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


/**
 * Created by Dmitriy on 26.05.2015.
 */
public class XmlParsUtils {

    public static Object unmarshallingJAXB(String xmlFilePath, Class myClass) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(myClass);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        File xmlfile = new File(xmlFilePath);
        Object object = jaxbUnmarshaller.unmarshal(xmlfile);

        return object;
    }

    public static void marshallingJAXB(String filePath, Class myClass, Object object) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(myClass);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        // for getting nice formatted output добавим свойство, которое выдаст нам читабелный формат в результате
        jaxbMarshaller. setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File xmlFile = new File(filePath);
        // Пишем в XML файл
        jaxbMarshaller.marshal(object, xmlFile);
    }

    public static Shop domParser(String filePath) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false); // optional
        DocumentBuilder builder = factory.newDocumentBuilder();
        File xmlFile = new File(filePath);
        Document document = builder.parse(xmlFile);
        NodeList nodeList = document.getElementsByTagName("goods");
        Shop shop = new Shop();
        for (int i = 0; i < nodeList.getLength(); i++){
            Goods goods = new Goods();
            Node goodsNode = nodeList.item(i);
            goods.setId(Integer.parseInt(goodsNode.getAttributes().getNamedItem("id").getTextContent()));
            NodeList goodsElems = goodsNode.getChildNodes();
            for (int j = 0; j < goodsElems.getLength(); j++) {
                switch (goodsElems.item(j).getNodeName()){
                    case "name":
                        goods.setName(goodsElems.item(j).getTextContent());
                        break;
                    case "priсe":
                        goods.setPriсe(Double.parseDouble(goodsElems.item(j).getTextContent()));
                        break;
                    case "category":
                        goods.setCategory(goodsElems.item(j).getTextContent());
                        break;
                    case "description":
                        goods.setDescription(goodsElems.item(j).getTextContent());
                        break;
                }
            }
            shop.getSklad().add(goods);
        }
        return shop;
    }

    public static Shop saxParser(String filePath) throws Exception{
        File xmlFile = new File(filePath);
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = parserFactor.newSAXParser();
        SAXHandler handler = new SAXHandler();
        parser.parse(xmlFile ,handler);

        return handler.shop;
    }
}
