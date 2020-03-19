package Logica;

public class L_Insumos {
	
	private int ins_Codigo;
	private String ins_Nombre="";
	private String ins_Tipo;
	private String ins_Soft;
	private int ins_Cantidad=0;
	private float ins_Precio=0.0f;
	private String ins_Desc="";

	
	
	public L_Insumos() {
		
	}
	
	//CONSTRUCTOR COMPLETO
	public L_Insumos(int ins_Codigo, String ins_Nombre, String ins_Tipo, String ins_Soft, int ins_Cantidad,String ins_Desc,
			float ins_Precio) {
		super();
		this.ins_Codigo = ins_Codigo;
		this.ins_Nombre = ins_Nombre;
		this.ins_Tipo = ins_Tipo;
		this.ins_Soft = ins_Soft;
		this.ins_Cantidad = ins_Cantidad;
		this.ins_Precio = ins_Precio;
		this.ins_Desc = ins_Desc;
	}
	



	//Constructor sin tipo y software
	public L_Insumos(int ins_Codigo, String ins_Nombre, int ins_Cantidad,String ins_Desc, float ins_Precio) {
		super();
		this.ins_Codigo = ins_Codigo;
		this.ins_Nombre = ins_Nombre;
		this.ins_Cantidad = ins_Cantidad;
		this.ins_Precio = ins_Precio;
		this.ins_Desc = ins_Desc;
	}


	//Constructor solo con Codigo de Insumo y Nombre
	public L_Insumos(int ins_Codigo, String ins_Nombre) {
		this.ins_Codigo = ins_Codigo;
		this.ins_Nombre=ins_Nombre;
	}

	
	//Constructor solo con Codigo de Insumo
	public L_Insumos(int ins_Codigo) {
		this.ins_Codigo = ins_Codigo;
		
	}


	public int getIns_Codigo() {
		return ins_Codigo;
	}




	public void setIns_Codigo(int ins_Codigo) {
		this.ins_Codigo = ins_Codigo;
	}




	public String getIns_Nombre() {
		return ins_Nombre;
	}




	public void setIns_Nombre(String ins_Nombre) {
		this.ins_Nombre = ins_Nombre;
	}




	public String getIns_Tipo() {
		return ins_Tipo;
	}




	public void setIns_Tipo(String ins_Tipo) {
		this.ins_Tipo = ins_Tipo;
	}




	public String getIns_Soft() {
		return ins_Soft;
	}




	public void setIns_Soft(String ins_Soft) {
		this.ins_Soft = ins_Soft;
	}




	public int getIns_Cantidad() {
		return ins_Cantidad;
	}




	public void setIns_Cantidad(int ins_Cantidad) {
		this.ins_Cantidad = ins_Cantidad;
	}




	public float getIns_Precio() {
		return ins_Precio;
	}




	public void setIns_Precio(float ins_Precio) {
		this.ins_Precio = ins_Precio;
	}




	public String getIns_Desc() {
		return ins_Desc;
	}




	public void setIns_Desc(String ins_Desc) {
		this.ins_Desc = ins_Desc;
	}
	
	//Metodos si nombre y codigos estan vacios
	public boolean nombreVacio(String ins_Nombre) {
		
		if(ins_Nombre.length() == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean idVacio(int ins_Codigo) {
		
		
		if(ins_Codigo == 0) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean isNumero(String cadena){
		
		
		try{
			
			int Codigo = Integer.parseInt(cadena);
			System.out.println("es numero");
			return true;
			}catch(Exception e1){
			System.out.println("No es numero");
			return true;
			}
		
		
	}

}
