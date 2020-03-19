package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Datos.d_Insumo;
import Datos.d_Proveedor;
import Datos.d_Solicitar;
import Logica.L_Proveedor;
import Logica.L_Solicitar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Proveedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtProv;
	private JTextField txtNomP;
	private JTextField txtTelProv;

	String numeroProv;
	String nombre;
	String telefono;
	String calle;
	String puerta;
	String localidad;
	String email;

	L_Proveedor lp;
	d_Proveedor dp;
	private JTextField txtemail;
	private JTextField txtcalle;
	private JTextField txtnumero;
	private JTextField txtlocalidad;
	private JTable tableInsumos;

	int conteo = 0;

	// Metodo para limpiar las cajas(Boton LIMPIAR)
	private void limpiarCajas() {

		txtProv.setText(null);
		txtNomP.setText(null);
		txtTelProv.setText(null);
		txtemail.setText(null);
		txtcalle.setText(null);
		txtnumero.setText(null);
		txtlocalidad.setText(null);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proveedor frame = new Proveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proveedor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 636);
		contentPane = new JPanel();
		setTitle("Proveedor");

		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlTable = new JPanel();
		pnlTable.setBounds(33, 344, 831, 183);
		contentPane.add(pnlTable);

		JPanel panel = new JPanel();
		// panel.setBounds(0, 0, 900, 636);
		contentPane.add(panel);
		panel.setLayout(null);

		// Listando INSUMOS EN JTABLE

		panel.setBounds(0, 0, 900, 606);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton button_2 = new JButton("Ingresar");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//////////////////////////
				// *VALIDACIONES/////////
				/////////////////////////

				while (txtProv.getText().equals("") || txtNomP.getText().equals("") || txtTelProv.getText().equals("")
						|| txtemail.getText().equals("") || txtcalle.getText().equals("")
						|| txtnumero.getText().equals("") || txtlocalidad.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;

				}

				/*
				 * ******************************************************** INSERTAR NUEVO
				 * REGISTRO (ALTA)
				 *********************************************************/

				if (conteo != 1) {

					numeroProv = txtProv.getText();
					nombre = txtNomP.getText();
					telefono = txtTelProv.getText();
					email = txtemail.getText();
					calle = txtcalle.getText();
					puerta = txtnumero.getText();
					localidad = txtlocalidad.getText();

					lp = new L_Proveedor(numeroProv, nombre, email, calle, puerta, localidad);

					if (!lp.numeroProveedorVacio(lp.getNumeroProv())) {

						dp = new d_Proveedor(numeroProv, nombre, email, calle, puerta, localidad);

						if (dp.nuevoRegistro(dp.getNumeroProv(), dp.getNombre(), dp.getEmail(), dp.getCalle(),
								dp.getPuerta(), dp.getLocalidad())) {

							JOptionPane.showMessageDialog(null, "Registro guardado con exito.", "ALTA",
									JOptionPane.INFORMATION_MESSAGE);
							limpiarCajas();

						} else {
							JOptionPane.showMessageDialog(null, "Ups! No se pudo guardar :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Ups! Debe ingresar numero de proveedor", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(null, "Ingrese datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				while (txtProv.getText().equals("") || txtNomP.getText().equals("") || txtTelProv.getText().equals("")
						|| txtemail.getText().equals("") || txtcalle.getText().equals("")
						|| txtnumero.getText().equals("") || txtlocalidad.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;

				}
				/*
				 * ******************************************************** EDITAR REGISTRO
				 * (MODIFICACION)
				 *********************************************************/

				if (conteo != 1) {
					numeroProv = txtProv.getText();
					nombre = txtNomP.getText();
					telefono = txtTelProv.getText();
					email = txtemail.getText();
					calle = txtcalle.getText();
					puerta = txtnumero.getText();
					localidad = txtlocalidad.getText();

					lp = new L_Proveedor(numeroProv, nombre, email, calle, puerta, localidad);

					if (!lp.numeroProveedorVacio(lp.getNumeroProv())) {

						dp = new d_Proveedor(numeroProv, nombre, email, calle, puerta, localidad);

						if (dp.modificarRegistro(dp.getNumeroProv(), dp.getNombre(), dp.getEmail(), dp.getCalle(),
								dp.getPuerta(), dp.getLocalidad())) {

							JOptionPane.showMessageDialog(null, "Registro modificado con exito.", "BAJA",
									JOptionPane.INFORMATION_MESSAGE);
							limpiarCajas();

						} else {
							JOptionPane.showMessageDialog(null, "Ups! No se pudo modificar :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Ups! Debe ingresar numero de proveedor", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(null, "Ingrese datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//////////////////////////
				// *VALIDACIONES/////////
				/////////////////////////

				while (txtProv.getText().equals("") || txtNomP.getText().equals("") || txtTelProv.getText().equals("")
						|| txtemail.getText().equals("") || txtcalle.getText().equals("")
						|| txtnumero.getText().equals("") || txtlocalidad.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;

				}

				// ELIMINAR

				if (conteo != 1) {
					lp = new L_Proveedor(numeroProv);

					numeroProv = txtProv.getText();

					try {
						// create the mysql database connection
						String myDriver = "com.mysql.jdbc.Driver";

						Class.forName(myDriver);
						java.sql.Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/MantenimientoInformatico", "root", "");

						String query = "delete from PROVEEDOR where N_PROVEEDOR = ?";
						java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.setInt(1, Integer.parseInt(txtProv.getText()));

						// execute the preparedstatement
						preparedStmt.execute();
						JOptionPane.showMessageDialog(null, "Registro elimiando con exito.", "ELIMINAR",
								JOptionPane.INFORMATION_MESSAGE);
						limpiarCajas();
						conn.close();
					} catch (Exception e1) {
						System.err.println("Got an exception! ");
						System.err.println(e1.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton btn_Limpiar = new JButton("Limpiar");
		btn_Limpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				limpiarCajas();
			}
		});
		btn_Limpiar.setBackground(Color.ORANGE);
		btn_Limpiar.setBounds(754, 557, 119, 25);
		panel.add(btn_Limpiar);
		btnEliminar.setBackground(Color.ORANGE);
		btnEliminar.setBounds(521, 557, 119, 25);
		panel.add(btnEliminar);
		btnModificar.setBackground(Color.ORANGE);
		btnModificar.setBounds(268, 557, 119, 25);
		panel.add(btnModificar);

		txtlocalidad = new JTextField();
		txtlocalidad.setBounds(457, 243, 416, 25);
		panel.add(txtlocalidad);
		txtlocalidad.setColumns(10);

		txtnumero = new JTextField();
		txtnumero.setBounds(332, 243, 115, 25);
		panel.add(txtnumero);
		txtnumero.setColumns(10);

		txtcalle = new JTextField();
		txtcalle.setBounds(22, 243, 292, 25);
		panel.add(txtcalle);
		txtcalle.setColumns(10);

		txtemail = new JTextField();
		txtemail.setBounds(662, 185, 211, 21);
		panel.add(txtemail);
		txtemail.setColumns(10);
		button_2.setBackground(Color.ORANGE);
		button_2.setBounds(22, 557, 119, 25);
		panel.add(button_2);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * ******************************************************** BUSCAR REGISTRO
				 * (CONSULTA)
				 *********************************************************/

				// Se guarda en una variable el contenido de la caja buscar
				String sBuscar = txtProv.getText();

				while (txtProv.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "N_PROVEEDOR VACIO", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;
				}

				if (conteo != 1) {
					// Connection permite crear la conexion con el servidor de la base de datos
					Connection connect = null;
					// Statements permitir� emitir consultas SQL a la base de datos
					Statement statement = null;
					// ResultSet obtiene el resultado de la consulta SQL query
					ResultSet resultSet = null;

					try {

						Class.forName("com.mysql.jdbc.Driver");

						connect = (Connection) DriverManager
								.getConnection("jdbc:mysql://localhost/MantenimientoInformatico", "root", "");

						statement = connect.createStatement();

						// Realiza la busqueda del codigo ingresado en la tabla insumo
						resultSet = statement.executeQuery("SELECT * FROM PROVEEDOR WHERE N_PROVEEDOR=" + sBuscar);

						// Se procesa el resultado

						// Si encuentra el codigo, todos los demas campos se autocompletan
						while (resultSet.next()) {

							String numeroProv = resultSet.getString("N_PROVEEDOR");
							String nombre = resultSet.getString("NOMBRE_PROVEEDOR");
							String email = resultSet.getString("EMAIL");
							String calle = resultSet.getString("CALLE");
							String puerta = resultSet.getString("NUMERO");
							String localidad = resultSet.getString("LOCALIDAD");

							txtProv.setText(numeroProv);
							txtNomP.setText(nombre);
							txtemail.setText(email);
							txtcalle.setText(calle);
							txtnumero.setText(puerta);
							txtlocalidad.setText(localidad);

						}

						// Cerramos el acceso a las consultas
						statement.close();
						// Cerramos la conexion con la base de datos por seguridad
						connect.close();
						// Se cierran en orden inverso a como fueron creados

					} catch (Exception e) {

						System.out.println("Error base de datos".equals(e));

					}

				} else {
					JOptionPane.showMessageDialog(null, "Ingrese datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnBuscar.setBackground(new Color(102, 204, 153));
		btnBuscar.setBounds(750, 274, 123, 25);
		panel.add(btnBuscar);

		JLabel lblProveedorN = new JLabel("Proveedor N\u00B0");
		lblProveedorN.setBounds(22, 157, 152, 25);
		panel.add(lblProveedorN);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(200, 161, 56, 16);
		panel.add(lblNewLabel);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(465, 218, 146, 16);
		panel.add(lblLocalidad);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(22, 218, 296, 16);
		panel.add(lblCalle);

		JLabel lblN = new JLabel("N° Puerta");
		lblN.setBounds(332, 218, 83, 16);
		panel.add(lblN);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(662, 161, 56, 16);
		panel.add(lblEmail);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(468, 161, 172, 16);
		panel.add(lblTelefono);

		txtProv = new JTextField();
		txtProv.setBounds(22, 184, 166, 22);
		panel.add(txtProv);
		txtProv.setColumns(10);

		txtNomP = new JTextField();
		txtNomP.setBounds(200, 185, 249, 22);
		panel.add(txtNomP);
		txtNomP.setColumns(10);

		txtTelProv = new JTextField();
		txtTelProv.setBounds(461, 184, 179, 22);
		panel.add(txtTelProv);
		txtTelProv.setColumns(10);

		JLabel lblProveedores = new JLabel("Proveedores");
		lblProveedores.setFont(new Font("Dialog", Font.BOLD, 17));
		lblProveedores.setForeground(Color.WHITE);
		lblProveedores.setBounds(22, 48, 123, 48);
		panel.add(lblProveedores);

		JLabel lblImgProveedor = new JLabel("");
		lblImgProveedor.setIcon(new ImageIcon(Proveedor.class.getResource("/Imagenes/Insumos.png")));
		lblImgProveedor.setBounds(0, 0, 900, 609);
		panel.add(lblImgProveedor);
	}
}
