/**
 * 
 */
package poligran.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import poligran.jpa.dao.DefaultMiReservaDAO;
import poligran.jpa.dao.DefaultPeliculaDAO;
import poligran.jpa.dao.MiReservaDAO;
import poligran.jpa.dao.PeliculaDAO;
import poligran.jpa.entities.MiReserva;
import poligran.jpa.entities.Pelicula;

/**
 * @author Rodrigo
 *
 */
@Stateless
@WebService(
        portName = "ReservaServicePort",
        serviceName = "ReservaService",
        targetNamespace = "http://superbiz.org/wsdl",
        endpointInterface = "poligran.services.ReservaService")
public class DefaultReservaService implements ReservaService {
	
	private MiReservaDAO reservaDAO;
	private PeliculaDAO peliculaDAO;

	/**
	 * 
	 */
	public DefaultReservaService() {
		reservaDAO = new DefaultMiReservaDAO();
		peliculaDAO = new DefaultPeliculaDAO();
	}

	/* (non-Javadoc)
	 * @see poligran.services.ReservaService#solicitarReservaPelicula(int)
	 */
	@Override
	public boolean solicitarReservaPelicula(int codPelicula) {
		
		return false;
	}

	@Override
	public void reservarPelicula(int codPelicula) throws Exception {
		boolean existeReserva = false;
		try {
			existeReserva = verificarReserva(codPelicula);
		} catch (javax.persistence.NoResultException e) {
			
		}
		if(existeReserva){
			throw new PeliculaReservadaException();
		}else{
			Pelicula p = peliculaDAO.getPelicula(codPelicula);
			p.setEstado("RESERVADA");
			peliculaDAO.actualizarPelicula(p);
			MiReserva r = new MiReserva();
			r.setPelicula(p);
			r.setFecha(new Date());
			r.setValor(10000);
			reservaDAO.reservar(r);
		}
		
	}

	@Override
	public boolean verificarReserva(int codPelicula) throws Exception {
		Pelicula p = peliculaDAO.getPelicula(codPelicula);
		if(p!=null){
			MiReserva r = reservaDAO.getPeliculaReserva(p);
			if(r!=null){
				return true;
			}else{
				return false;
			}
		}else{
			throw new Exception("Pelicula no encontrada exception.");
		}
	}

	@Override
	public List<MiReserva> listarReservas() throws Exception {
		return reservaDAO.loadAll();
	}

	@Override
	public void cancelarReserva(int codReserva)throws Exception {
		MiReserva r = reservaDAO.getMiReserva(codReserva);
		reservaDAO.cancelarReserva(r);
		Pelicula p = r.getPelicula();
		p.setEstado("DISPONIBLE");
		peliculaDAO.actualizarPelicula(p);
	}	
}
