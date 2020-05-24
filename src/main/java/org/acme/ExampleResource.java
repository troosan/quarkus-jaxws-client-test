package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.acme.soap_service.interfaces.v1.CheckServiceHealthRequestType;
import org.acme.soap_service.interfaces.v1.CheckServiceHealthResponseType;
import org.acme.soap_service.v1.MySoapService;
import org.acme.soap_service.v1.MySoapService_Service;

import eu.europa.ec.taxud.vies.services.checkvat.CheckVatPortType;
import eu.europa.ec.taxud.vies.services.checkvat.CheckVatService;

@Path("/")
public class ExampleResource {

	private static final String WSDL_ENDPOINT_LOCAL = "http://localhost:8088/MySoapService?wsdl";
	private static final String WSDL_ENDPOINT_VIES = "http://ec.europa.eu/taxation_customs/vies/services/checkVatService";

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/hello")
	public String hello() {
		MySoapService service = new MySoapService_Service().getMySoapServicePort();

		BindingProvider bindingProvider = (BindingProvider) service;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_ENDPOINT_LOCAL);

		CheckServiceHealthRequestType request = new CheckServiceHealthRequestType();
		CheckServiceHealthResponseType response = service.checkServiceHealth(request);
		return response.getCheckServiceHealthOut();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/vat/{countryCode}/{vatNumber}")
	public Response check(@PathParam("countryCode") String country, @PathParam("vatNumber") String vat) {
		CheckVatPortType service = new CheckVatService().getCheckVatPort();

		BindingProvider bindingProvider = (BindingProvider) service;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_ENDPOINT_VIES);

		Holder<XMLGregorianCalendar> requestDate = new Holder<>();
		Holder<Boolean> valid = new Holder<>();
		Holder<String> name = new Holder<>();
		Holder<String> address = new Holder<>();
		Holder<String> countryCode = new Holder<>(country);
		Holder<String> vatNumber = new Holder<String>(vat);
		service.checkVat(countryCode, vatNumber, requestDate, valid, name, address);

		return Response.ok(new VatCheckResponse(valid.value, countryCode.value, vatNumber.value, name.value)).build();
	}

	public class VatCheckResponse {
		public boolean valid;
		public String countryCode;
		public String vat;
		public String name;
		
		public VatCheckResponse(boolean valid, String countryCode, String vat, String name) {
			this.valid = valid;
			this.countryCode = countryCode;
			this.vat = vat;
			this.name = name;
		}
	}
}