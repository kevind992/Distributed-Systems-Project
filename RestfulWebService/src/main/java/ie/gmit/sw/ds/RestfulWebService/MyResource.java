package ie.gmit.sw.ds.RestfulWebService;

import java.io.StringWriter;
import java.util.ArrayList;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Rentals;
import ie.gmit.sw.ds.rmi.rmiClient;

@Singleton
@Path("/createbooking")
public class MyResource {

	private ArrayList<Rentals> acc = new ArrayList<>();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{value}")
	public Response getOrder(@PathParam("value") String value) throws Exception {
        System.out.println("here..");
		acc = new rmiClient().getData();
		Rentals requested = null;
		
		String testValue = "1001";
		
		for (Rentals a : acc) {
			System.out.println(a);
			if (testValue.equals(value)) {
				requested = a;
			}
		}
		
		if (requested == null) {
			System.out.println("if");
			String msg = "The requested order does not exist";
			return Response.status(404).entity(msg).build();
		} else {
			System.out.println("else");
			String msg = getOrderAsXML(requested);
			return Response.status(200).entity(msg).build();
		}
    }
	
	private String getOrderAsXML(Rentals po) {
		// Marshal the PurchaseOrder into XML
		StringWriter sw = new StringWriter();
		Marshaller m;
		try {
			System.out.println("trying..");
			JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.ds.models");
			m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(po, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sw.toString());
		return sw.toString();
	}
}