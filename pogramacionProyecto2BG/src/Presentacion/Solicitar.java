package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Datos.d_Insumo;
import Datos.d_Solicitar;
import Logica.L_Insumos;
import Logica.L_Solicitar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Solicitar extends JFrame {

	private JPanel contentPane;
	private JTextField txt_NServicio;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTextField txtFecha_Presupuesto;
	private JTextField txtCantHoras;
	private JTextField txtPresupuesto;
	private JTextField txt_Causa;
	private JComboBox cmbTServicio = new JComboBox();
	private JComboBox cmbTecnico = new JComboBox();
	private JTextField txtCliente;
	private JComboBox cmb_Estado = new JComboBox();

	int nServicio = 0;
	String cICliente = "";
	int nTecnico = 0;
	String fechaInicio = "";
	String FechaFin = "";
	String fechaPresu = "";
	int cantHoras = 0;
	String estado = "";
	String tServicio = "";
	float presupuesto = 0.0f;
	String causa = "";
	int conteo = 0;

	L_Solicitar ls;
	private JTextField txtnuevoServicio;

	// Metodo para limpiar las cajas(Boton LIMPIAR)
	private void limpiarCajas() {
		txt_NServicio.setText(null);
		txtFechaInicio.setText(null);
		txtFechaFin.setText(null);
		txtCantHoras.setText(null);
		txtFecha_Presupuesto.setText(null);
		cmbTServicio.setSelectedIndex(0);
		cmbTecnico.setSelectedIndex(0);
		txt_Causa.setText(null);
		txtPresupuesto.setText(null);
		txtCliente.setText(null);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Solicitar frame = new Solicitar();
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
	public Solicitar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 636);
		setTitle("Solicitud");

		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 610);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_3 = new JLabel("YYYY/MM/DD");
		label_3.setFont(new Font("Dialog", Font.BOLD, 9));
		label_3.setBounds(784, 190, 79, 15);
		panel.add(label_3);

		JLabel label_2 = new JLabel("YYYY/MM/DD");
		label_2.setFont(new Font("Dialog", Font.BOLD, 9));
		label_2.setBounds(676, 190, 79, 15);
		panel.add(label_2);

		JLabel lblYyyymmdd = new JLabel("YYYY/MM/DD");
		lblYyyymmdd.setFont(new Font("Dialog", Font.BOLD, 9));
		lblYyyymmdd.setBounds(575, 190, 79, 15);
		panel.add(lblYyyymmdd);

		txtnuevoServicio = new JTextField();
		txtnuevoServicio.setColumns(10);
		txtnuevoServicio.setBounds(24, 416, 275, 24);
		panel.add(txtnuevoServicio);

		JLabel label_1 = new JLabel("Insertar Nuevo Servcio");
		label_1.setBounds(24, 389, 233, 15);
		panel.add(label_1);

		cmbTServicio.addItem("Seleccionar");
		cmbTServicio.addItem("Armado de PC");
		cmbTServicio.setBackground(Color.WHITE);
		cmbTServicio.setBounds(381, 290, 151, 27);
		panel.add(cmbTServicio);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Agregar item a JcomboBox

				String nuevoServicio = txtnuevoServicio.getText();

				cmbTServicio.addItem(nuevoServicio);

				txtnuevoServicio.setText("");

			}
		});
		btnAgregar.setBackground(new Color(255, 102, 153));
		btnAgregar.setBounds(311, 415, 275, 25);
		panel.add(btnAgregar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Solicitar.class.getResource("/Presentacion/buscar.png")));
		label.setBounds(24, 214, 20, 20);
		panel.add(label);

		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(189, 214, 165, 24);
		panel.add(txtCliente);

		JLabel lblCiCliente = new JLabel("CI Cliente");
		lblCiCliente.setBounds(189, 190, 132, 15);
		panel.add(lblCiCliente);

		cmbTecnico.addItem("Seleccionar");
		cmbTecnico.addItem("Lucas");
		cmbTecnico.addItem("Jose");
		cmbTecnico.addItem("Carlos");
		cmbTecnico.addItem("Pablo");

		cmbTecnico.setBackground(Color.WHITE);
		cmbTecnico.setBounds(381, 211, 186, 27);
		panel.add(cmbTecnico);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				limpiarCajas();

			}
		});
		btnLimpiar.setBackground(Color.ORANGE);
		btnLimpiar.setBounds(744, 550, 119, 25);
		panel.add(btnLimpiar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// ELIMINAR

				while (txt_NServicio.getText().equals("") || txtCliente.getText().equals("")
						|| txtFechaInicio.getText().equals("") || txtFechaFin.getText().equals("")
						|| txtFecha_Presupuesto.getText().equals("") || txtCantHoras.getText().equals("")
						|| txtPresupuesto.getText().equals("") || txt_Causa.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;

				}

				if (conteo != 1) {

					nServicio = Integer.parseInt(txt_NServicio.getText());
					L_Solicitar ls = new L_Solicitar(nServicio);

					try {
						// create the mysql database connection
						String myDriver = "com.mysql.jdbc.Driver";

						Class.forName(myDriver);
						java.sql.Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost/MantenimientoInformatico", "root", "");

						String query = "delete from SOLICITAR where N_SERVICIO = ?";
						java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.setInt(1, Integer.parseInt(txt_NServicio.getText()));

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
		btnEliminar.setBackground(Color.ORANGE);
		btnEliminar.setBounds(501, 550, 119, 25);
		panel.add(btnEliminar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				/*
				 * ******************************************************** EDITAR REGISTRO
				 * (MODIFICACION)
				 *********************************************************/

				//////////////////////////
				// *VALIDACIONES/////////
				/////////////////////////

				while (txt_NServicio.getText().equals("") || txtCliente.getText().equals("")
						|| txtFechaInicio.getText().equals("") || txtFechaFin.getText().equals("")
						|| txtFecha_Presupuesto.getText().equals("") || txtCantHoras.getText().equals("")
						|| txtPresupuesto.getText().equals("") || txt_Causa.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;

				}

				if (conteo != 1) {

					// Se guarda dentro de una variable las cajas

					nServicio = Integer.parseInt(txt_NServicio.getText());
					cICliente = txtCliente.getText();
					// nTecnico=(int) (cmbTecnico.getSelectedItem());
					fechaInicio = (txtFechaInicio.getText());
					FechaFin = (txtFechaFin.getText());
					fechaPresu = (txtFecha_Presupuesto.getText());
					cantHoras = Integer.parseInt(txtCantHoras.getText());
					estado = (String) cmb_Estado.getSelectedItem();
					// tServicio=(String) cmbTServicio.getSelectedItem();
					presupuesto = Float.parseFloat(txtPresupuesto.getText());
					causa = txt_Causa.getText();

					L_Solicitar ls = new L_Solicitar(nServicio, cICliente, fechaInicio, FechaFin, fechaPresu, cantHoras,
							estado, causa, presupuesto);

					if (!ls.nServicioVacio(ls.getnServicio()) && !ls.ciClienteVacio(ls.getcICliente())) {

						d_Solicitar ds = new d_Solicitar(nServicio, cICliente, fechaInicio, FechaFin, fechaPresu,
								cantHoras, estado, causa, presupuesto);

						if (ds.modificarRegistro(ds.getNumServicio(), ds.getCiCliente(), ds.getFehcaInicio(),
								ds.getFechaFin(), ds.getFechaPresu(), ds.getCantHoras(), ds.getEstado(), ds.getCausa(),
								ds.getPresupuesto())) {

							JOptionPane.showMessageDialog(null, "Registro modificado con exito.", "Modificacion",
									JOptionPane.INFORMATION_MESSAGE);
							limpiarCajas();

						} else {
							JOptionPane.showMessageDialog(null, "Ups! No se pudo guardar :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Ups! Debe ingresar nombre", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(null, "Ingrese datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnModificar.setBackground(Color.ORANGE);
		btnModificar.setBounds(253, 550, 119, 25);
		panel.add(btnModificar);

		txt_Causa = new JTextField();
		txt_Causa.setColumns(10);
		txt_Causa.setBounds(24, 349, 839, 24);
		panel.add(txt_Causa);

		JButton btnBuscar = new JButton("Buscar");

		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				/*
				 * ******************************************************** BUSCAR REGISTRO
				 * (CONSULTA)
				 *********************************************************/

				// Se guarda en una variable el contenido de la caja buscar
				String sBuscar = txt_NServicio.getText();

				// Connection permite crear la conexion con el servidor de la base de datos
				Connection connect = null;
				// Statements permitir� emitir consultas SQL a la base de datos
				Statement statement = null;
				// ResultSet obtiene el resultado de la consulta SQL query
				ResultSet resultSet = null;

				while (sBuscar.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo N_Servicio está vacío", "Error",
							JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;
				}

				try {

					Class.forName("com.mysql.jdbc.Driver");

					connect = (Connection) DriverManager
							.getConnection("jdbc:mysql://localhost/MantenimientoInformatico", "root", "");

					statement = connect.createStatement();

					// Realiza la busqueda del codigo ingresado en la tabla insumo
					resultSet = statement.executeQuery("SELECT * FROM SOLICITAR WHERE N_SERVICIO=" + sBuscar);

					// Se procesa el resultado

					// Si encuentra el codigo, todos los demas campos se autocompletan
					while (resultSet.next()) {

						int numeroServicio = resultSet.getInt("N_SERVICIO");
						String cedulaCliente = resultSet.getString("CI");
						String fechainicio = String.valueOf(resultSet.getDate("FECHA_INICIO"));
						String fechafin = String.valueOf(resultSet.getDate("FECHA_FIN"));
						String fechapresu = String.valueOf(resultSet.getDate("FECHA_PRESUPUESTO"));
						int cantidadhoras = resultSet.getInt("CANTIDAD_HORAS");
						String estadoA = resultSet.getString("ESTADO");
						String causaA = resultSet.getString("CAUSA");
						float presu = resultSet.getFloat("PRESUPUESTO");

						txt_NServicio.setText(Integer.toString(numeroServicio));
						txtCliente.setText(cedulaCliente);
						txtFechaInicio.setText(fechainicio);
						txtFechaFin.setText(fechafin);
						txtFecha_Presupuesto.setText(fechapresu);
						txtCantHoras.setText(String.valueOf(cantidadhoras));
						// cmb_Estado.

						txt_Causa.setText(causaA);

						txtPresupuesto.setText(Float.toString(presu));
					}

					// Cerramos el acceso a las consultas
					statement.close();
					// Cerramos la conexion con la base de datos por seguridad
					connect.close();
					// Se cierran en orden inverso a como fueron creados

				} catch (Exception e) {

					System.out.println("Error base de datos".equals(e));

				}
			}

		});
		btnBuscar.setBackground(new Color(153, 204, 153));
		btnBuscar.setBounds(628, 290, 235, 25);
		panel.add(btnBuscar);

		cmb_Estado.addItem("Seleccionar");
		cmb_Estado.addItem("En curso");
		cmb_Estado.addItem("Finalizado");
		cmb_Estado.setBackground(Color.WHITE);
		cmb_Estado.setBounds(185, 289, 165, 27);
		panel.add(cmb_Estado);

		JLabel lbl_Estado = new JLabel("Estado");
		lbl_Estado.setBounds(185, 268, 165, 15);
		panel.add(lbl_Estado);

		JLabel lbl_NuevoServ = new JLabel("Buscar Codigo");
		lbl_NuevoServ.setBounds(630, 268, 233, 15);
		panel.add(lbl_NuevoServ);

		JLabel lblTecnico = new JLabel("Tecnico");
		lblTecnico.setBounds(417, 184, 132, 15);
		panel.add(lblTecnico);

		JButton btn_Ingresar = new JButton("Ingresar");
		btn_Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * ******************************************************** INSERTAR NUEVO
				 * REGISTRO (ALTA)
				 *********************************************************/

				while (txt_NServicio.getText().equals("") || txtCliente.getText().equals("")
						|| txtFechaInicio.getText().equals("") || txtFechaFin.getText().equals("")
						|| txtFecha_Presupuesto.getText().equals("") || txtCantHoras.getText().equals("")
						|| txtPresupuesto.getText().equals("") || txt_Causa.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;

				}

				if (conteo != 1) {

					nServicio = Integer.parseInt(txt_NServicio.getText());
					cICliente = txtCliente.getText();
					// nTecnico=(int) (cmbTecnico.getSelectedItem());
					fechaInicio = (txtFechaInicio.getText());
					FechaFin = (txtFechaFin.getText());
					fechaPresu = (txtFecha_Presupuesto.getText());
					cantHoras = Integer.parseInt(txtCantHoras.getText());
					estado = (String) cmb_Estado.getSelectedItem();
					// tServicio=(String) cmbTServicio.getSelectedItem();
					presupuesto = Float.parseFloat(txtPresupuesto.getText());
					causa = txt_Causa.getText();

					L_Solicitar ls = new L_Solicitar(nServicio, cICliente, fechaInicio, FechaFin, fechaPresu, cantHoras,
							estado, causa, presupuesto);

					if (!ls.nServicioVacio(ls.getnServicio()) && !ls.ciClienteVacio(ls.getcICliente())) {

						d_Solicitar ds = new d_Solicitar(nServicio, cICliente, fechaInicio, FechaFin, fechaPresu,
								cantHoras, estado, causa, presupuesto);

						if (ds.nuevoRegistro(ds.getNumServicio(), ds.getCiCliente(), ds.getFehcaInicio(),
								ds.getFechaFin(), ds.getFechaPresu(), ds.getCantHoras(), ds.getEstado(), ds.getCausa(),
								ds.getPresupuesto())) {

							JOptionPane.showMessageDialog(null, "Registro guardado con exito.", "ALTA",
									JOptionPane.INFORMATION_MESSAGE);
							limpiarCajas();

						} else {
							JOptionPane.showMessageDialog(null, "Ups! No se pudo guardar :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);

						}
					}
				} else {

					JOptionPane.showMessageDialog(null, "Ingrese datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btn_Ingresar.setBackground(Color.ORANGE);
		btn_Ingresar.setBounds(29, 550, 119, 25);
		panel.add(btn_Ingresar);

		JLabel lblCausa = new JLabel("Causa");
		lblCausa.setBounds(24, 322, 132, 15);
		panel.add(lblCausa);

		txtPresupuesto = new JTextField();
		txtPresupuesto.setColumns(10);
		txtPresupuesto.setBounds(717, 385, 144, 24);
		panel.add(txtPresupuesto);

		JLabel lblPresupuesto = new JLabel(" Presupuesto $");
		lblPresupuesto.setBounds(594, 389, 124, 15);
		panel.add(lblPresupuesto);

		JLabel lblCantidadDeHoras = new JLabel("Cantidad de Horas");
		lblCantidadDeHoras.setBounds(24, 268, 132, 15);
		panel.add(lblCantidadDeHoras);

		txtCantHoras = new JTextField();
		txtCantHoras.setColumns(10);
		txtCantHoras.setBounds(24, 292, 124, 24);
		panel.add(txtCantHoras);

		JLabel lblFechaPresupuesto = new JLabel("Fecha P");
		lblFechaPresupuesto.setBounds(786, 164, 64, 15);
		panel.add(lblFechaPresupuesto);

		txtFecha_Presupuesto = new JTextField();
		txtFecha_Presupuesto.setColumns(10);
		txtFecha_Presupuesto.setBounds(784, 214, 79, 24);
		panel.add(txtFecha_Presupuesto);

		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(676, 214, 79, 24);
		panel.add(txtFechaFin);

		JLabel lblFecha_Fin = new JLabel("Fin");
		lblFecha_Fin.setBounds(703, 164, 132, 15);
		panel.add(lblFecha_Fin);

		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(575, 213, 79, 25);
		panel.add(txtFechaInicio);

		JLabel lblFecha_Inicio = new JLabel("Inicio");
		lblFecha_Inicio.setBounds(586, 164, 64, 15);
		panel.add(lblFecha_Inicio);

		JLabel lblTipoDeSrvicio = new JLabel("Tipo de Servicio");
		lblTipoDeSrvicio.setBounds(381, 268, 165, 15);
		panel.add(lblTipoDeSrvicio);

		txt_NServicio = new JTextField();
		txt_NServicio.setBounds(45, 214, 103, 24);
		panel.add(txt_NServicio);
		txt_NServicio.setColumns(10);

		JLabel lblN = new JLabel("N° Servicio");
		lblN.setBounds(24, 190, 132, 15);
		panel.add(lblN);

		JLabel lblSolicitudDeService = new JLabel("Solicitud de Service");
		lblSolicitudDeService.setForeground(Color.WHITE);
		lblSolicitudDeService.setFont(new Font("Dialog", Font.BOLD, 17));
		lblSolicitudDeService.setBounds(24, 57, 326, 51);
		panel.add(lblSolicitudDeService);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 900, 610);
		lblNewLabel.setIcon(new ImageIcon(Solicitar.class.getResource("/Imagenes/Insumos.png")));
		panel.add(lblNewLabel);
	}
}
