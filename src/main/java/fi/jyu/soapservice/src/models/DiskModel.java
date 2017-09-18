package fi.jyu.soapservice.src.models;

public class DiskModel {

    Integer id;
    String vendor;
    String type;
    Integer capacity;
    String capacityUnits;
    Integer rpm;
    Integer price;
    String priceUnits;

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
