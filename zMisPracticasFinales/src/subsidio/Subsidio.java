package subsidio;

import java.time.LocalDate;

public class Subsidio {
	private Double porcentajeDescuento;
	private String tipoSubsidio;
	private int duracionMeses;
	private LocalDate fechaInicio;
	private Integer identificador;
	private String nombreSubsidio;
	
	public Subsidio (Integer identificador, String nombreSubsidio, Double porcentajeDescuento, String tipoSubsidio) {
		this.fechaInicio=LocalDate.now();
		this.identificador=identificador;
		this.nombreSubsidio=nombreSubsidio;
		this.porcentajeDescuento=porcentajeDescuento;
		this.tipoSubsidio=tipoSubsidio;
	}
	
	
	public LocalDate fechaVencimiento () {
		LocalDate fechaVencimiento =this.fechaInicio.plusMonths(this.duracionMeses);
		return fechaVencimiento;
	}


	@Override
	public String toString() {
		return "Subsidio [porcentajeDescuento=" + porcentajeDescuento + ", tipoSubsidio=" + tipoSubsidio
				+ ", duracionMeses=" + duracionMeses + ", fechaInicio=" + fechaInicio + ", identificador="
				+ identificador + ", nombreSubsidio=" + nombreSubsidio + "]";
	}


	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}


	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}


	public String getTipoSubsidio() {
		return tipoSubsidio;
	}


	public void setTipoSubsidio(String tipoSubsidio) {
		this.tipoSubsidio = tipoSubsidio;
	}


	public int getDuracionMeses() {
		return duracionMeses;
	}


	public void setDuracionMeses(int duracionMeses) {
		this.duracionMeses = duracionMeses;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Integer getIdentificador() {
		return identificador;
	}


	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}


	public String getNombreSubsidio() {
		return nombreSubsidio;
	}


	public void setNombreSubsidio(String nombreSubsidio) {
		this.nombreSubsidio = nombreSubsidio;
	}
}
