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
@Table(name = "Tipo_Persona")
public class TipoPersona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_persona_id")
	private Integer id;

	@Column(name = "tipo_persona_descripcion", length = 9)
	private String descripcion;

	@OneToMany(mappedBy = "tipopersona", fetch = FetchType.LAZY)
	private List<Cliente> clientes;

	public TipoPersona() {
		super();
	}

	public TipoPersona(Integer id, String descripcion, List<Cliente> clientes) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.clientes = clientes;
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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
