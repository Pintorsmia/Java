package amazon.java;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ColisManager implements ColisManagerInter{
	@PersistenceContext
	private EntityManager em;
	
	public ColisManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Colis findColis(long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Colis createColis(float poids, float valeur, String origine, String destination) {
		// TODO Auto-generated method stub
		Colis c = new Colis();
		c.setColis(poids, valeur, origine, destination);
		em.persist(c);
		return c;
	}

	@Override
	public Colis setCoord(float latitude, float longitude, String emplacement, String etat) {
		// TODO Auto-generated method stub
		return null;
	}

}
