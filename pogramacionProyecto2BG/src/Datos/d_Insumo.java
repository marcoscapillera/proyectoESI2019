package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class d_Insumo {
	private Connection cx; 
	private Statement stm;
	private int ins_Codigo;
	private String ins_Nombre="";
	private int ins_Cantidad=0;
	private float ins_Precio=0.0f;
	private String ins_Desc="";
	
	
	private String user="root";
	private String pwd=""; 
	private String host="jdbc:mysql://localhost/MantenimientoInformatico"; 
	

	

	
	
	
	// CONSTRUCTOR COMPLETO
	public d_Insumo(String host, String user, String pwd, int ins_Codigo, String ins_Nombre,
			int ins_Cantidad, String ins_Desc, float ins_Precio) {
		
		
		try {
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			this.cx = DriverManager.getConnection(host,user,pwd);
			this.stm = cx.createStatement();

			this.ins_Codigo = ins_Codigo;
			this.ins_Nombre = ins_Nombre;
			this.ins_Cantidad = ins_Cantidad;
			this.ins_Precio = ins_Precio;
			this.ins_Desc = ins_Desc;
			
		}catch(SQLException e){
			
			System.out.println(e.toString());
			
		}catch(ClassNotFoundException e){
			
			System.out.println(e.toString());
			
		}
	}
	
	public d_Insumo(String host, String user, String pwd, String ins_Nombre, int ins_Cantidad, String ins_Desc, float ins_Precio) {
		super();
		
		this.host=host;
		this.user=user;
		this.pwd=pwd;
		this.ins_Nombre = ins_Nombre;
		this.ins_Cantidad = ins_Cantidad;
		this.ins_Precio = ins_Precio;
		this.ins_Desc = ins_Desc;
	}

	
	
	public d_Insumo(int ins_Codigo, String ins_Nombre, int ins_Cantidad, String ins_Desc, float ins_Precio) {
		super();
		this.ins_Codigo = ins_Codigo;
		this.ins_Nombre = ins_Nombre;
		this.ins_Cantidad = ins_Cantidad;
		this.ins_Precio = ins_Precio;
		this.ins_Desc = ins_Desc;
	}

	
	//Constructor solo con Clave primaria para eliminar
	public d_Insumo(String host, String user, String pwd, int ins_Codigo) {
		super();
		this.host=host;
		this.user=user;
		this.pwd=pwd;
		this.ins_Codigo = ins_Codigo;

		
	}
	
	
	
	// CONSTRUCTOR SOLO PARA CONEXION
	public d_Insumo(String host, String user, String pwd) {
		try{

			Class.forName("com.mysql.jdbc.Driver");
			this.cx = DriverManager.getConnection(host, user, pwd);
			this.stm = cx.createStatement();

		}catch(SQLException e){
			
			System.out.println(e.toString());
			System.out.println("Error");
			
		}catch(ClassNotFoundException e){
			
			System.out.println(e.toString());
			System.out.println("Error");
			
		}
	}
	

	
	public d_Insumo(){
		try{

			Class.forName("com.mysql.jdbc.Driver");
			cx = DriverManager.getConnection(host,user,pwd);

		}catch(SQLException e){
			System.out.println(e.toString());
		}catch(ClassNotFoundException e){
			System.out.println(e.toString());
		}
	}

	
	public Connection getConnection() {
		return this.cx;
	}



	public Statement getStatement() {
		return this.stm;
	}





	public int getIns_Codigo() {
		return ins_Codigo;
	}




	public String getIns_Nombre() {
		return ins_Nombre;
	}




	public int getIns_Cantidad() {
		return ins_Cantidad;
	}




	public float getIns_Precio() {
		return ins_Precio;
	}




	public String getIns_Desc() {
		return ins_Desc;
	}




	public String getUser() {
		return user;
	}




	public String getPwd() {
		return pwd;
	}




	public String getHost() {
		return host;
	}




	// Metodo para el ALTA
	public boolean nuevoRegistro(int ins_Codigo, String ins_Nombre, int ins_Cantidad,String ins_Desc, float ins_Precio, Statement stm) {	
		
		try {
			stm.execute("INSERT INTO INSUMO (N_INSUMO, NOMBRE_INSUMO, CANTIDAD_STOCK, DESCRIPCION, PRECIO) VALUES ('"+ins_Codigo+"','"+ins_Nombre+"','"+ins_Cantidad+"','"+ins_Desc+"','"+ins_Precio+"')");
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	
	
	
	// Metodo para la MODIFICACI�N
	public boolean modificarRegistro(int ins_Codigo, String ins_Nombre, int ins_Cantidad,String ins_Desc, float ins_Precio, Statement stm) {	
	
		
		try {
			stm.execute("UPDATE INSUMO SET  NOMBRE_INSUMO =('"+ ins_Nombre +"'), CANTIDAD_STOCK =('"+ ins_Cantidad +"'), DESCRIPCION =('"+ ins_Desc +"'), "
				 	   + "PRECIO =('"+ ins_Precio +"') WHERE N_INSUMO = "+ ins_Codigo +";");
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	// Metodo para la BAJA
	public boolean eliminarRegistro(int ins_Codigo,Statement stm) {	
		
		try {
			stm.execute("DELETE FROM INSUMO WHERE N_INSUMO = "+ ins_Codigo +";");
			return true;
		} catch (SQLException e) {
			return false;
		}
		
		
		
		
		
		// M�todo para el LISTADO en JTable
		
	}	

	public Object[][] listarInsumos() {
    	int cantRegistros = 0;
		String consulta = "SELECT * FROM INSUMO ";
		String consultaCantidad = "SELECT count(*) AS CANTIDAD_STOCK FROM INSUMO";
		
		try{
			PreparedStatement pstm = cx.prepareStatement(consultaCantidad);
			ResultSet res = pstm.executeQuery();
			res.next();
			cantRegistros = res.getInt("CANTIDAD_STOCK"); 
			res.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		
		Object[][] data = new String[cantRegistros][5];
		
		try{
			PreparedStatement pstm = cx.prepareStatement(consulta);
			ResultSet res = pstm.executeQuery();
			int i = 0;
			
			while(res.next()){
				data[i][0] = res.getString( "N_INSUMO" );
				data[i][1] = res.getString( "NOMBRE_INSUMO" );
				data[i][2] = res.getString( "CANTIDAD_STOCK" );
				data[i][3] = res.getString( "DESCRIPCION" );
				data[i][4] = res.getString( "PRECIO" );
				i++;
			}
			res.close();
		}catch(SQLException e){
			System.out.println(e.toString());
		}
		return data;
	}
		

}


