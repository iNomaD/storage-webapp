
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
 *         &lt;element name="strCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strDateLow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strDateHigh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "strBank",
    "strCurrency",
    "strDateLow",
    "strDateHigh"
})
@XmlRootElement(name = "GetExchangeRatesByDateXML")
public class GetExchangeRatesByDateXML {

    protected String strBank;
    protected String strCurrency;
    protected String strDateLow;
    protected String strDateHigh;

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

    /**
     * Gets the value of the strCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCurrency() {
        return strCurrency;
    }

    /**
     * Sets the value of the strCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCurrency(String value) {
        this.strCurrency = value;
    }

    /**
     * Gets the value of the strDateLow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrDateLow() {
        return strDateLow;
    }

    /**
     * Sets the value of the strDateLow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrDateLow(String value) {
        this.strDateLow = value;
    }

    /**
     * Gets the value of the strDateHigh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrDateHigh() {
        return strDateHigh;
    }

    /**
     * Sets the value of the strDateHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrDateHigh(String value) {
        this.strDateHigh = value;
    }

}
