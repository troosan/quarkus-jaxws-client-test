package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.BindingProvider;

import org.acme.soap_service.interfaces.v1.CheckServiceHealthRequestType;
import org.acme.soap_service.interfaces.v1.CheckServiceHealthResponseType;
import org.acme.soap_service.v1.MySoapService;
import org.acme.soap_service.v1.MySoapService_Service;

@Path("/hello")
public class ExampleResource {

	private static final String WSDL_ENDPOINT = "http://localhost:8088/MySoapService?wsdl";

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		MySoapService service = new MySoapService_Service().getMySoapServicePort();

		BindingProvider bindingProvider = (BindingProvider) service;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_ENDPOINT);

		CheckServiceHealthRequestType request = new CheckServiceHealthRequestType();
		CheckServiceHealthResponseType response = service.checkServiceHealth(request);
		return response.getCheckServiceHealthOut();
	}
}