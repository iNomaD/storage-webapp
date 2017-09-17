
package fi.jyu.webapp.clients.gamasystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="strBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "strBank"
})
@XmlRootElement(name = "GetCurrentExchangeRatesXML")
public class GetCurrentExchangeRatesXML {

    protected String strBank;

    /**
     * Gets the value of the strBank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrBank() {
        return strBank;
    }

    /**
     * Sets the value of the strBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrBank(String value) {
        this.strBank = value;
    }

}
