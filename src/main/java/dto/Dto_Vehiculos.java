package dto;

public class Dto_Vehiculos {
	
	private Long id;
	private String marca, modelo, cambio, potencia, combustible;
	private Integer anio, plazas, cilindrada, velocidad_maxima, precio;
	
	
	@Override
	public String toString() {
		return "Dto_Vehiculos [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", cambio=" + cambio
				+ ", potencia=" + potencia + ", combustible=" + combustible + ", año=" + anio + ", plazas=" + plazas
				+ ", cilindrada=" + cilindrada + ", velocidad_maxima=" + velocidad_maxima + ", precio=" + precio + "]";
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getCambio() {
		return cambio;
	}
	
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	
	public String getPotencia() {
		return potencia;
	}
	
	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
	
	public String getCombustible() {
		return combustible;
	}
	
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	
	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getPlazas() {
		return plazas;
	}
	
	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}
	
	public Integer getCilindrada() {
		return cilindrada;
	}
	
	public void setCilindrada(Integer cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public Integer getVelocidad_maxima() {
		return velocidad_maxima;
	}
	
	public void setVelocidad_maxima(Integer velocidad_maxima) {
		this.velocidad_maxima = velocidad_maxima;
	}
	
	public Integer getPrecio() {
		return precio;
	}
	
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
}
