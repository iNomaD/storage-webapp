package fi.jyu.webapp.servlets;

import fi.jyu.soapservice.src.models.Constants;
import fi.jyu.soapservice.src.models.DiskModel;
import fi.jyu.webapp.Processing;
import fi.jyu.webapp.RequestProcessor;
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
import java.util.List;

@WebServlet("/getDiskById")
public class SearchDiskServlet extends HttpServlet {

    private Processing processing = new Processing();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idParameter = request.getParameter("id");
        Integer id = null;
        if(idParameter == null){
            response.sendError(403);
            out.println("<Result>Provide id please</Result>");
        }
        else{
            try {
                id = Integer.valueOf(idParameter);
            }
            catch (Exception e){
                response.sendError(403);
                out.println("<Result>id should be integer</Result>");
            }
        }

        String price = request.getParameter("price");
        String capacity = request.getParameter("capacity");

        List<DiskModel> data = RequestProcessor.getStorageData();
        DiskModel resultDisk = null;

        for(DiskModel disk : data){
            if(disk.getId() == id){
                resultDisk = disk;
            }
        }

        if(resultDisk == null){
            out.println("<Result>Disk"+id+" not found</Result>");
        }
        else{
            if(price != null && price.equalsIgnoreCase(Constants.priceEUR)){
                CurrencyConvertorClient cclient = new CurrencyConvertorClient();
                try {
                    double eur = cclient.sendRequest(resultDisk.getPrice(), Constants.priceUSD);
                    resultDisk.setPrice((int)eur);
                    resultDisk.setPriceUnits(Constants.priceEUR);
                }
                catch (ParseException | DatatypeConfigurationException e) {
                    e.printStackTrace();
                }
            }
            if(capacity != null && capacity.equalsIgnoreCase(Constants.capacityMB)){
                UnitConvertorClient uclient = new UnitConvertorClient();
                double mb = uclient.sendRequest(resultDisk.getCapacity(), resultDisk.getCapacityUnits(), Constants.capacityMB);
                resultDisk.setCapacity((int)mb);
                resultDisk.setCapacityUnits(Constants.capacityMB);
            }

            String result = "<Result>"+resultDisk.toXML()+"</Result>";
            out.println(result);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
