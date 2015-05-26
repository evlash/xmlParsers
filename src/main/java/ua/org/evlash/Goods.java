package ua.org.evlash;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "ua.org.evlash.Shop")
@XmlType(propOrder = {"name", "priсe", "category", "description"})
public class Goods {

    private int id;

    private String name;

    private double priсe;

    private String category;

    private String description;

    public Goods(){
    }

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public double getPriсe() {
        return priсe;
    }
    @XmlElement
    public void setPriсe(double priсe) {
        this.priсe = priсe;
    }

    public String getCategory() {
        return category;
    }
    @XmlElement
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }
    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priсe=" + priсe +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
