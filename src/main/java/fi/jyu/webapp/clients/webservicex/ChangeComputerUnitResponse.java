
package fi.jyu.webapp.clients.webservicex;

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
 *         &lt;element name="ChangeComputerUnitResult" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "changeComputerUnitResult"
})
@XmlRootElement(name = "ChangeComputerUnitResponse")
public class ChangeComputerUnitResponse {

    @XmlElement(name = "ChangeComputerUnitResult")
    protected double changeComputerUnitResult;

    /**
     * Gets the value of the changeComputerUnitResult property.
     * 
     */
    public double getChangeComputerUnitResult() {
        return changeComputerUnitResult;
    }

    /**
     * Sets the value of the changeComputerUnitResult property.
     * 
     */
    public void setChangeComputerUnitResult(double value) {
        this.changeComputerUnitResult = value;
    }

}
