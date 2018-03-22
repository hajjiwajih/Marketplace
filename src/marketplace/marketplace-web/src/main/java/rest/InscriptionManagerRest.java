package rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import domain.tmpuser;
import services.UserManagmentLocal;

@Path("inscription")
@javax.enterprise.context.RequestScoped
public class InscriptionManagerRest {
	@EJB
	UserManagmentLocal userManagmentLocal;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inscriptionRequest(tmpuser tmpuser) {
		if (userManagmentLocal.registrationRequest(tmpuser))
			return Response.status(Status.ACCEPTED).entity(tmpuser).build();
		return Response.status(Status.BAD_REQUEST).entity("error try again please").build(); 
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response test()

	{
		tmpuser c1 = new tmpuser();
		c1.setEmail("wajih.haji@gmail.com");
		c1.setPassword("qsdsdqsd");
		return Response.status(Status.ACCEPTED).entity(c1).build();

	}

}
