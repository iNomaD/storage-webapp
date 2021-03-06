package fi.jyu.soapservice.src;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Disk {
  protected CSVReader reader = new CSVReader();;

  @WebMethod
  public String getDisks() {
    return reader.CSVProcess("-1");
  }

  @WebMethod
  public String getDiskbyId(String i){

    return reader.CSVProcess(i);
  }


  public static void main(String[] args) {
    Object implementor = new Disk ();
    Integer port = Integer.valueOf(System.getenv("PORT"));
    String address = "http://0.0.0.0:"+port+"/";
    System.out.println(address);
    Endpoint.publish(address, implementor);
    System.out.println("Launched!");

  }
}
