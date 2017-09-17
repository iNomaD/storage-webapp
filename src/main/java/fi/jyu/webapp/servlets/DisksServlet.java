package fi.jyu.webapp.servlets;

import fi.jyu.webapp.clients.CurrencyConvertorClient;
import fi.jyu.webapp.clients.StorageClient;
import fi.jyu.webapp.clients.UnitConvertorClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.ParseException;

@WebServlet("/Disks")
public class DisksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StorageClient storageClient = new StorageClient();
        String disks = storageClient.GetList();
        CurrencyConvertorClient cclient = new CurrencyConvertorClient();
        UnitConvertorClient uclient = new UnitConvertorClient();
        double gbtomb = uclient.sendRequest(1, "Gigabyte","Megabyte");
        double currency = 0;
        try{
        currency = cclient.sendRequest(1, "USD");}
        catch (ParseException | DatatypeConfigurationException e) { e.printStackTrace();}
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        System.out.println(disks);
        Document doc = null;
        try {
            doc = db.parse(new InputSource(new StringReader(disks)));
            System.out.println(doc);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        Element dataTag = doc.getDocumentElement();
        for(int i=0;i<dataTag.getElementsByTagName("HD").getLength();i++){
            Element hdTag = (Element) dataTag.getElementsByTagName("HD").item(i);
            Element PriceEUR = doc.createElement("PriceEUR");
            Element CapMB = doc.createElement("CapMB");
            double temppr = Double.valueOf(hdTag.getElementsByTagName("Price").item(0).getTextContent())*currency;
            PriceEUR.setTextContent(String.valueOf(temppr));
            hdTag.appendChild(PriceEUR);
            double tempcap = Double.valueOf(hdTag.getElementsByTagName("Capacity").item(0).getTextContent())*gbtomb;
            CapMB.setTextContent(String.valueOf(tempcap));
            hdTag.appendChild(CapMB);
        }
        DOMImplementationLS domImplementation = (DOMImplementationLS) doc.getImplementation();
        LSSerializer lsSerializer = domImplementation.createLSSerializer();
        String result = lsSerializer.writeToString(doc);
        PrintWriter out = response.getWriter();
        out.println(result);
        System.out.println(1);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
