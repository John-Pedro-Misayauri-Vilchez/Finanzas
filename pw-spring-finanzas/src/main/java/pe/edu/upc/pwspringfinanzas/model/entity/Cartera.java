package pe.edu.upc.pwspringfinanzas.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cartera")
public class Cartera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartera_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "tipo_descuento_id", nullable = false)
	private TipoDescuento tipodescuento;

	@ManyToOne
	@JoinColumn(name = "tipo_tasa_id", nullable = false)
	private TipoTasa tipotasa;

	@ManyToOne
	@JoinColumn(name = "tipo_moneda_id", nullable = false)
	private TipoMoneda tipomoneda;

	@ManyToOne
	@JoinColumn(name = "plazo_tasa_id", nullable = false)
	private PlazoTasa plazotasa;

	@Column(name = "cartera_cod_factura", length = 5)
	private String codFactura;

	@Column(name = "cartera_valor_nominal")
	private Float valorNominal;

	@Column(name = "cartera_plazo_dias")
	private Integer plazoDias;

	@Column(name = "cartera_retencion")
	private Float retencion;

	@Column(name = "cartera_valor_tasa")
	private Float valorTasa;

	@Column(name = "cartera_periodo_capt")
	private Integer periodoCapt;

	@Column(name = "cartera_fecha_desc")
	private Date fechaDesc;

	@Column(name = "cartera_costo_inicial_total")
	private Float costoInicialTotal;

	@Column(name = "cartera_costo_final_total")
	private Float costoFinalTotal;

	@Column(name = "cartera_valor_neto")
	private Float valorNeto;

	@Column(name = "cartera_valor_recibido")
	private Float valorRecibido;

	@Column(name = "cartera_valor_entregado")
	private Float valorEntregado;

	@Column(name = "cartera_tcea")
	private Float TCEA;

	public Cartera() {
		super();
	}

	public Cartera(Integer id, Cliente cliente, TipoDescuento tipodescuento, TipoTasa tipotasa, TipoMoneda tipomoneda,
			PlazoTasa plazotasa, String codFactura, Float valorNominal, Integer plazoDias, Float retencion,
			Float valorTasa, Integer periodoCapt, Date fechaDesc, Float costoInicialTotal, Float costoFinalTotal,
			Float valorNeto, Float valorRecibido, Float valorEntregado, Float tCEA) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.tipodescuento = tipodescuento;
		this.tipotasa = tipotasa;
		this.tipomoneda = tipomoneda;
		this.plazotasa = plazotasa;
		this.codFactura = codFactura;
		this.valorNominal = valorNominal;
		this.plazoDias = plazoDias;
		this.retencion = retencion;
		this.valorTasa = valorTasa;
		this.periodoCapt = periodoCapt;
		this.fechaDesc = fechaDesc;
		this.costoInicialTotal = costoInicialTotal;
		this.costoFinalTotal = costoFinalTotal;
		this.valorNeto = valorNeto;
		this.valorRecibido = valorRecibido;
		this.valorEntregado = valorEntregado;
		TCEA = tCEA;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoDescuento getTipodescuento() {
		return tipodescuento;
	}

	public void setTipodescuento(TipoDescuento tipodescuento) {
		this.tipodescuento = tipodescuento;
	}

	public TipoTasa getTipotasa() {
		return tipotasa;
	}

	public void setTipotasa(TipoTasa tipotasa) {
		this.tipotasa = tipotasa;
	}

	public TipoMoneda getTipomoneda() {
		return tipomoneda;
	}

	public void setTipomoneda(TipoMoneda tipomoneda) {
		this.tipomoneda = tipomoneda;
	}

	public PlazoTasa getPlazotasa() {
		return plazotasa;
	}

	public void setPlazotasa(PlazoTasa plazotasa) {
		this.plazotasa = plazotasa;
	}

	public String getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	public Float getValorNominal() {
		return valorNominal;
	}

	public void setValorNominal(Float valorNominal) {
		this.valorNominal = valorNominal;
	}

	public Integer getPlazoDias() {
		return plazoDias;
	}

	public void setPlazoDias(Integer plazoDias) {
		this.plazoDias = plazoDias;
	}

	public Float getRetencion() {
		return retencion;
	}

	public void setRetencion(Float retencion) {
		this.retencion = retencion;
	}

	public Float getValorTasa() {
		return valorTasa;
	}

	public void setValorTasa(Float valorTasa) {
		this.valorTasa = valorTasa;
	}

	public Integer getPeriodoCapt() {
		return periodoCapt;
	}

	public void setPeriodoCapt(Integer periodoCapt) {
		this.periodoCapt = periodoCapt;
	}

	public Date getFechaDesc() {
		return fechaDesc;
	}

	public void setFechaDesc(Date fechaDesc) {
		this.fechaDesc = fechaDesc;
	}

	public Float getCostoInicialTotal() {
		return costoInicialTotal;
	}

	public void setCostoInicialTotal(Float costoInicialTotal) {
		this.costoInicialTotal = costoInicialTotal;
	}

	public Float getCostoFinalTotal() {
		return costoFinalTotal;
	}

	public void setCostoFinalTotal(Float costoFinalTotal) {
		this.costoFinalTotal = costoFinalTotal;
	}

	public Float getValorNeto() {
		return valorNeto;
	}

	public void setValorNeto(Float valorNeto) {
		this.valorNeto = valorNeto;
	}

	public Float getValorRecibido() {
		return valorRecibido;
	}

	public void setValorRecibido(Float valorRecibido) {
		this.valorRecibido = valorRecibido;
	}

	public Float getValorEntregado() {
		return valorEntregado;
	}

	public void setValorEntregado(Float valorEntregado) {
		this.valorEntregado = valorEntregado;
	}

	public Float getTCEA() {
		return TCEA;
	}

	public void setTCEA(Float tCEA) {
		TCEA = tCEA;
	}

}
