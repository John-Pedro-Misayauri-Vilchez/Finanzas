package pe.edu.upc.pwspringfinanzas.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tipo_Descuento")
public class TipoDescuento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_descuento_id")
	private Integer id;

	@Column(name = "tipo_descuento_descripcion", length = 7)
	private String descripcion;

	@OneToMany(mappedBy = "tipodescuento", fetch = FetchType.LAZY)
	private List<Cartera> carteras;

	public TipoDescuento() {
		super();
	}
	
	public TipoDescuento(Integer id, String descripcion, List<Cartera> carteras) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.carteras = carteras;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cartera> getCarteras() {
		return carteras;
	}

	public void setCarteras(List<Cartera> carteras) {
		this.carteras = carteras;
	}
	
	
}
