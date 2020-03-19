package Datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class d_Solicitar {
	private Connection cx; 
	private Statement stm;
	
	private int nServicio;
	private int numTecnico;
	private String cICliente;
	private String fechaInicio;
	private String fechaFin;
	private String fechaPresu;
	private int cantHoras;
	private String estado;
	private String tipoSerevicio;
	private String causa;
	private float presupuesto;
	
	private String user="root";
	private String pwd=""; 
	private String host="jdbc:mysql://localhost/MantenimientoInformatico"; 
	 
	

	//CONSTRUCTOR COMPLETO
	public d_Solicitar(Connection cx, Statement stm, int numServicio, String CiCliente,int numTecnico, String fehcaInicio,
			String fechaFin, String fechaPresu, int cantidadHoras, String estado, String tipoSerevicio, String causa,
			float presupuesto) {
		super();
		this.cx = cx;
		this.stm = stm;
		this.nServicio = numServicio;
		this.cICliente=CiCliente;
		this.numTecnico = numTecnico;
		this.fechaInicio = fehcaInicio;
		this.fechaFin = fechaFin;
		this.fechaPresu = fechaPresu;
		this.cantHoras = cantidadHoras;
		this.estado = estado;
		this.tipoSerevicio = tipoSerevicio;
		this.causa = causa;
		this.presupuesto = presupuesto;
	}

	
	public d_Solicitar(String user, String pwd, String host,int numServicio, String ciCliente, String fehcaInicio, String fechaFin, String fechaPresu,
			int cantHoras, String estado, String causa, float presupuesto) {
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			this.cx = DriverManager.getConnection(host, user, pwd);
			this.stm = cx.createStatement();

			
			this.nServicio = numServicio;
			this.cICliente = ciCliente;
			this.fechaInicio = fehcaInicio;
			this.fechaFin = fechaFin;
			this.fechaPresu = fechaPresu;
			this.cantHoras = cantHoras;
			this.estado = estado;
			this.causa = causa;
			this.presupuesto = presupuesto;

		} catch (SQLException e) {

			System.out.println(e.toString());

		} catch (ClassNotFoundException e) {

			System.out.println(e.toString());

		}
		
		
	}

	// CONSTRUCTOR SOLO PARA CONEXION
	public d_Solicitar(String host, String user, String pwd) {
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
	
	

	public d_Solicitar(String cICliente, String fechaInicio, String fechaFin, String fechaPresu, int cantHoras,
			String estado, String tipoSerevicio, String causa, float presupuesto, String user, String pwd,
			String host) {
		super();
		this.cICliente = cICliente;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaPresu = fechaPresu;
		this.cantHoras = cantHoras;
		this.estado = estado;
		this.tipoSerevicio = tipoSerevicio;
		this.causa = causa;
		this.presupuesto = presupuesto;
		this.user = user;
		this.pwd = pwd;
		this.host = host;
	}

	//Metodo Constructor completo
	public d_Solicitar(int nServicio, String cICliente, String fechaInicio, String fechaFin, String fechaPresu, int cantHoras,
			String estado, String causa, float presupuesto) {
		super();
		this.nServicio = nServicio;
		this.cICliente = cICliente;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaPresu = fechaPresu;
		this.cantHoras = cantHoras;
		this.estado = estado;
		this.presupuesto = presupuesto;
		this.causa = causa;
	}

	public d_Solicitar(){
		try{

			Class.forName("com.mysql.jdbc.Driver");
			cx = DriverManager.getConnection(host,user,pwd);

		}catch(SQLException e){
			System.out.println(e.toString());
		}catch(ClassNotFoundException e){
			System.out.println(e.toString());
		}
	}

	
	public String getCiCliente() {
		return cICliente;
	}

	public void setCiCliente(String ciCliente) {
		cICliente = ciCliente;
	}
	
	
	
	
	public Connection getConnection() {
		return this.cx;
	}



	public Statement getStatement() {
		return this.stm;
	}





	public void setCx(Connection cx) {
		this.cx = cx;
	}



	public void setStm(Statement stm) {
		this.stm = stm;
	}

	public int getNumServicio() {
		return nServicio;
	}

	public void setNumServicio(int numServicio) {
		this.nServicio = numServicio;
	}

	public int getNumTecnico() {
		return numTecnico;
	}

	public void setNumTecnico(int numTecnico) {
		this.numTecnico = numTecnico;
	}

	public String getFehcaInicio() {
		return fechaInicio;
	}

	public void setFehcaInicio(String fehcaInicio) {
		this.fechaInicio = fehcaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
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

	public void setCantidadHoras(int cantidadHoras) {
		this.cantHoras = cantidadHoras;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoSerevicio() {
		return tipoSerevicio;
	}

	public void setTipoSerevicio(String tipoSerevicio) {
		this.tipoSerevicio = tipoSerevicio;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	


	// Metodo para el ALTA
	public boolean nuevoRegistro(int nServicio,String cICliente,String fechaInicio,String FechaFin,String fechaPresu,int cantHoras,String estado,String causa,Float presupuesto) {	
		
		  try
		    {
		      // create the mysql database connection
		      String myDriver = "com.mysql.jdbc.Driver";
		     
		      Class.forName(myDriver);
		      java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MantenimientoInformatico", "root", "");
		      

		      String query = "INSERT INTO SOLICITAR (N_SERVICIO, CI, FECHA_PRESUPUESTO, FECHA_INICIO, FECHA_FIN, " + 
		    		  "CANTIDAD_HORAS, ESTADO, CAUSA, PRESUPUESTO) VALUES  (?,?,?,?,?,?,?,?,?)";
		      java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt(1, nServicio);
		      preparedStmt.setString(2, cICliente);
		      preparedStmt.setString(3, fechaInicio);
		      preparedStmt.setString(4, FechaFin);
		      preparedStmt.setString(5, fechaPresu);
		      preparedStmt.setInt(6, cantHoras);
		      preparedStmt.setString(7, estado);
		      preparedStmt.setString(8, causa);
		      preparedStmt.setFloat(9, presupuesto);
		      

		      // execute the preparedstatement
		      preparedStmt.execute();
		      JOptionPane.showMessageDialog(null, "Registro ingresado con exito.", "INSERTAR", JOptionPane.INFORMATION_MESSAGE);
		      
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
		


	// Metodo para la MODIFICACI�N
	public boolean modificarRegistro(int nServicio,String cICliente, String fechaPresu, String fechaInicio, String FechaFin, int cantHoras, String estado, String causa, Float presupuesto) {	
	
		
		  try
		    {
		      // create the mysql database connection
		      String myDriver = "com.mysql.jdbc.Driver";
		     
		      Class.forName(myDriver);
		      java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MantenimientoInformatico", "root", "");
		      

		      String query = "UPDATE SOLICITAR 	SET N_SERVICIO=?, CI=?, FECHA_PRESUPUESTO=?, FECHA_INICIO=?, FECHA_FIN=?, CANTIDAD_HORAS=?, ESTADO=?, CAUSA=?, PRESUPUESTO=? WHERE N_SERVICIO="+nServicio;
		      java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt(1, nServicio);
		      preparedStmt.setString(2, cICliente);
		      preparedStmt.setString(3, fechaPresu);
		      preparedStmt.setString(4, fechaInicio);
		      preparedStmt.setString(5, FechaFin);
		      preparedStmt.setInt(6, cantHoras);
		      preparedStmt.setString(7, estado);
		      preparedStmt.setString(8, causa);
		      preparedStmt.setFloat(9, presupuesto);
		      
		      
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
		String consulta = "SELECT * FROM SOLICITAR ";
		String consultaCantidad = "SELECT count(*) AS CI FROM SOLICITAR";
		
		try{
			PreparedStatement pstm = cx.prepareStatement(consultaCantidad);
			ResultSet res = pstm.executeQuery();
			res.next();
			cantRegistros = res.getInt("CI"); 
			res.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		
		Object[][] data = new String[cantRegistros][9];
		
		try{
			PreparedStatement pstm = cx.prepareStatement(consulta);
			ResultSet res = pstm.executeQuery();
			int i = 0;
			
			while(res.next()){
				data[i][0] = res.getString( "N_SERVICIO" );
				data[i][1] = res.getString( "CI" );
				data[i][2] = res.getString( "FECHA_PRESUPUESTO" );
				data[i][3] = res.getString( "FECHA_INICIO" );
				data[i][4] = res.getString( "FECHA_FIN" );
				data[i][5] = res.getString( "CANTIDAD_HORAS" );
				data[i][6] = res.getString( "ESTADO" );
				data[i][7] = res.getString( "CAUSA" );
				data[i][8] = res.getString( "PRESUPUESTO" );
				
				i++;
			}
			res.close();
		}catch(SQLException e){
			System.out.println(e.toString());
		}
		return data;
	}
	
	
	

}
