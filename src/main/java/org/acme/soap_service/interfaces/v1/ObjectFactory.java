
package org.acme.soap_service.interfaces.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.acme.soap_service.interfaces.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckServiceHealthResponse_QNAME = new QName("http://acme.org/soap-service/interfaces/V1", "checkServiceHealthResponse");
    private final static QName _CheckServiceHealthRequest_QNAME = new QName("http://acme.org/soap-service/interfaces/V1", "checkServiceHealthRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.acme.soap_service.interfaces.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckServiceHealthRequestType }
     * 
     */
    public CheckServiceHealthRequestType createCheckServiceHealthRequestType() {
        return new CheckServiceHealthRequestType();
    }

    /**
     * Create an instance of {@link CheckServiceHealthResponseType }
     * 
     */
    public CheckServiceHealthResponseType createCheckServiceHealthResponseType() {
        return new CheckServiceHealthResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckServiceHealthResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.org/soap-service/interfaces/V1", name = "checkServiceHealthResponse")
    public JAXBElement<CheckServiceHealthResponseType> createCheckServiceHealthResponse(CheckServiceHealthResponseType value) {
        return new JAXBElement<CheckServiceHealthResponseType>(_CheckServiceHealthResponse_QNAME, CheckServiceHealthResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckServiceHealthRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://acme.org/soap-service/interfaces/V1", name = "checkServiceHealthRequest")
    public JAXBElement<CheckServiceHealthRequestType> createCheckServiceHealthRequest(CheckServiceHealthRequestType value) {
        return new JAXBElement<CheckServiceHealthRequestType>(_CheckServiceHealthRequest_QNAME, CheckServiceHealthRequestType.class, null, value);
    }

}
