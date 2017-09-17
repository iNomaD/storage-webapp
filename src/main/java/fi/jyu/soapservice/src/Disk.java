package fi.jyu.soapservice.src;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@WebService(targetNamespace = "http://test")
public class Disk {
  private String csvFile = "src/main/resources/database.csv";
  private String cvsSplitBy = ",";

  @WebMethod
  public String getDisks() {
    BufferedReader br = null;
    String line;
    String result = "<NewDataSet>";
    try {

      br = new BufferedReader(new FileReader(csvFile));
      while ((line = br.readLine()) != null) {

        // use comma as separator
        String[] hd = line.split(cvsSplitBy);

        result = result + ("<HD><ID>" + hd[0] + "</ID><Vendor>" + hd[1] + "</Vendor><Type>" + hd[2] + "</Type><Capacity>" + hd[3] + "</Capacity><Rpm>" + hd[4] + "</Rpm><Price>" + hd[5] +  "</Price></HD>");

      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    if (result.equals("<NewDataSet>")){
      return "<NewDataSet> No Information </NewDataSet>";
    }
    else{
    result = result + "</NewDataSet>";
    return result;}
  }

  @WebMethod
  public String getDiskbyId(String id){
    BufferedReader br = null;
    String line;
    String result = "<NewDataSet>";
    try {

      br = new BufferedReader(new FileReader(csvFile));
      while ((line = br.readLine()) != null) {

        // use comma as separator
        String[] hd = line.split(cvsSplitBy);

        if(Integer.parseInt(hd[0]) == Integer.parseInt(id)) {
          result = result + ("<HD><ID>" + hd[0] + "</ID><Vendor>" + hd[1] + "</Vendor><Type>" + hd[2] + "</Type><Capacity>" + hd[3] + "</Capacity><Rpm>" + hd[4] + "</Rpm><Price>" + hd[5] + "</Price></HD>");
          break;
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    if (result.equals("<NewDataSet>")){
      return "<NewDataSet> No Information </NewDataSet>";
    }
    else{
      result = result + "</NewDataSet>";
      return result;}
  }


  public static void main(String[] args) {
    Object implementor = new Disk ();
    String address = "http://localhost:9000/";
    Endpoint.publish(address, implementor);
    System.out.println("Launched!");

  }
}
