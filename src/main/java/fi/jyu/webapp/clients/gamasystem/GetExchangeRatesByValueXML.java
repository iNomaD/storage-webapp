
package fi.jyu.webapp.clients.gamasystem;

import java.math.BigDecimal;
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
 *         &lt;element name="strBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dcmLow" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dcmHigh" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="intRank" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "dcmLow",
    "dcmHigh",
    "intRank"
})
@XmlRootElement(name = "GetExchangeRatesByValueXML")
public class GetExchangeRatesByValueXML {

    protected String strBank;
    protected String strCurrency;
    @XmlElement(required = true)
    protected BigDecimal dcmLow;
    @XmlElement(required = true)
    protected BigDecimal dcmHigh;
    protected int intRank;

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
     * Gets the value of the dcmLow property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDcmLow() {
        return dcmLow;
    }

    /**
     * Sets the value of the dcmLow property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDcmLow(BigDecimal value) {
        this.dcmLow = value;
    }

    /**
     * Gets the value of the dcmHigh property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDcmHigh() {
        return dcmHigh;
    }

    /**
     * Sets the value of the dcmHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDcmHigh(BigDecimal value) {
        this.dcmHigh = value;
    }

    /**
     * Gets the value of the intRank property.
     * 
     */
    public int getIntRank() {
        return intRank;
    }

    /**
     * Sets the value of the intRank property.
     * 
     */
    public void setIntRank(int value) {
        this.intRank = value;
    }

}
