package ua.org.evlash;

/**
 * Created by Dmitriy on 26.05.2015.
 */
public class App {

    public static void main(String[] args) throws Exception {

        Shop myShop = (Shop)XmlParsUtils.unmarshallingJAXB("shop.xml", Shop.class);
        System.out.println("JAXB unmarshalling");
        System.out.println(myShop);

        XmlParsUtils.marshallingJAXB("shopMarshalling.xml", Shop.class, myShop);
        System.out.println("SAX");
        System.out.println(XmlParsUtils.saxParser("shop.xml"));
        System.out.println("DOM");
        System.out.println(XmlParsUtils.domParser("shop.xml"));
    }
}
