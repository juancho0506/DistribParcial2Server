/**
 * 
 */
package poligran.jpa.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import poligran.jpa.entities.MiReserva;
import poligran.jpa.entities.Pelicula;

/**
 * @author Rodrigo
 *
 */
public interface MiReservaDAO {
public List<MiReserva> loadAll()throws PersistenceException;
	
	public MiReserva getMiReserva(int id)throws PersistenceException;
	
	public MiReserva getPeliculaReserva(Pelicula p)throws PersistenceException;
	
	public void reservar(MiReserva r) throws PersistenceException;
	
	public void cancelarReserva(MiReserva r) throws PersistenceException;
}
