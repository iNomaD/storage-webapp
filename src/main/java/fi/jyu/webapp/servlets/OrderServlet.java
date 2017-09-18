package fi.jyu.webapp.servlets;

import fi.jyu.webapp.Processing;
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

@WebServlet("/Order")

public class OrderServlet extends HttpServlet {
    private Processing processing = new Processing();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("This is Get!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        System.out.println("doPost");
        PrintWriter OutResponse = response.getWriter();

        try {
            int DiskId = Integer.parseInt(request.getParameter("diskId").toString());
            String CustumerNumber = request.getParameter("customerNumber").toString();
            String CustomerEmail = request.getParameter("customerEmail").toString();

            String OutPut = "Custumer Id is " + String.valueOf(DiskId)+ '\n' + "Custumer Number is " + CustumerNumber + '\n' + "Custumer Email is " + CustomerEmail +'\n' ;
            System.out.println(OutPut);

            String output = XMLBuilder("Pass");


            System.out.println(output);
            OutResponse.write(output);

            //System.out.println(doc.toString());

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            try {
                OutResponse.write(XMLBuilder("Fill all parameters"));
            } catch (ParserConfigurationException e1) {
                e1.printStackTrace();
            } catch (TransformerException e1) {
                e1.printStackTrace();
            }
        }



    }

    private String XMLBuilder(String Desition) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.newDocument();
        Element RootElement = doc.createElement("AnswerForm");
        doc.appendChild(RootElement);

        Element Answer = doc.createElement("Answer");
        RootElement.appendChild(Answer);

        Answer.appendChild(doc.createTextNode(Desition));

        TransformerFactory tf = TransformerFactory.newInstance();

        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        return writer.getBuffer().toString().replaceAll("\n|\r", "");
    }

}
