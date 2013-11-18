/**
 * 
 */
package poligran.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import poligran.jpa.entities.Pelicula;

/**
 * @author Rodrigo
 *
 */
public class DefaultPeliculaDAO implements PeliculaDAO {
	
	private static final String PERSISTENCE_UNIT_NAME = "DistribParcial2EM";
	private EntityManagerFactory entityFactory;
	
	private EntityManager em;
	
	public DefaultPeliculaDAO(){
    	entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityFactory.createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT);
		em.getEntityManagerFactory().getCache().evictAll();
    }

	/* (non-Javadoc)
	 * @see poligran.jpa.dao.PeliculaDAO#loadAll()
	 */

	@Override
	public List<Pelicula> loadAll() {
		
		return em.createNamedQuery("pelicula.loadAll", Pelicula.class).getResultList();
	}

	/* (non-Javadoc)
	 * @see poligran.jpa.dao.PeliculaDAO#getPelicula(int)
	 */
	@Override
	public Pelicula getPelicula(int id) {
		return em.find(Pelicula.class, id);
	}
	
	

	@Override
	public void actualizarPelicula(Pelicula p) throws PersistenceException {
		em.getTransaction().begin();
		em.merge(p);
		em.flush();
		em.getTransaction().commit();
	}

	@Override
	public void registrarPelicula(Pelicula p) {
		em.getTransaction().begin();
		em.persist(p);
		em.flush();
		em.getTransaction().commit();
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
