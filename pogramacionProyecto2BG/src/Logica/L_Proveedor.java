package Logica;

public class L_Proveedor {

	private String numeroProv;
	private String nombre;
	private String telefono;
	private String calle;
	private String puerta;
	private String localidad;
	private String email;
	
	
	
	public L_Proveedor(String numeroProv, String nombre, String email,String calle, String puerta, String localidad) {
	
		this.numeroProv = numeroProv;
		this.nombre = nombre;
		
		this.calle = calle;
		this.puerta = puerta;
		this.localidad = localidad;
		this.email = email;
	}
	
	


	public L_Proveedor(String numeroProv) {
		super();
		this.numeroProv = numeroProv;
	}




	public String getNumeroProv() {
		return numeroProv;
	}



	public void setNumeroProv(String numeroProv) {
		this.numeroProv = numeroProv;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public String getPuerta() {
		return puerta;
	}



	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}



	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean numeroProveedorVacio(String numeroProv) {
		
		
		
		if(numeroProv.length() == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
