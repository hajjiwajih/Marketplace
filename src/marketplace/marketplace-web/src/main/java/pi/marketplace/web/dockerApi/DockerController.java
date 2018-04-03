package pi.marketplace.web.dockerApi;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;

@Path("/BuildClient")
public class DockerController {
	
	@PUT
    @Path("/Connect")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	 public DockerClient initDocker() {
	        return DockerClientBuilder.getInstance("tcp://localhost:13306").build();
	    }

}
