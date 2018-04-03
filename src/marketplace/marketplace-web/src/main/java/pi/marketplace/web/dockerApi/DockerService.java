package pi.marketplace.web.dockerApi;

import java.util.ArrayList;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;

//@Path("/ServiceDocker")
public class DockerService {
	private static List<Container> containers= new ArrayList<Container>() ;
	private static List<Image> images =  new ArrayList<Image>() ;
	//private String CId;
	 public static List<Container> getContainers() {
		return containers;
	}

	public static void setContainers(List<Container> containers) {
		DockerService.containers = containers;
	}
	
	
	/*@GET
	@Path("/Containers")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })*/
	public static void getAllContainers(){

	        DockerController dockerController = new DockerController();
	        DockerClient client = dockerController.initDocker();
	        List<Container> containers  = client.listContainersCmd()
	                .withShowSize(true)
	                .withShowAll(true)
	                .withStatusFilter("exited").exec();
	        for (Container c : containers) {
	        	System.out.printf("==================================================================");
	            System.out.printf("ID :"+c.getId());
	            System.out.printf("NOM :"+c.getNames());
	            System.out.printf("Statut :"+c.getStatus());
	            System.out.printf("HostConfig :"+c.getHostConfig());
	            System.out.printf("NetworkSettings"+c.getNetworkSettings());
	            System.out.printf("Port"+c.getPorts());
	            System.out.printf("==================================================================");
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
	
	/*
	  @POST
	  @Path("/startContainer")
	  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })*/
	 public static void StartContainer(String Id)
	 {
		 DockerController dockerController = new DockerController();
	        DockerClient client = dockerController.initDocker();
	        for (Container c : containers) {
	        	if(c.getId()==Id)
	        	{
	        client.startContainerCmd(c.getId()).exec();
	            System.out.printf("Container with id:"+c.getId()+"has been started");
	        	}
	}	
	 }
	  /*
	  @POST
	  @Path("/stopContainer")
	  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })*/ 
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
	 /*
	 @POST
	 @Path("/removeContainer")
	 @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })*/
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
	 
	/*@GET
	@Path("/images")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })*/ 
	 public void listerImage()
		{
		 DockerController dockerController = new DockerController();
	        DockerClient client = dockerController.initDocker();
			List<Image> images = client.listImagesCmd().exec();
			 for (Image i : images) {
		            System.out.printf("id"+i.getId()+" temp de création :"+i.getCreated()+" size :"+i.getSize()+" tag:"
		            +i.getRepoTags());
		}}
	 
	 
	 

	public static List<Image> getImages() {
		return images;
	}

	public static void setImages(List<Image> images) {
		DockerService.images = images;
	}
	 
	 
	
	 

}
