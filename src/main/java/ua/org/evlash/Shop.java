package ua.org.evlash;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Shop {

    private List<Goods> sklad = new ArrayList<Goods>();

    public Shop(){

    }

    public List<Goods> getSklad() {
        return sklad;
    }
    @XmlElement(name = "goods")
    public void setSklad(List<Goods> sklad) {
        this.sklad = sklad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Shop:\n");
        for (Goods goods : sklad) {
            sb.append(goods.toString()).append("\n");
        }

        return sb.toString();
    }
}
