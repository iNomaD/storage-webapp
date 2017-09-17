
package fi.jyu.webapp.clients.gamasystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCurrentExchangeRatesXMLResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCurrentExchangeRatesXMLResult"
})
@XmlRootElement(name = "GetCurrentExchangeRatesXMLResponse")
public class GetCurrentExchangeRatesXMLResponse {

    @XmlElement(name = "GetCurrentExchangeRatesXMLResult")
    protected String getCurrentExchangeRatesXMLResult;

    /**
     * Gets the value of the getCurrentExchangeRatesXMLResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCurrentExchangeRatesXMLResult() {
        return getCurrentExchangeRatesXMLResult;
    }

    /**
     * Sets the value of the getCurrentExchangeRatesXMLResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCurrentExchangeRatesXMLResult(String value) {
        this.getCurrentExchangeRatesXMLResult = value;
    }

}
