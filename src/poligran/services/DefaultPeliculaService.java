/**
 * 
 */
package poligran.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import poligran.jpa.dao.DefaultPeliculaDAO;
import poligran.jpa.dao.PeliculaDAO;
import poligran.jpa.entities.Pelicula;

/**
 * @author Rodrigo
 *
 */
@Stateless
@WebService(
        portName = "PeliculaServicePort",
        serviceName = "PeliculaService",
        targetNamespace = "http://superbiz.org/wsdl",
        endpointInterface = "poligran.services.PeliculaService")
public class DefaultPeliculaService implements PeliculaService {
	

	private PeliculaDAO peliculaDao;
	
	public DefaultPeliculaService(){
		peliculaDao = new DefaultPeliculaDAO();
	}
	
	/* (non-Javadoc)
	 * @see poligran.services.PeliculaService#listarPeliculas()
	 */
	@Override
	public List<Pelicula> listarPeliculas() {
		return peliculaDao.loadAll();
	}

	@Override
	public boolean regisrarPelicula(String nombre, String genero, String idioma) {
		System.out.println("***");
		Pelicula p = new Pelicula();
		p.setNombre(nombre);
		p.setGenero(genero);
		p.setIdioma(idioma);
		
		try {
			peliculaDao.registrarPelicula(p);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
