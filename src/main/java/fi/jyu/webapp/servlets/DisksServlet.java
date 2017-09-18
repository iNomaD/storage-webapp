package fi.jyu.webapp.servlets;

import fi.jyu.soapservice.src.models.DiskModel;
import fi.jyu.webapp.Processing;
import fi.jyu.webapp.RequestProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Disks")
public class DisksServlet extends HttpServlet {

    private Processing processing = new Processing();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String price = request.getParameter("price");
        String capacity = request.getParameter("capacity");

        List<DiskModel> data = RequestProcessor.getStorageData();
        for(DiskModel disk : data){
            System.out.println(disk);
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
