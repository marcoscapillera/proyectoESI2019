package Logica;

import java.sql.Date;

public class L_Solicitar {
	
	int nServicio;
	String cICliente;
	String fechaInicio;
	String FechaFin;
	String fechaPresu;
	int cantHoras;
	String estado;
	float presupuesto;
	String causa;
	String tipoServicio;
	
	//Metodo Constructor completo
	public L_Solicitar(int nServicio, String cICliente, String fechaInicio, String fechaFin, String fechaPresu, int cantHoras,
			String estado, String causa, float presupuesto) {
		super();
		this.nServicio = nServicio;
		this.cICliente = cICliente;
		this.fechaInicio = fechaInicio;
		this.FechaFin = fechaFin;
		this.fechaPresu = fechaPresu;
		this.cantHoras = cantHoras;
		this.estado = estado;
		this.presupuesto = presupuesto;
		this.causa = causa;
	}
	
	//Metodo Constructor solo con clave
	public L_Solicitar(int nServicio) {
		super();
		this.nServicio = nServicio;
	}
	
	//Metodo Constructor solo con clave
	public L_Solicitar(String tipoServicio) {
		super();
		this.tipoServicio = tipoServicio;
	}
	
	
	//Metodo Constructor vacio
	public L_Solicitar() {
		super();
		
	}
	
	
	

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public int getnServicio() {
		return nServicio;
	}


	public void setnServicio(int nServicio) {
		this.nServicio = nServicio;
	}


	public String getcICliente() {
		return cICliente;
	}


	public void setcICliente(String cICliente) {
		this.cICliente = cICliente;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return FechaFin;
	}


	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}


	public String getFechaPresu() {
		return fechaPresu;
	}


	public void setFechaPresu(String fechaPresu) {
		this.fechaPresu = fechaPresu;
	}


	public int getCantHoras() {
		return cantHoras;
	}


	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public float getPresupuesto() {
		return presupuesto;
	}


	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}


	public String getCausa() {
		return causa;
	}


	public void setCausa(String causa) {
		this.causa = causa;
	}

	public boolean nServicioVacio(int nServicio) {
		
		if(nServicio == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	public boolean cedulaVacio(String cedula) {
		
		int entero= Integer.parseInt(cedula);
		if(entero == 0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean ciClienteVacio(String CI) {
		
		
		int entero= Integer.parseInt(CI);
		if(entero == 0) {
			return true;
		}else {
			return false;
		}
		
	}


}
