package dto;

public class Dto_Detalle_Categoria {
	
	private Integer id_categoria, id_vehiculo;
	
	public Dto_Detalle_Categoria() {
		super();
	}

	@Override
	public String toString() {
		return "Dto_Detalle_Categoria [id_categoria=" + id_categoria + ", id_vehiculo=" + id_vehiculo + "]";
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public Integer getId_subcategoria() {
		return id_vehiculo;
	}

	public void setId_subcategoria(Integer id_subcategoria) {
		this.id_vehiculo = id_subcategoria;
	}
	
}
