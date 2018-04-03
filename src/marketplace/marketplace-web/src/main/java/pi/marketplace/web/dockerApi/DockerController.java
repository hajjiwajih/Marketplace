package pi.marketplace.web.dockerApi;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;

public class DockerController {
	
	 public DockerClient initDocker() {
	        return DockerClientBuilder.getInstance("tcp://localhost:13306").build();
	    }

}
