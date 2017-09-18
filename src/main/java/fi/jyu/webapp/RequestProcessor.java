package fi.jyu.webapp;

import fi.jyu.soapservice.src.models.DiskModel;
import fi.jyu.webapp.clients.StorageClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class RequestProcessor {
    
    public static String getXmlData(){
        StorageClient storageClient = new StorageClient();
        String xmlData = storageClient.GetList();
        return xmlData;
    }

    public static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }
    
    public static List<DiskModel> getStorageData(){
        List<DiskModel> result = new ArrayList<>();
        String xmlData = getXmlData();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = loadXMLFromString(xmlData);
            Element root = doc.getDocumentElement();
            NodeList nodeList = root.getElementsByTagName("HD");
            for(int i=0; i<nodeList.getLength(); ++i){
                Node elementNode = nodeList.item(i);
                String elementName = elementNode.getTextContent().trim();
                result.add(DiskModel.fromXML(elementName));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
