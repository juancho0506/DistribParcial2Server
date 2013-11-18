/**
 * 
 */
package poligran.services;

import java.util.List;

import javax.jws.WebService;

import poligran.jpa.entities.MiReserva;

/**
 * @author Rodrigo
 *
 */
@WebService(targetNamespace = "http://superbiz.org/wsdl")
public interface ReservaService {

	public boolean solicitarReservaPelicula(int codPelicula) throws Exception;
	
	public void reservarPelicula(int codPelicula) throws Exception;
	
	public boolean verificarReserva(int codPelicula) throws Exception;
	
	public List<MiReserva> listarReservas() throws Exception;
	
	public void cancelarReserva(int codReserva)throws Exception;
}
