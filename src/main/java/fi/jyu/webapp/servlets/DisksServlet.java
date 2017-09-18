package fi.jyu.webapp.servlets;

import fi.jyu.soapservice.src.models.Constants;
import fi.jyu.soapservice.src.models.DiskModel;
import fi.jyu.webapp.Processing;
import fi.jyu.webapp.RequestProcessor;
import fi.jyu.webapp.clients.CurrencyConvertorClient;
import fi.jyu.webapp.clients.UnitConvertorClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

@WebServlet("/Disks")
public class DisksServlet extends HttpServlet {

    private Processing processing = new Processing();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String price = request.getParameter("price");
        String capacity = request.getParameter("capacity");

        List<DiskModel> data = RequestProcessor.getStorageData();
        for(DiskModel disk : data){
            if(price != null && price.equalsIgnoreCase(Constants.priceEUR)){
                CurrencyConvertorClient cclient = new CurrencyConvertorClient();
                try {
                    double eur = cclient.sendRequest(disk.getPrice(), Constants.priceUSD);
                    disk.setPrice((int)eur);
                    disk.setPriceUnits(Constants.priceEUR);
                }
                catch (ParseException | DatatypeConfigurationException e) {
                    e.printStackTrace();
                }
            }
            if(capacity != null && capacity.equalsIgnoreCase(Constants.capacityMB)){
                UnitConvertorClient uclient = new UnitConvertorClient();
                double mb = uclient.sendRequest(disk.getCapacity(), disk.getCapacityUnits(), Constants.capacityMB);
                disk.setCapacity((int)mb);
                disk.setCapacityUnits(Constants.capacityMB);
            }
        }

        String result = "<Result>";
        for(DiskModel disk : data){
            result += disk.toXML();
        }
        result = result + "</Result>";
        PrintWriter out = response.getWriter();
        out.println(result);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
