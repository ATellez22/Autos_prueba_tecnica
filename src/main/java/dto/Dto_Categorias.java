package dto;

public class Dto_Categorias {
	
	private Integer id;
	private String descripcion;
	
	public Dto_Categorias() {
		super();
	}
		
	@Override
	public String toString() {
		return "{id=" + id + ", descripcion=" + descripcion + "}";//EN FORMATO JSON PARA USARLO EN COMBO ANIDADO
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
}
