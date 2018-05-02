package com.Marketplace.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import domain.Localimage;
import services.LocalimageManagment;

@ManagedBean
@SessionScoped
public class LocalimagesManagmentBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	FacesContext context = FacesContext.getCurrentInstance();

	@EJB
	LocalimageManagment  LIM ;
	
	public LocalimagesManagmentBean() {
		// TODO Auto-generated constructor stub
	}
	
    @Size(min = 3, message = "Name should at least be 3 characters long")
	private String iname ;
    
    @Size(min = 6, message = "it's a very short description")
	private String idescription ;
    
    @NotNull
	private  Localimage image;
	
	private List<Localimage> Images= new ArrayList<Localimage>() ;
	
	private int imageID = 0;

	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIdescription() {
		return idescription;
	}
	public void setIdescription(String idescription) {
		this.idescription = idescription;
	}
	public Localimage getImage() {
		return image;
	}
	public void setImage(Localimage image) {
		this.image = image;
	}
	public List<Localimage> getImages() {
		return Images;
	}
	public void setImages(List<Localimage> images) {
		Images = images;
	}
	
	public int getImageID() {
		return imageID;
	}
	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public void addImage() {
		LIM.saveImage(new Localimage(imageID, iname, idescription));
		iname = null;
		idescription = null;
		}

	public String EditImage(Localimage image){
		this.setIname(image.getName());
		this.setIdescription(image.getDescription());
		return "Updateoffer.xhtml?faces-redirect=true";
		}
	
	public List<Localimage> showlist(){
		Images = LIM.getAllImagess();
		for(Localimage c:Images)
		{
			System.out.println(c.getName());
		}
		return Images ;	
				 }
	
	public void UpdateImage(){
		
		try{
			LIM.updateImage(new Localimage(imageID,iname,idescription));
		}
		catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage("CreateNewImage:btn",new FacesMessage("invalidate inputé") );
		}
		 }
	
	public void DeleteImage(Localimage image){
		LIM.deleteImage(image);
				 }

	public List<Localimage> findbynmae(){
		Images = LIM.getImagesByName(iname);
		return Images ;	
				 }
}
