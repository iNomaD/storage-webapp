package fi.jyu.webapp;

import fi.jyu.webapp.clients.CurrencyConvertorClient;
import fi.jyu.webapp.clients.StorageClient;
import fi.jyu.webapp.clients.UnitConvertorClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;

public class Processing {
    private String Disks;
    private double Currency;
    private double Gbtomb;

    public void getDisks(){
        StorageClient storageClient = new StorageClient();
        Disks = storageClient.GetList();
    }
    public void getCurrency(){
        CurrencyConvertorClient cclient = new CurrencyConvertorClient();
        double currency = 0;
        try{
            currency = cclient.sendRequest(1, "USD");}
        catch (ParseException | DatatypeConfigurationException e) { e.printStackTrace();}
        Currency = currency;
    }

    public void getGBtoMB(){
        UnitConvertorClient uclient = new UnitConvertorClient();
        Gbtomb = uclient.sendRequest(1, "Gigabyte","Megabyte");
    }

    public String processXML(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = db.parse(new InputSource(new StringReader(Disks)));
            System.out.println(doc);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element dataTag = doc.getDocumentElement();
        for(int i=0;i<dataTag.getElementsByTagName("HD").getLength();i++){
            Element hdTag = (Element) dataTag.getElementsByTagName("HD").item(i);
            Element PriceEUR = doc.createElement("PriceEUR");
            Element CapMB = doc.createElement("CapMB");
            double temppr = Double.valueOf(hdTag.getElementsByTagName("Price").item(0).getTextContent())*Currency;
            PriceEUR.setTextContent(String.valueOf(temppr));
            hdTag.appendChild(PriceEUR);
            double tempcap = Double.valueOf(hdTag.getElementsByTagName("Capacity").item(0).getTextContent())*Gbtomb;
            CapMB.setTextContent(String.valueOf(tempcap));
            hdTag.appendChild(CapMB);
        }
        DOMImplementationLS domImplementation = (DOMImplementationLS) doc.getImplementation();
        LSSerializer lsSerializer = domImplementation.createLSSerializer();
        String result = lsSerializer.writeToString(doc);
        return result;
    }
    public String  getDiskByID(String i){
        StorageClient storageClient = new StorageClient();
        Disks = storageClient.GetHD(i);
        return Disks;
    }
}
