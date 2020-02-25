
package org.acme.soap_service.interfaces.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkServiceHealthResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkServiceHealthResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkServiceHealthOut" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkServiceHealthResponseType", propOrder = {
    "checkServiceHealthOut"
})
public class CheckServiceHealthResponseType {

    @XmlElement(required = true)
    protected String checkServiceHealthOut;

    /**
     * Gets the value of the checkServiceHealthOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckServiceHealthOut() {
        return checkServiceHealthOut;
    }

    /**
     * Sets the value of the checkServiceHealthOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckServiceHealthOut(String value) {
        this.checkServiceHealthOut = value;
    }

}
