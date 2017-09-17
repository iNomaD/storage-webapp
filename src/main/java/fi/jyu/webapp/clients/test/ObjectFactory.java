
package fi.jyu.webapp.clients.test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDiskbyId_QNAME = new QName("http://test", "getDiskbyId");
    private final static QName _GetDiskbyIdResponse_QNAME = new QName("http://test", "getDiskbyIdResponse");
    private final static QName _GetDisksResponse_QNAME = new QName("http://test", "getDisksResponse");
    private final static QName _GetDisks_QNAME = new QName("http://test", "getDisks");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDisks }
     * 
     */
    public GetDisks createGetDisks() {
        return new GetDisks();
    }

    /**
     * Create an instance of {@link GetDiskbyId }
     * 
     */
    public GetDiskbyId createGetDiskbyId() {
        return new GetDiskbyId();
    }

    /**
     * Create an instance of {@link GetDiskbyIdResponse }
     * 
     */
    public GetDiskbyIdResponse createGetDiskbyIdResponse() {
        return new GetDiskbyIdResponse();
    }

    /**
     * Create an instance of {@link GetDisksResponse }
     * 
     */
    public GetDisksResponse createGetDisksResponse() {
        return new GetDisksResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiskbyId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test", name = "getDiskbyId")
    public JAXBElement<GetDiskbyId> createGetDiskbyId(GetDiskbyId value) {
        return new JAXBElement<GetDiskbyId>(_GetDiskbyId_QNAME, GetDiskbyId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiskbyIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test", name = "getDiskbyIdResponse")
    public JAXBElement<GetDiskbyIdResponse> createGetDiskbyIdResponse(GetDiskbyIdResponse value) {
        return new JAXBElement<GetDiskbyIdResponse>(_GetDiskbyIdResponse_QNAME, GetDiskbyIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDisksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test", name = "getDisksResponse")
    public JAXBElement<GetDisksResponse> createGetDisksResponse(GetDisksResponse value) {
        return new JAXBElement<GetDisksResponse>(_GetDisksResponse_QNAME, GetDisksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDisks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test", name = "getDisks")
    public JAXBElement<GetDisks> createGetDisks(GetDisks value) {
        return new JAXBElement<GetDisks>(_GetDisks_QNAME, GetDisks.class, null, value);
    }

}
