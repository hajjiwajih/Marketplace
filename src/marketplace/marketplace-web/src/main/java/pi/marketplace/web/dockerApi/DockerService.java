package pi.marketplace.web.dockerApi;

import java.util.ArrayList;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;

public class DockerService {
	private static List<Container> containers= new ArrayList<Container>() ;
	//private String CId;
	 public static List<Container> getContainers() {
		return containers;
	}

	public static void setContainers(List<Container> containers) {
		DockerService.containers = containers;
	}

	public static void getAllContainers(){

	        DockerController dockerController = new DockerController();
	        DockerClient client = dockerController.initDocker();
	        List<Container> containers  = client.listContainersCmd()
	                .withShowSize(true)
	                .withShowAll(true)
	                .withStatusFilter("exited").exec();
	        for (Container c : containers) {
	            System.out.printf("*****************"+c.getId()+"*************************");
	        }

	    }
	 
	/* public static void CreateContainer(){	       
		 CreateContainerResponse container
		  = client.createContainerCmd("mongo:3.6")
		    .withCmd("--bind_ip_all")
		    .withName("mongo")
		    .withHostName("baeldung")
		    .withEnv("MONGO_LATEST_VERSION=3.6")
		    .withPortBindings(PortBinding.parse("9999:27017"))
		    .withBinds(Bind.parse("/Users/baeldung/mongo/data/db:/data/db")).exec();

	 }*/
	 public static void StartContainer(String Id)
	 {
		 DockerController dockerController = new DockerController();
	        DockerClient client = dockerController.initDocker();
	        for (Container c : containers) {
	        	if(c.getId()==Id)
	        client.startContainerCmd(c.getId()).exec();
	            System.out.printf("Container with id:"+c.getId()+"has been started");

	}	
	 }
	 public static void StopContainer(String Id)
	 {
		 DockerController dockerController = new DockerController();
	        DockerClient client = dockerController.initDocker();
	        for (Container c : containers) {
	        	if (c.getId()==Id)
	        	{
	        	client.stopContainerCmd(c.getId()).exec();
	            System.out.printf("Container with id:"+c.getId()+"has been stoped");
	        	}
	        }
	}	
	 
	 public static void RemoveContainer(String Id)
	 {
		 DockerController dockerController = new DockerController();
	        DockerClient client = dockerController.initDocker();
	        for (Container c : containers) {
	        	if(c.getId()==Id)
	        	{		
	        client.killContainerCmd(c.getId()).exec();
            System.out.printf("Container with id:"+c.getId()+"has been removed");

	        	}
	}
	 }
	 
	/* public static void InspectContainer()
	 {
		 DockerController dockerController = new DockerController();
	        DockerClient client = dockerController.initDocker();
	        for (Container c : containers) {
	 InspectContainerResponse container 
	  = client.inspectContainerCmd(c.getId()).exec();
	        }
	 }*/
	 
	 
	 
	
	 

}
