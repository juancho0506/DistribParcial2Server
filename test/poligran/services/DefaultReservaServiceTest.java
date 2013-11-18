/**
 * 
 */
package poligran.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Rodrigo
 *
 */
public class DefaultReservaServiceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {		
		Properties properties = new Properties();
        properties.setProperty("openejb.embedded.remotable", "true");
        //properties.setProperty("httpejbd.print", "true");
        //properties.setProperty("httpejbd.indent.xml", "true");
        EJBContainer.createEJBContainer(properties);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link poligran.services.DefaultReservaService#solicitarReservaPelicula(int)}.
	 */
	@Test
	public final void testSolicitarReservaPelicula() {
		
		Service service;
		try {
			service = Service.create(
			        new URL("http://localhost:8080/DistribParcial2Server/webservices/DefaultReservaService?wsdl"),
			        new QName("http://superbiz.org/wsdl", "ReservaService"));
			
			assertNotNull(service);

	        ReservaService reservaS = service.getPort(ReservaService.class);
	        boolean res = reservaS.solicitarReservaPelicula(1);
	        System.out.println("Puede reserva? : " + res);
		}
		catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

}
