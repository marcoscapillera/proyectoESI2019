package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class d_Proveedor {
	
	private Connection cx; 
	private Statement stm;
	private String numeroProv;
	private String nombre;
	private String telefono;
	private String calle;
	private String puerta;
	private String localidad;
	private String email;	
	private String user; 
	private String pwd; 
	private String host; 
	
	
	
	public d_Proveedor(){
		
	}
	


	public d_Proveedor(String numeroProv, String nombre, String email,String calle, String puerta, String localidad) {
		
		this.numeroProv = numeroProv;
		this.nombre = nombre;

		this.calle = calle;
		this.puerta = puerta;
		this.localidad = localidad;
		this.email = email;
	}




	public Connection getConnection() {
		return cx;
	}


	public void setConnection(Connection cx) {
		this.cx = cx;
	}


	public Statement getSatement() {
		return stm;
	}


	public void setStatement(Statement stm) {
		this.stm = stm;
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


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	// Metodo para el ALTA
	public boolean nuevoRegistro(String numeroProv, String nombre,String email, String calle, String puerta, String localidad) {	
		
		  try
		    {
		      // create the mysql database connection
		      String myDriver = "com.mysql.jdbc.Driver";
		     
		      Class.forName(myDriver);
		      java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MantenimientoInformatico", "root", "");
		      

		      String query = "INSERT INTO PROVEEDOR ( N_PROVEEDOR, NOMBRE_PROVEEDOR,EMAIL,CALLE,NUMERO,LOCALIDAD) VALUES  (?,?,?,?,?,?)";
		      java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString(1, numeroProv);
		      preparedStmt.setString(2, nombre);
		      preparedStmt.setString(3, email);
		      preparedStmt.setString(4, calle);
		      preparedStmt.setString(5, puerta);
		      preparedStmt.setString(6, localidad);
	
		      

		      // execute the preparedstatement
		      preparedStmt.execute();
		      JOptionPane.showMessageDialog(null, "Registro ingresado con exito.", "INGRESAR", JOptionPane.INFORMATION_MESSAGE);
		      
		      conn.close();
		      return true;
		    }
		    catch (Exception e)
		    {
		      System.err.println("Error! ");
		      System.err.println(e.getMessage());
		      return false;
		    }
		  
	}	  
		  
			// Metodo para la MODIFICACI�N
			public boolean modificarRegistro(String numeroProv, String nombre,String email, String calle, String puerta, String localidad) {
				
				  try
				    {
				      // create the mysql database connection
				      String myDriver = "com.mysql.jdbc.Driver";
				     
				      Class.forName(myDriver);
				      java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MantenimientoInformatico", "root", "");
				      

				      String query = "UPDATE PROVEEDOR 	SET N_PROVEEDOR=?, NOMBRE_PROVEEDOR=?, EMAIL=?, CALLE=?, NUMERO=?, LOCALIDAD=?  WHERE N_PROVEEDOR="+numeroProv;
				      java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
				      preparedStmt.setString(1, numeroProv);
				      preparedStmt.setString(2, nombre);
				      preparedStmt.setString(3, email);
				      preparedStmt.setString(4, calle);
				      preparedStmt.setString(5, puerta);
				      preparedStmt.setString(6, localidad);
			
				      
				      // execute the preparedstatement
				      preparedStmt.execute();
				     
				      conn.close();
				      return true;
				    }
				    catch (Exception e)
				    {
				      System.err.println("Got an exception! ");
				      System.err.println(e.getMessage());
				      return false;
				    }
					
			 
			
	}
	
}
