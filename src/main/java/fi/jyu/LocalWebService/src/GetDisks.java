
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@WebService(targetNamespace = "http://test")
public class GetDisks {
  @WebMethod
  public String getDisks() {
    String csvFile = "../../../../resources/database.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    String result = "<NewDataSet>";
    try {

      br = new BufferedReader(new FileReader(csvFile));
      while ((line = br.readLine()) != null) {

        // use comma as separator
        String[] hd = line.split(cvsSplitBy);

        result = result + ("<HD><Vendor>" + hd[0] + "</Vendor><Capacity>" + hd[1] + "</Capacity></HD>");

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
  public static void main(String[] argv) {
    Object implementor = new GetDisks ();
    String address = "http://localhost:9000/GetDisks";
    Endpoint.publish(address, implementor);
  }

}
