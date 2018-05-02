package domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Localimage
 *
 */
@Entity(name="IMAGES")
@NamedQueries({
    @NamedQuery(name="allImages", query="SELECT i FROM IMAGES i"),
    @NamedQuery(name="ImageFindByname", query="SELECT i FROM IMAGES i WHERE i.name = :X")
    //@NamedQuery(name="getXEmail", query="SELECT u FROM Offers u WHERE u.Offers = :email")
})

@XmlRootElement(name="localimage")
public class Localimage implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private int id;
	
	@NotNull
	@Size(min=3, max=20)
	private String name;
	
	@NotNull
	@Size(min=5, max=240)
	private String description;

	
	@NotNull
	private Date creation ;
	
	private static final long serialVersionUID = 1L;

	
	
	public Localimage() {
		super();
		  this.creation = new Date();

	}   
	
	public Localimage(int id, String name, String description) {
		super();
		 Date date = new Date();

		this.id = id;
		this.name = name;
		this.description = description;
		this.creation = new Date();
	}
	public int getId() {
		return this.id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
   


	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

}
