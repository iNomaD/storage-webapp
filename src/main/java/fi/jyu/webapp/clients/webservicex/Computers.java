
package fi.jyu.webapp.clients.webservicex;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Computers.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Computers">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bit"/>
 *     &lt;enumeration value="Byte"/>
 *     &lt;enumeration value="Kilobyte"/>
 *     &lt;enumeration value="Megabyte"/>
 *     &lt;enumeration value="Gigabyte"/>
 *     &lt;enumeration value="Terabyte"/>
 *     &lt;enumeration value="Petabyte"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Computers")
@XmlEnum
public enum Computers {

    @XmlEnumValue("Bit")
    BIT("Bit"),
    @XmlEnumValue("Byte")
    BYTE("Byte"),
    @XmlEnumValue("Kilobyte")
    KILOBYTE("Kilobyte"),
    @XmlEnumValue("Megabyte")
    MEGABYTE("Megabyte"),
    @XmlEnumValue("Gigabyte")
    GIGABYTE("Gigabyte"),
    @XmlEnumValue("Terabyte")
    TERABYTE("Terabyte"),
    @XmlEnumValue("Petabyte")
    PETABYTE("Petabyte");
    private final String value;

    Computers(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Computers fromValue(String v) {
        for (Computers c: Computers.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
