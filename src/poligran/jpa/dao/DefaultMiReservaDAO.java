/**
 * 
 */
package poligran.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import poligran.jpa.entities.MiReserva;
import poligran.jpa.entities.Pelicula;

/**
 * @author Rodrigo
 *
 */
public class DefaultMiReservaDAO implements MiReservaDAO {
	
	 private static final String PERSISTENCE_UNIT_NAME = "DistribParcial2EM";
	 private EntityManagerFactory entityFactory;

    private EntityManager em;
    
    public DefaultMiReservaDAO(){
    	entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityFactory.createEntityManager();
		em.getEntityManagerFactory().getCache().evictAll();
    }

	/* (non-Javadoc)
	 * @see poligran.jpa.dao.MiReservaDAO#loadAll()
	 */
	@Override
	public List<MiReserva> loadAll() throws PersistenceException {
		return em.createNamedQuery("mireserva.loadAll").getResultList();
	}

	/* (non-Javadoc)
	 * @see poligran.jpa.dao.MiReservaDAO#getMiReserva(int)
	 */
	@Override
	public MiReserva getMiReserva(int id) throws PersistenceException {
		return em.find(MiReserva.class, id);
	}

	@Override
	public MiReserva getPeliculaReserva(Pelicula p) throws PersistenceException {
		Query q = em.createNamedQuery("mireserva.getPeliculaReserva");
		q.setParameter("pelicula", p);
		return (MiReserva) q.getSingleResult();
	}

	/* (non-Javadoc)
	 * @see poligran.jpa.dao.MiReservaDAO#reservar(poligran.jpa.entities.MiReserva)
	 */
	@Override
	public void reservar(MiReserva r) throws PersistenceException {
		em.getTransaction().begin();
		em.persist(r);
		em.flush();
		em.getTransaction().commit();
		em.refresh(r);
	}

	@Override
	public void cancelarReserva(MiReserva r) throws PersistenceException {
		em.getTransaction().begin();
		em.remove(r);
		em.flush();
		em.getTransaction().commit();
		em.refresh(r);
		
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
