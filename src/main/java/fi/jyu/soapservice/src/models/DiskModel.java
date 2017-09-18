package fi.jyu.soapservice.src.models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class DiskModel {

    Integer id;
    String vendor;
    String type;
    Integer capacity;
    String capacityUnits;
    Integer rpm;
    Integer price;
    String priceUnits;

    public DiskModel(){}

    public DiskModel(Integer id, String vendor, String type, Integer capacity, String capacityUnits, Integer rpm, Integer price, String priceUnits) {
        this.id = id;
        this.vendor = vendor;
        this.type = type;
        this.capacity = capacity;
        this.capacityUnits = capacityUnits;
        this.rpm = rpm;
        this.price = price;
        this.priceUnits = priceUnits;
    }

    public String toXML(){
        return ("<HD><ID>" + id + "</ID><Vendor>" + vendor + "</Vendor><Type>" + type +
                "</Type><Capacity>" + capacity + "</Capacity><CapacityUnits>" + capacityUnits + "</CapacityUnits><Rpm>" +
                rpm + "</Rpm><Price>" + price + "</Price><PriceUnits>" + priceUnits + "</PriceUnits></HD>");
    }

    public static DiskModel fromXML(String xmlData){
        DiskModel disk = new DiskModel();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = db.parse(new InputSource(new StringReader(xmlData)));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NodeList nList = doc.getElementsByTagName("HD");
        disk.id = Integer.valueOf(((Element) nList.item(0)).getElementsByTagName("ID").item(0).getTextContent());
        disk.capacity = Integer.valueOf(((Element) nList.item(0)).getElementsByTagName("Capacity").item(0).getTextContent());
        disk.price = Integer.valueOf(((Element) nList.item(0)).getElementsByTagName("Price").item(0).getTextContent());
        disk.rpm = Integer.valueOf(((Element) nList.item(0)).getElementsByTagName("Rpm").item(0).getTextContent());
        disk.vendor = ((Element) nList.item(0)).getElementsByTagName("Vendor").item(0).getTextContent();
        disk.type = ((Element) nList.item(0)).getElementsByTagName("Type").item(0).getTextContent();
        disk.capacityUnits = ((Element) nList.item(0)).getElementsByTagName("CapacityUnits").item(0).getTextContent();
        disk.priceUnits = ((Element) nList.item(0)).getElementsByTagName("priceUnits").item(0).getTextContent();
        return disk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getCapacityUnits() {
        return capacityUnits;
    }

    public void setCapacityUnits(String capacityUnits) {
        this.capacityUnits = capacityUnits;
    }

    public Integer getRpm() {
        return rpm;
    }

    public void setRpm(Integer rpm) {
        this.rpm = rpm;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceUnits() {
        return priceUnits;
    }

    public void setPriceUnits(String priceUnits) {
        this.priceUnits = priceUnits;
    }
}
