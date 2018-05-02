package services;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.FormParam;

import domain.Localimage;

@Local
public interface LocalimageManagmentLocal {

	
	public List<Localimage> getAllImagess();
	public boolean saveImage(Localimage image);
	public boolean updateImage(Localimage image);
	public boolean deleteImage(Localimage image);
	public List<Localimage> getImagesByName(@FormParam("name") String X );
	Localimage findImageByName(String name);

	
	
}
