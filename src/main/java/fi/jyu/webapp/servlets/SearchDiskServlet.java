package fi.jyu.webapp.servlets;

import fi.jyu.soapservice.src.models.Constants;
import fi.jyu.webapp.Processing;
import fi.jyu.webapp.clients.CurrencyConvertorClient;
import fi.jyu.webapp.clients.StorageClient;
import fi.jyu.webapp.clients.UnitConvertorClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.ParseException;

@WebServlet("/getDiskById")
public class SearchDiskServlet extends HttpServlet {

    private Processing processing = new Processing();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if(processing.getDiskByID(request.getParameter("id")).equals("<NewDataSet>"+ Constants.NO_INFORMATION+"</NewDataSet>")) {
            response.setStatus(404);
        }
        else{
            processing.getCurrency();
            processing.getGBtoMB();
            out.println(processing.processXML());
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
