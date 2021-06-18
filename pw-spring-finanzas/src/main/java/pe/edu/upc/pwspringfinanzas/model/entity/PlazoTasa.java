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
@Table(name = "Plazo_Tasa")
public class PlazoTasa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plazo_tasa_id")
	private Integer id;

	@Column(name = "plazo_tasa_descripcion", length = 12)
	private String descripcion;

	@Column(name = "plazo_tasa_valor_dias")
	private Integer valorDias;

	@OneToMany(mappedBy = "plazotasa", fetch = FetchType.LAZY)
	private List<Cartera> carteras;

	public PlazoTasa() {
		super();
	}

	public PlazoTasa(Integer id, String descripcion, Integer valorDias, List<Cartera> carteras) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.valorDias = valorDias;
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

	public Integer getValorDias() {
		return valorDias;
	}

	public void setValorDias(Integer valorDias) {
		this.valorDias = valorDias;
	}

	public List<Cartera> getCarteras() {
		return carteras;
	}

	public void setCarteras(List<Cartera> carteras) {
		this.carteras = carteras;
	}

}
