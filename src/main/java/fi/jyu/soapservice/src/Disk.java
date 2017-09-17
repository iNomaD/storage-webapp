
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@WebService(targetNamespace = "http://test")
public class Disk {
  private String csvFile = "../../../../resources/database.csv";
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

        result = result + ("<HD><ID>" + hd[0] + "</ID><Vendor>" + hd[1] + "</Vendor><Type>" + hd[2] + "</Type><Capacity" + hd[3] + "</Capacity><Rpm>" + hd[4] + "</Rpm><Price>" + hd[5] +  "</Price></HD>");

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
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
    result = result + "</NewDataSet>";
    return result;
  }

  @WebMethod
  public String getDiskbyId(String id){
    BufferedReader br = null;
    String line = "";
    String result = "<NewDataSet>";
    try {

      br = new BufferedReader(new FileReader(csvFile));
      while ((line = br.readLine()) != null) {

        // use comma as separator
        String[] hd = line.split(cvsSplitBy);
        if(hd[0] == id) {
          result = result + ("<HD><ID>" + hd[0] + "</ID><Vendor>" + hd[1] + "</Vendor><Type>" + hd[2] + "</Type><Capacity" + hd[3] + "</Capacity><Rpm>" + hd[4] + "</Rpm><Price>" + hd[5] + "</Price></HD>");
          break;
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
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
    result = result + "</NewDataSet>";
    return result;
  }

  public static void main(String[] args) {
    Object implementor = new Disk ();
    String address = "http://localhost:9000/";
    Endpoint.publish(address, implementor);
  }
}