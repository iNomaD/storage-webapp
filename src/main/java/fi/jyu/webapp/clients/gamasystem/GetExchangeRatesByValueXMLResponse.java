
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
 *         &lt;element name="GetExchangeRatesByValueXMLResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getExchangeRatesByValueXMLResult"
})
@XmlRootElement(name = "GetExchangeRatesByValueXMLResponse")
public class GetExchangeRatesByValueXMLResponse {

    @XmlElement(name = "GetExchangeRatesByValueXMLResult")
    protected String getExchangeRatesByValueXMLResult;

    /**
     * Gets the value of the getExchangeRatesByValueXMLResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetExchangeRatesByValueXMLResult() {
        return getExchangeRatesByValueXMLResult;
    }

    /**
     * Sets the value of the getExchangeRatesByValueXMLResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetExchangeRatesByValueXMLResult(String value) {
        this.getExchangeRatesByValueXMLResult = value;
    }

}
