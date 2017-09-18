package fi.jyu.webapp.servlets;

import fi.jyu.soapservice.src.models.DiskModel;
import fi.jyu.webapp.StorageResponseParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@WebServlet("/order")

public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        PrintWriter outWriter = response.getWriter();

        String diskIdString = request.getParameter("diskId");
        String customerName = request.getParameter("customerName");
        String customerEmail = request.getParameter("customerEmail");

        //String OutPut = "Custumer Id is " + String.valueOf(diskIdString)+ '\n' + "Custumer Number is " + customerName + '\n' + "Custumer Email is " + customerEmail +'\n' ;
        //System.out.println(OutPut);

        Integer diskId = null;
        if(diskIdString == null || customerName == null || customerEmail == null){
            outWriter.println("<Result>Provide diskId, customerName, customerEmail please</Result>");
            return;
        }
        else{
            try {
                diskId = Integer.valueOf(diskIdString);
            }
            catch (Exception e){
                outWriter.println("<Result>id should be integer</Result>");
                return;
            }
        }

        try {
            List<DiskModel> data = StorageResponseParser.getStorageData();
            for (DiskModel diskModel : data) {
                if (diskModel.getId().equals(diskId)) {
                    String decision = "<diskId>" + diskId + "</diskId><customerName>" + customerName + "</customerName><customerEmail>" + customerEmail + "</customerEmail>";
                    outWriter.write("<result>"+decision+"</decision>");
                    return;
                }
            }
            String decision = "Disk" + diskId + " not found";
            outWriter.write("<result>"+decision+"</decision>");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
