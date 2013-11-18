/**
 * 
 */
package poligran.jpa.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.apache.openjpa.persistence.jdbc.Unique;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;



/**
 * @author Rodrigo
 *
 */
@Entity
@NamedQueries(
	@NamedQuery(name="pelicula.loadAll", query="SELECT p FROM Pelicula p")
)
public class Pelicula implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="cod_peli")
	private Integer codPeli;
	
	@Version int version;
	
	@Column
	@Unique
	@Basic(optional=false)
	private String nombre;
	
	@Column
	private String genero;
	
	@Column
	private String idioma;
	@Column
	private String estado = "DISPONIBLE";
	
	

	public Integer getCodPeli() {
		return codPeli;
	}

	public void setCodPeli(Integer codPeli) {
		this.codPeli = codPeli;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
