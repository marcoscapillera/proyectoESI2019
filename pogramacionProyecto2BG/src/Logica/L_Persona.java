package Logica;

public class L_Persona {
	
	protected String CI;
	protected  String nombre;
	protected String apellido_paterno;
	protected String apellido_materno;
	protected String calle;
	protected String localidad;
	protected String numero_puerta;
	protected String telefono;
	
	
	
	//contructor por defecto
	
	
	public L_Persona() {
		
	}
	//Contructor completo
	public L_Persona(String cI, String nombre, String apellido_paterno, String apellido_materno, String calle,
			String localidad, String numero_puerta, String telefono) {
		
		this.CI = cI;
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.calle = calle;
		this.localidad = localidad;
		this.numero_puerta = numero_puerta;
		this.telefono = telefono;
	}


//contructor con CI (clave primaria)
	public L_Persona(String CI) {
		
	}

// gett and set
	public String getCI() {
		return CI;
	}



	public void setCI(String cI) {
		CI = cI;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido_paterno() {
		return apellido_paterno;
	}



	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}



	public String getApellido_materno() {
		return apellido_materno;
	}



	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	public String getNumero_puerta() {
		return numero_puerta;
	}



	public void setNumero_puerta(String numero_puerta) {
		this.numero_puerta = numero_puerta;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public void mostrarDatos(String CI) {
	System.out.println("La cedula es :"+ CI);
    }
	
	public boolean nombreVacio(String nombre) {
		if(nombre.length() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean idVacio(String CI) {
		if(CI.length()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}


