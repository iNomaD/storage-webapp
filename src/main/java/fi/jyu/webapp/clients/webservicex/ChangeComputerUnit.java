
package fi.jyu.webapp.clients.webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="ComputerValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fromComputerUnit" type="{http://www.webserviceX.NET/}Computers"/>
 *         &lt;element name="toComputerUnit" type="{http://www.webserviceX.NET/}Computers"/>
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
    "computerValue",
    "fromComputerUnit",
    "toComputerUnit"
})
@XmlRootElement(name = "ChangeComputerUnit")
public class ChangeComputerUnit {

    @XmlElement(name = "ComputerValue")
    protected double computerValue;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Computers fromComputerUnit;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Computers toComputerUnit;

    /**
     * Gets the value of the computerValue property.
     * 
     */
    public double getComputerValue() {
        return computerValue;
    }

    /**
     * Sets the value of the computerValue property.
     * 
     */
    public void setComputerValue(double value) {
        this.computerValue = value;
    }

    /**
     * Gets the value of the fromComputerUnit property.
     * 
     * @return
     *     possible object is
     *     {@link Computers }
     *     
     */
    public Computers getFromComputerUnit() {
        return fromComputerUnit;
    }

    /**
     * Sets the value of the fromComputerUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Computers }
     *     
     */
    public void setFromComputerUnit(Computers value) {
        this.fromComputerUnit = value;
    }

    /**
     * Gets the value of the toComputerUnit property.
     * 
     * @return
     *     possible object is
     *     {@link Computers }
     *     
     */
    public Computers getToComputerUnit() {
        return toComputerUnit;
    }

    /**
     * Sets the value of the toComputerUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Computers }
     *     
     */
    public void setToComputerUnit(Computers value) {
        this.toComputerUnit = value;
    }

}
