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
import java.util.List;

@WebServlet("/Disks")
public class DisksServlet extends HttpServlet {

    private Processing processing = new Processing();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        processing.getDisks();;
        processing.getCurrency();
        processing.getGBtoMB();
        PrintWriter out = response.getWriter();
        out.println(processing.processXML());
        */

        List<DiskModel> data = RequestProcessor.getStorageData();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
