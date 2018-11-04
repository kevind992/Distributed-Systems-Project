package ie.gmit.sw.RESTfulWebService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/createbooking.jsp")
public class MyController {

	@GET
	@Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
}
