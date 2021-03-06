
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
 *         &lt;element name="dcmValue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="strBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "dcmValue",
    "strBank",
    "strCurrency",
    "intRank"
})
@XmlRootElement(name = "CurrentConvertToEUR")
public class CurrentConvertToEUR {

    @XmlElement(required = true)
    protected BigDecimal dcmValue;
    protected String strBank;
    protected String strCurrency;
    protected int intRank;

    /**
     * Gets the value of the dcmValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDcmValue() {
        return dcmValue;
    }

    /**
     * Sets the value of the dcmValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDcmValue(BigDecimal value) {
        this.dcmValue = value;
    }

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
