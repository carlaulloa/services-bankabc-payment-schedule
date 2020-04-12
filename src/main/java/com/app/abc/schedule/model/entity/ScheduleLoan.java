package com.app.abc.schedule.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cronograma_prestamos")
public class ScheduleLoan implements Serializable {

	private static final long serialVersionUID = -9038567798776835741L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nro_prestamo")
	private int nroPrestamo;
	
	@Column(name = "cuota")
	private int cuota;
	
	@Column(name = "fecha_vencimiento")
	private String fechaVencimiento;
	
	@Column(name = "dias")
	private int dias;
	
	@Column(name = "capital")
	private double capital;
	
	@Column(name = "interes")
	private double interes;
	
	@Column(name = "importe_cuota")
	private double importeCuota;
	
	@Column(name = "pagado")
	private boolean pagado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNroPrestamo() {
		return nroPrestamo;
	}

	public void setNroPrestamo(int nroPrestamo) {
		this.nroPrestamo = nroPrestamo;
	}

	public int getCuota() {
		return cuota;
	}

	public void setCuota(int cuota) {
		this.cuota = cuota;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getImporteCuota() {
		return importeCuota;
	}

	public void setImporteCuota(double importeCuota) {
		this.importeCuota = importeCuota;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	
}
