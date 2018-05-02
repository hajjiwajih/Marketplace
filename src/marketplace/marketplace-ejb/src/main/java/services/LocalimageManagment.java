package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.FormParam;

import domain.Localimage;

/**
 * 
 */
@Stateless
@LocalBean
public class LocalimageManagment implements LocalimageManagmentLocal {

	
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public LocalimageManagment() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Localimage> getAllImagess() {
		TypedQuery<Localimage> liste = em.createNamedQuery("allImages", Localimage.class);
        return liste.getResultList();		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean saveImage(Localimage image) {
		em.persist(image);
		return true;
	}

	@Override
	public boolean updateImage(Localimage image) {
		em.merge(image);
		return true;
	}

	@Override
	public boolean deleteImage(Localimage image) {
		em.remove(em.merge(image));
		return true;
	}

	@Override
	public List<Localimage> getImagesByName(@FormParam("name")String X) {
		TypedQuery<Localimage> liste = em.createNamedQuery("ImageFindByname", Localimage.class);
        return liste.getResultList();	
	}
    
	public Localimage findebyId(int id){
		Localimage limage=null;
		try {
			limage=em.find(Localimage.class ,id)  ;   //find(Stops.class, id);
		
		} catch (Exception e) {
			
		}
		return limage;
	
		
	}
	
	@Override
	public Localimage findImageByName(String name) {
		
		Localimage limage=null;

		try {
			Query query=em.createQuery("select u from User u where u.userName=:l");	
		query.setParameter("l", name);
		limage=(Localimage) query.getSingleResult();
		} catch (Exception e) {
			limage=null;
		}
		return limage;
	}
    

}
