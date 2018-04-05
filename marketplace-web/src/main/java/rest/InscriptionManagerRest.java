package rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inscriptionRequest(tmpuser tmpuser) {
		
		if (userManagmentLocal.registrationRequest(tmpuser))
			return Response.status(Status.ACCEPTED).entity("Request was sent correctrly").build();
		return Response.status(Status.BAD_REQUEST).entity("error try again please").build(); 
	}

	@GET
	@Path("{key}")
	public Response test(@PathParam(value="key") String keyString)
	{
		if (userManagmentLocal.RegistrationConfirmation(keyString)==true)
			return Response.status(Status.CREATED).entity("congratulation").build();
		return Response.status(Status.BAD_REQUEST).entity("Please try again").build();
		
	}

}
