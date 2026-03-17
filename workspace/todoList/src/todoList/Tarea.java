package todoList;


public class Tarea {
	private String descripcion;
	private EstadoTarea estadoTarea;
	private TipoTarea tipoTarea;
	
	public Tarea(
			String descripcion, 
			EstadoTarea estadoTarea,
			TipoTarea tipoTarea) {
		super();
		this.descripcion = descripcion;
		this.estadoTarea = estadoTarea;
		this.tipoTarea = tipoTarea;
	}

	

	public String getDescripcion() {
		return descripcion;
	}

	public EstadoTarea getEstadoTarea() {
		return estadoTarea;
	}

	public TipoTarea getTipoTarea() {
		return tipoTarea;
	}


	@Override
	public String toString() {
		return String.format("%s - %s - %s", descripcion, estadoTarea.toString(), estadoTarea.toString());
	}
	
	
	
	
	
	

}
