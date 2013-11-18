package poligran.jpa.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poligran.jpa.entities.Pelicula;

public class DefaultPeliculaDAOTest {
	
	private DefaultPeliculaDAO dao = new DefaultPeliculaDAO();

	@Before
	public void setUp() throws Exception {
		// Open a database connection
        // (create a new database if it doesn't exist yet):
		try {
			EntityManagerFactory emf =
		            Persistence.createEntityManagerFactory("DistribParcial2EM");
		        dao.setEm(emf.createEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
        
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testLoadAll() {
		try {
			System.out.println("Peliculas: ");
			for (Pelicula elem : dao.loadAll()) {
				System.out.println("- "+elem.getNombre());
			}			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}

	@Test
	public final void testGetPelicula() {
		try {
			Pelicula p = dao.getPelicula(1);
			assertEquals("Titanic", p.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void testRegistrarPelicula(){
		Pelicula p = new Pelicula();
		p.setNombre("Armagedon");
		p.setGenero("Acción");
		p.setIdioma("Inglés");
		
		try {
			dao.registrarPelicula(p);
			this.testLoadAll();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
