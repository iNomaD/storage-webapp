package fi.jyu.webapp;

import fi.jyu.webapp.servlets.SearchDiskServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class RunServlets {
    public static void main(String[] args) throws Exception{
        ServletHandler handler = new ServletHandler();

        //add all servlet to use to the handler, the second argument is the path (e.g. http://localhost:8080/searchPublication)
        handler.addServletWithMapping(SearchDiskServlet.class, "/getDisks");
        handler.addServletWithMapping(SearchDiskServlet.class, "/getDiskById");


        //Create a new Server, add the handler to it and start
        Server server = new Server(8080);
        server.setHandler(handler);
        server.start();

        //this dumps a lot of debug output to the console.
        server.dumpStdErr();
        server.join();
    }
}
