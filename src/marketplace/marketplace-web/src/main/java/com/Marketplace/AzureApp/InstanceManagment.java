package com.Marketplace.AzureApp;
import java.io.File;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

import org.primefaces.util.Constants.RequestParams;

import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.compute.AvailabilitySet;
import com.microsoft.azure.management.compute.AvailabilitySetSkuTypes;
import com.microsoft.azure.management.compute.VirtualMachine;
import com.microsoft.azure.management.network.Network;
import com.microsoft.azure.management.network.NetworkInterface;
import com.microsoft.azure.management.network.PublicIPAddress;
import com.microsoft.azure.management.resources.ResourceGroup;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.rest.LogLevel;


@ManagedBean
@SessionScoped
public class InstanceManagment {
	
	//public void CreateVirtuelMachine(@FormParam("Username") String username , @FormParam("Password") String password  ,@FormParam("VMN") String machineName) 
	public void CreateVirtuelMachine() 

	{
		
		
		try {    
	    final File credFile = new File(System.getenv("AZURE_AUTH_LOCATION"));
	    Azure azure = Azure.configure()
	        .withLogLevel(LogLevel.BASIC)
	        .authenticate(credFile)
	        .withDefaultSubscription();
	    //System.out.println("Creating resource group...");
		ResourceGroup resourceGroup = azure.resourceGroups()
		    .define("myResourceGroup")
		    .withRegion(Region.US_EAST)
		    .create();
		AvailabilitySet availabilitySet = azure.availabilitySets()
			    .define("myAvailabilitySet")
			    .withRegion(Region.US_EAST)
			    .withExistingResourceGroup("myResourceGroup")
			    .withSku(AvailabilitySetSkuTypes.MANAGED)
			    .create();
		//System.out.println("Creating public IP address...");
		PublicIPAddress publicIPAddress = azure.publicIPAddresses()
		    .define("myPublicIP")
		    .withRegion(Region.US_EAST)
		    .withExistingResourceGroup("myResourceGroup")
		    .withDynamicIP()
		    .create();
		//System.out.println("Creating virtual network...");
		Network network = azure.networks()
		    .define("myVN")
		    .withRegion(Region.US_EAST)
		    .withExistingResourceGroup("myResourceGroup")
		    .withAddressSpace("10.0.0.0/16")
		    .withSubnet("mySubnet","10.0.0.0/24")
		    .create();
		//System.out.println("Creating network interface...");
		NetworkInterface networkInterface = azure.networkInterfaces()
		    .define("myNIC")
		    .withRegion(Region.US_EAST)
		    .withExistingResourceGroup("myResourceGroup")
		    .withExistingPrimaryNetwork(network)
		    .withSubnet("mySubnet")
		    .withPrimaryPrivateIPAddressDynamic()
		    .withExistingPrimaryPublicIPAddress(publicIPAddress)
		    .create();
		//System.out.println("Creating virtual machine...");
		VirtualMachine virtualMachine = azure.virtualMachines()
		    .define("myVM")
		    .withRegion(Region.US_EAST)
		    .withExistingResourceGroup("myResourceGroup")
		    .withExistingPrimaryNetworkInterface(networkInterface)
		    .withLatestWindowsImage("MicrosoftWindowsServer", "WindowsServer", "2012-R2-Datacenter")
		    .withAdminUsername("username")
		    .withAdminPassword("password")
		    .withComputerName("MyVM")
		    .withExistingAvailabilitySet(availabilitySet)
		    .withSize("Standard_DS1")
		    .create();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
		
	}	
		}
		
	public void StopVirtualMachine() {
		try {    
		    final File credFile = new File(System.getenv("AZURE_AUTH_LOCATION"));
		    Azure azure = Azure.configure()
		        .withLogLevel(LogLevel.BASIC)
		        .authenticate(credFile)
		        .withDefaultSubscription();
		    
			VirtualMachine vm = azure.virtualMachines().getByResourceGroup("myResourceGroup", "myVM");
			//System.out.println("Stopping vm...");
			vm.powerOff();				
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		    e.printStackTrace();
		}
	}

	
	public void StartVirtualMachine(){
		try {    
		    final File credFile = new File(System.getenv("AZURE_AUTH_LOCATION"));
		    Azure azure = Azure.configure()
		        .withLogLevel(LogLevel.BASIC)
		        .authenticate(credFile)
		        .withDefaultSubscription();
		    
			VirtualMachine vm = azure.virtualMachines().getByResourceGroup("myResourceGroup", "myVM");
			//System.out.println("Starting vm...");
			vm.start();			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		    e.printStackTrace();
		}
		
	}

	
}
