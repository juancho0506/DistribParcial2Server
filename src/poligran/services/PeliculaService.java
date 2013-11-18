/**
 * 
 */
package poligran.services;

import java.util.List;

import javax.jws.WebService;

import poligran.jpa.entities.Pelicula;

/**
 * @author Rodrigo
 *
 */
@WebService(targetNamespace = "http://superbiz.org/wsdl")
public interface PeliculaService {
	public List<Pelicula> listarPeliculas();
	
	public boolean regisrarPelicula(String nombre, String genero, String idioma);
}
