package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class d_cliente {
	private Connection cx;
	private Statement stm;
	private String user="root";
	private String pwd="";
	private String host="jdbc:mysql://localhost/MantenimientoInformatico";
	private String CI;
	private String Nombre;
	private String ApPat;
	private String ApeMat;
	private String numero_Puerta;
	private String Localidad;
	private String Calle;
	private String Telefono;


public d_cliente(String user, String pwd, String host, String cI, String nombre, String apPat, String apeMat,
			String numero_Puerta, String localidad, String calle, String telefono) {
		super();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cx = DriverManager.getConnection(host, user, pwd);
			this.stm = cx.createStatement();
			this.user = user;
			this.pwd = pwd;
			this.host = host;
			this.CI = cI;
			this.Nombre = nombre;
			this.ApPat = apPat;
			this.ApeMat = apeMat;
			this.numero_Puerta = numero_Puerta;
			this.Localidad = localidad;
			this.Calle = calle;
			this.Telefono = telefono;

		} catch (SQLException e) {

			System.out.println(e.toString());

			System.out.println("Error");

		} catch (ClassNotFoundException e) {

			System.out.println(e.toString());
			System.out.println("Error");

		}

	}


	public d_cliente() {
		try{

			Class.forName("com.mysql.jdbc.Driver");
			cx = DriverManager.getConnection(host,user,pwd);

		}catch(SQLException e){
			System.out.println(e.toString());
		}catch(ClassNotFoundException e){
			System.out.println(e.toString());
		}
	}



	
	public d_cliente(String cI, String nombre, String apPat, String apeMat, String numero_Puerta, String localidad,
		String calle, String telefono) {
	super();
	this.CI = cI;
	this.Nombre = nombre;
	this.ApPat = apPat;
	this.ApeMat = apeMat;
	this.numero_Puerta = numero_Puerta;
	this.Localidad = localidad;
	this.Calle = calle;
	this.Telefono = telefono;
}




	public d_cliente(String host, String user, String pwd) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			this.cx = DriverManager.getConnection(host, user, pwd);
			this.stm(cx.createStatement());

		} catch (SQLException e) {

			System.out.println(e.toString());

		} catch (ClassNotFoundException e) {

			System.out.println(e.toString());

		}
	}

	private void stm(Statement createStatement) {
		// TODO Auto-generated method stub
		
	}


	public Connection getConnection() {
		return this.cx;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Statement getStatement() {
		return this.stm;
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

	public String getCI() {
		return CI;
	}

	public void setCI(String cI) {
		CI = cI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApPat() {
		return ApPat;
	}

	public void setApPat(String apPat) {
		ApPat = apPat;
	}

	public String getApeMat() {
		return ApeMat;
	}

	public void setApeMat(String apeMat) {
		ApeMat = apeMat;
	}

	public String getNumero_Puerta() {
		return numero_Puerta;
	}

	public void setNumero_Puerta(String numero_Puerta) {
		this.numero_Puerta = numero_Puerta;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getCalle() {
		return Calle;
	}

	public void setCalle(String calle) {
		Calle = calle;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	// M�todo para el ALTA
	public boolean nuevoRegistro(String CI, String Nombre, String ApPat, String ApeMat, String Calle, String numero_puerta,
			String Telefono, String Localidad, Statement stm) {

		try {
			stm.execute("INSERT INTO PERSONA (CI, Nombre, Apellido_Paterno, Apellido_Materno, Calle, Numero, Localidad) VALUES ('"+ CI + "','" + Nombre + "','" + ApPat + "','" + ApeMat + "','" + Calle + "','"+ numero_puerta + "','" + Telefono + "','" + Localidad + "');");
			return true;
		} catch (SQLException e) {
			System.out.println("error");
			return false;
		}

	}

	// M�todo para la MODIFICACI�N
	public boolean modificarRegistro(int CI, String nom, Statement stm) {

		try {
			stm.execute("UPDATE persona SET Nombre = ('" + nom + "') WHERE CI = " + CI + ";");
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	// M�todo para la BAJA
	public boolean eliminarRegistro(int CI, Statement stm) {

		try {
			stm.execute("DELETE FROM persona WHERE CI = ('" + CI + "');");
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	// M�todo para el LISTADO en JTable
	public Object[][] listarPersonas(Connection cx, Statement stm) {

		int cantRegistros = 0;
		String consulta = "SELECT * FROM persona ORDER BY CI";
		String consultaCantidad = "SELECT count(*) AS total FROM persona";

		try {
			PreparedStatement pstm = cx.prepareStatement(consultaCantidad);
			ResultSet res = pstm.executeQuery();
			res.next();
			cantRegistros = res.getInt("total");
			res.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		Object[][] data = new String[cantRegistros][7];

		try {
			PreparedStatement pstm = cx.prepareStatement(consulta);
			ResultSet res = pstm.executeQuery();
			int i = 0;

			while (res.next()) {
				data[i][0] = res.getString("CI");
				data[i][1] = res.getString("Nombre");
				data[i][2] = res.getString("Apellido_Paterno");
				data[i][3] = res.getString("Apellido_Materno");
				data[i][4] = res.getString("Calle");
				data[i][5] = res.getString("Numero");
				data[i][6] = res.getString("Localidad");
				i++;
			}
			res.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return data;
	}

}
