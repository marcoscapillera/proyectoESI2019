package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import Logica.L_Insumos;
import Presentacion.Insumos;


public class JDBC_MySQL {
	public static void main(String[] args){	
		
		//Connection permite crear la conexion con el servidor de la base de datos
		Connection connect = null;	
		//Statements permitir� emitir consultas SQL a la base de datos
		Statement statement = null;	
		//ResultSet obtiene el resultado de la consulta SQL query
		ResultSet resultSet = null;
	
		try {
			
			//Siempre es necesaria esta l�nea de c�digo
			//para cargar el MySQL driver
			Class.forName("com.mysql.jdbc.Driver");
						
			connect = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");		
			statement = connect.createStatement();
	
			//Creamos la base de datos e introducimos algunos datos
			//execute() permite realizar consultas de recuperacion y modificacion
			statement.execute("CREATE DATABASE MantenimientoInformatico;");
			statement.execute("USE MantenimientoInformatico;");
			
			//Se crea tabla PERSONA
			statement.execute("CREATE TABLE `PERSONA` (`CI` char(8) NOT NULL, `Nombre` varchar(30) NOT NULL,"
					+ " `Apellido_Paterno` varchar(30) NOT NULL,`Apellido_Materno` varchar(30) NOT NULL,"
					+ "`Calle` varchar(30) DEFAULT NULL,`Numero` char(15) DEFAULT NULL,"
					+ "`Localidad` varchar(20) DEFAULT NULL,PRIMARY KEY (`CI`))");
			
			//Se crea tabla CLIENTE
			statement.execute("CREATE TABLE `CLIENTE` ("
					  +"`CI` char(8) NOT NULL,"
					  +"`TIPO_PERFIL` varchar(20) DEFAULT NULL,"
					  +"PRIMARY KEY (`CI`),"
					  +"CONSTRAINT `CLIENTE_FK` FOREIGN KEY (`CI`) REFERENCES `PERSONA` (`CI`));");
			
			
			//Se crea tabla TECNICO
			statement.execute("CREATE TABLE `TECNICO` (\r\n" + 
					"  `CI` char(8) NOT NULL,\r\n" + 
					"  `FECHA_INGRESO` date NOT NULL,\r\n" + 
					"  PRIMARY KEY (`CI`),\r\n" + 
					"  CONSTRAINT `TECNICO_FK` FOREIGN KEY (`CI`) REFERENCES `PERSONA` (`CI`)\r\n" + 
					");");
			
			//Se crea tabla INSUMO
			statement.execute("CREATE TABLE `INSUMO` (\r\n" + 
					"  `N_INSUMO` int(11) NOT NULL,\r\n" + 
					"  `NOMBRE_INSUMO` varchar(20) DEFAULT NULL,\r\n" + 
					"  `CANTIDAD_STOCK` int(11) DEFAULT NULL,\r\n" + 
					"  `DESCRIPCION` varchar(100) DEFAULT NULL,\r\n" + 
					"  `PRECIO` float DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (`N_INSUMO`)\r\n" + 
					");");
			
			//Se crea tabla HARDWARE
			statement.execute("CREATE TABLE `HARDWARE` (\r\n" + 
					"  `N_INUSMO` int(11) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`N_INUSMO`),\r\n" + 
					"  CONSTRAINT `HARDWARE_FK` FOREIGN KEY (`N_INUSMO`) REFERENCES `INSUMO` (`N_INSUMO`)\r\n" + 
					");");
			
			//Se crea tabla SOFTWARE
			statement.execute("CREATE TABLE `SOFTWARE` (\r\n" + 
					"  `N_INSUMO` int(11) NOT NULL,\r\n" + 
					"  `TIPO_SOFTWARE` varchar(15) DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (`N_INSUMO`),\r\n" + 
					"  CONSTRAINT `SOFTWARE_FK` FOREIGN KEY (`N_INSUMO`) REFERENCES `INSUMO` (`N_INSUMO`)\r\n" + 
					");");
			
			
			//Se crea tabla PAQUETE
			statement.execute("CREATE TABLE `PAQUETE` (\r\n" + 
					"  `ID_PAQUETE` int(11) NOT NULL,\r\n" + 
					"  `NOMBRE_PAQUETE` varchar(30) DEFAULT NULL,\r\n" + 
					"  `CALCULO_DE_HORAS` float DEFAULT NULL,\r\n" + 
					"  `COSTO_PRESUPUESTADO` float DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (`ID_PAQUETE`)\r\n" + 
					");");
			
			//Se crea tabla PERFIL
			statement.execute("CREATE TABLE `PERFIL` (\r\n" + 
					"  `ID_PERFIL` int(11) NOT NULL,\r\n" + 
					"  `NOMBRE_PERFIL` varchar(15) DEFAULT NULL,\r\n" + 
					"  `DESCUENTO` float DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (`ID_PERFIL`)\r\n" + 
					");");
			//Se crea tabla PROVEEDOR
			statement.execute("CREATE TABLE `PROVEEDOR` (\r\n" + 
					"  `N_PROVEEDOR` varchar(11) NOT NULL,\r\n" + 
					"  `NOMBRE_PROVEEDOR` varchar(20) DEFAULT NULL,\r\n" + 
					"  `E-MAIL` varchar(30) DEFAULT NULL,\r\n" + 				
					"  `CALLE` varchar(30) DEFAULT NULL,\r\n" + 
					"  `NUMERO` int(11) DEFAULT NULL,\r\n" +
					"  `LOCALIDAD` varchar(20) DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (`N_PROVEEDOR`)\r\n" + 
					");");
			
			//Se crea tabla REQUIERE
			statement.execute("CREATE TABLE `REQUIERE` (\r\n" + 
					"  `N_INSUMO` int(11) NOT NULL,\r\n" + 
					"  `ID_PAQUETE` int(11) NOT NULL,\r\n" + 
					"  `CANTIDAD` int(11) DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (`N_INSUMO`),\r\n" + 
					"  KEY `REQUIERE_FK_1` (`ID_PAQUETE`),\r\n" + 
					"  CONSTRAINT `REQUIERE_FK` FOREIGN KEY (`N_INSUMO`) REFERENCES `INSUMO` (`N_INSUMO`),\r\n" + 
					"  CONSTRAINT `REQUIERE_FK_1` FOREIGN KEY (`ID_PAQUETE`) REFERENCES `PAQUETE` (`ID_PAQUETE`)\r\n" + 
					");");
			
			//Se crea tabla SERVICIO
			statement.execute("CREATE TABLE `SERVICIO` (\r\n" + 
					"  `N_SERVICIO` int(11) NOT NULL,\r\n" + 
					"  `TIPO_SERVICIO` varchar(30) DEFAULT NULL,\r\n" + 
					"  `CI` char(8) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`N_SERVICIO`),\r\n" + 
					"  KEY `SERVICIO_FK` (`CI`),\r\n" + 
					"  CONSTRAINT `SERVICIO_FK` FOREIGN KEY (`CI`) REFERENCES `TECNICO` (`CI`)\r\n" + 
					");");
			
			//Se crea tabla SOLICITAR
			statement.execute("CREATE TABLE `SOLICITAR` (\r\n" + 
					"  `N_SERVICIO` int(11) NOT NULL,\r\n" + 
					"  `CI` char(8) NOT NULL,\r\n" + 
					"  `FECHA_PRESUPUESTO` date NOT NULL,\r\n" + 
					"  `FECHA_INICIO` date NOT NULL,\r\n" + 
					"  `FECHA_FIN` date DEFAULT NULL,\r\n" + 
					"  `CANTIDAD_HORAS` int(11) DEFAULT NULL,\r\n" + 
					"  `ESTADO` varchar(20) DEFAULT NULL,\r\n" + 
					"  `CAUSA` varchar(50) DEFAULT NULL,\r\n" + 
					"  `PRESUPUESTO` float NOT NULL,\r\n" + 
					"  PRIMARY KEY (`N_SERVICIO`,`CI`),\r\n" + 
					"  KEY `SOLICITAR_FK` (`CI`),\r\n" + 
					"  CONSTRAINT `SOLICITAR_FK` FOREIGN KEY (`CI`) REFERENCES `CLIENTE` (`CI`)\r\n" + 
					");");
			
			//Se crea tabla TELEFONOS_PROVEEDOR
			statement.execute("CREATE TABLE `TELEFONOS_PROVEEDOR` (\r\n" + 
					"  `N_PROVEEDOR` varchar(11) NOT NULL,\r\n" + 
					"  `TELEFONOS` char(20) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`N_PROVEEDOR`,`TELEFONOS`),\r\n" + 
					"  CONSTRAINT `TELEFONOS_PROVEEDOR_FK` FOREIGN KEY (`N_PROVEEDOR`) REFERENCES `PROVEEDOR` (`N_PROVEEDOR`)\r\n" + 
					");");
			
			//Se crea tabla TIENE
			statement.execute("CREATE TABLE `TIENE` (\r\n" + 
					"  `CI` char(8) NOT NULL,\r\n" + 
					"  `ID_PERFIL` int(11) DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (`CI`),\r\n" + 
					"  KEY `TIENE_FK` (`ID_PERFIL`),\r\n" + 
					"  CONSTRAINT `TIENE_FK` FOREIGN KEY (`ID_PERFIL`) REFERENCES `PERFIL` (`ID_PERFIL`)\r\n" + 
					");");
			
			//Se crea tabla Telefonos_Persona
			statement.execute("CREATE TABLE `Telefonos_Persona` (\r\n" + 
					"  `CI` char(8) NOT NULL,\r\n" + 
					"  `Telefono` char(20) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`CI`,`Telefono`)\r\n" + 
					");");
			
			//Se crea tabla UTILIZA
			statement.execute("CREATE TABLE `UTILIZA` (\r\n" + 
					"  `N_SERVICIO` int(11) NOT NULL,\r\n" + 
					"  `CI` char(8) NOT NULL,\r\n" + 
					"  `N_INSUMO` int(11) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`N_SERVICIO`,`CI`,`N_INSUMO`),\r\n" + 
					"  KEY `UTILIZA_FK_1` (`CI`),\r\n" + 
					"  KEY `UTILIZA_FK_2` (`N_INSUMO`),\r\n" + 
					"  CONSTRAINT `UTILIZA_FK` FOREIGN KEY (`N_SERVICIO`) REFERENCES `SERVICIO` (`N_SERVICIO`),\r\n" + 
					"  CONSTRAINT `UTILIZA_FK_1` FOREIGN KEY (`CI`) REFERENCES `TECNICO` (`CI`),\r\n" + 
					"  CONSTRAINT `UTILIZA_FK_2` FOREIGN KEY (`N_INSUMO`) REFERENCES `INSUMO` (`N_INSUMO`)\r\n" + 
					");");
			
			
			/*
			L_Insumos objInsumos = new L_Insumos(); 
			java.sql.PreparedStatement ps;
			ps= connect.prepareStatement("insert into PERSONA (N°_INSUMO,NOMBRE_INSUMO,CANTIDAD_STOCK,DESCRIPCION,PRECIO) values (?,?,?,?,?)"); 
			
			ps.setInt(1,objInsumos.getText());
			ps.setString(2, objInsumos.getIns_Nombre());
			ps.setInt(3, objInsumos.getIns_Cantidad());
			ps.setString(4, objInsumos.getIns_Desc());
			ps.setFloat(5, objInsumos.getIns_Precio());
			
			*/
			
			/*statement.execute("CREATE TABLE tabla (id INT PRIMARY KEY, nombre VARCHAR(20));");
			statement.execute("INSERT INTO tabla VALUES (1, 'Juan');");
			statement.execute("INSERT INTO tabla VALUES (2, 'Pepito');");
			statement.execute("INSERT INTO tabla VALUES (3, 'Pedro');");
			*/
			
			//executeQuery() solo permite realizar consultas de recuperacion: SELECT..
			//resultSet = statement.executeQuery("SELECT * FROM tabla");
	
			//executeUpdate() permite realizar consultas unicamente de modificacion
			
			//Se procesa el resultado
			System.out.println("Contenido de la tabla");
	
			while (resultSet.next())	{  
	
				String nom = resultSet.getString("nombre");	
				int cod = resultSet.getInt("id");
				
				System.out.println("Nombre: " + nom + ", ID: " + cod);
	
			}
			
			//Cerramos el acceso a las consultas
			statement.close();
			//Cerramos la conexion con la base de datos por seguridad
			connect.close();
			//Se cierran en orden inverso a como fueron creados
	
		} catch (Exception e){
	
			System.out.println ("Error base de datos".equals(e));
	
		}
	}
}
