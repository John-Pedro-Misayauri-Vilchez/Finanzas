package pe.edu.upc.pwspringfinanzas.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Integer id;

	@Column(name = "cliente_razon_social", length = 100)
	private String razonSocial;

	@Column(name = "cliente_nombre", length = 50)
	private String nombre;

	@Column(name = "cliente_apellido_paterno", length = 15)
	private String apellidoPaterno;

	@Column(name = "cliente_apellido_materno", length = 15)
	private String apellidoMaterno;

	@Column(name = "cliente_nro_documento", length = 20)
	private String nroDocumento;

	@Column(name = "cliente_contraseña", length = 20)
	private String contraseña;

	@ManyToOne
	@JoinColumn(name = "Tipo_Persona_id", nullable = false)
	private TipoPersona tipopersona;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Cartera> carteras;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String razonSocial, String nombre, String apellidoPaterno, String apellidoMaterno,
			String nroDocumento, String contraseña, TipoPersona tipopersona, List<Cartera> carteras) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nroDocumento = nroDocumento;
		this.contraseña = contraseña;
		this.tipopersona = tipopersona;
		this.carteras = carteras;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public TipoPersona getTipopersona() {
		return tipopersona;
	}

	public void setTipopersona(TipoPersona tipopersona) {
		this.tipopersona = tipopersona;
	}

	public List<Cartera> getCarteras() {
		return carteras;
	}

	public void setCarteras(List<Cartera> carteras) {
		this.carteras = carteras;
	}

}
