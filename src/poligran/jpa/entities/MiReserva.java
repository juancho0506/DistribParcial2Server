/**
 * 
 */
package poligran.jpa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * @author Rodrigo
 *
 */
@Entity
@Table(name="mi_reserva")
@NamedQueries({
	@NamedQuery(name="mireserva.loadAll", query="SELECT r FROM MiReserva r"),
	@NamedQuery(name="mireserva.getPeliculaReserva", query="SELECT r FROM MiReserva r WHERE r.pelicula =:pelicula")
})
public class MiReserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6596255942975618685L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="cod_reserva")
	private Integer id;
	
	@Column
	private Date fecha;
	
	@Column
	private Integer valor;
	
	@Version
	int version;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_peli", referencedColumnName="cod_peli")
	private Pelicula pelicula;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
