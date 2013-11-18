/**
 * 
 */
package poligran.jpa.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import poligran.jpa.entities.Pelicula;

/**
 * @author Rodrigo
 *
 */
public interface PeliculaDAO {
	
	public List<Pelicula> loadAll()throws PersistenceException;
	
	public Pelicula getPelicula(int id)throws PersistenceException;
	
	public void registrarPelicula(Pelicula p) throws PersistenceException;
	
	public void actualizarPelicula(Pelicula p) throws PersistenceException;
}
