package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import Datos.JDBC_MySQL;
import Datos.d_Insumo;
import Logica.L_Insumos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Insumos extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel lblInsumos = new JLabel("Insumos");
	private final JLabel lblCodigo = new JLabel("Codigo");
	private final JLabel lblNewLabel = new JLabel("Nombre");
	private final JLabel lblDescripcion = new JLabel("Descripcion");
	private final JLabel lblCantidad = new JLabel("Cantidad");
	private final JLabel lblPrecio = new JLabel("Precio");
	private final JLabel lblTipo = new JLabel("Tipo");
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDescr;
	private final JLabel lblSoft = new JLabel("Software");
	private final JComboBox cmbSoft = new JComboBox();
	private final JTextField txtCantidad = new JTextField();
	private final JTextField txtPrecio = new JTextField();
	private JComboBox cmcTipoIns = new JComboBox();

	// Atributos de Insumos
	private int ins_Codigo;
	private String ins_Codigo_Buscar;
	private String ins_Nombre = "";
	private String ins_Tipo = "";
	private String ins_Soft = "";
	private int ins_Cantidad = 0;
	private float ins_Precio = 0.00f;
	private String ins_Desc = "";

	java.sql.PreparedStatement ps;
	ResultSet rs;

	// Objeto
	L_Insumos objInsumos;

	private JTable tableInsumos;

	private final JButton btnEliminar = new JButton("Eliminar");
	private final JButton btn_Limpiar = new JButton("Limpiar");
	private JTextField txtBuscarIns;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insumos frame = new Insumos();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Metodo para limpiar las cajas(Boton LIMPIAR)
	private void limpiarCajas() {
		txtBuscarIns.setText(null);
		txtCodigo.setText(null);
		txtNombre.setText(null);
		cmcTipoIns.setSelectedIndex(0);
		cmbSoft.setSelectedIndex(0);
		txtCantidad.setText(null);
		txtPrecio.setText(null);
		txtDescr.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public Insumos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 636);
		setTitle("Insumos");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tableInsumos = new JTable();
		tableInsumos.setBounds(33, 344, 831, 183);

		// Listando INSUMOS EN JTABLE
		contentPane.add(tableInsumos);

		JScrollPane scroll_1 = new JScrollPane(tableInsumos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll_1.setBounds(33, 344, 831, 183);
		contentPane.add(scroll_1);

		JPanel pnlTable = new JPanel();
		pnlTable.setBounds(33, 344, 831, 183);
		contentPane.add(pnlTable);

		panel.setBounds(0, 0, 900, 606);
		contentPane.add(panel);
		panel.setLayout(null);

		/*
		 * ******************************************************* Creamos objeto de la
		 * clase d_Insumos() para poder invocar al m�todo que listar� los insumos en el
		 * JTable. Luego creamos un nuevo m�todo para ser invocado
		 *********************************************************/

		d_Insumo cx = new d_Insumo();

		Object[][] registros;

		String[] columnas = { "N_INSUMO", "NOMBRE_INSUMO", "CANTIDAD_STOCK", "DESCRIPCION", "PRECIO" };

		registros = cx.listarInsumos();
		DefaultTableModel datos = new DefaultTableModel(registros, columnas);
		tableInsumos.setModel(datos);

		JButton btn_Modificar = new JButton("Modificar");
		btn_Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * ******************************************************** EDITAR REGISTRO
				 * (MODIFICACION)
				 *********************************************************/

				//////////////////////////
				// *VALIDACIONES/////////
				/////////////////////////

				int conteo = 0;

				while (txtCodigo.getText().equals("") || txtNombre.getText().equals("")
						|| cmcTipoIns.getSelectedItem().equals("") || cmbSoft.getSelectedItem().equals("")
						|| txtCantidad.getText().equals("") || txtPrecio.getText().equals("")
						|| txtDescr.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;

				}

				if (conteo != 1) {

					if ((!txtCodigo.getText().matches("^[0-9]+$")) || (!txtCantidad.getText().matches("^[0-9]+$"))
							|| (!txtPrecio.getText().matches("[-+]?[0-9]*\\.?[0-9]+"))) {
						JOptionPane.showMessageDialog(null, " Revise los campos numericos!!!!! ");

					} else if (!txtCodigo.getText().equals("") || !txtNombre.getText().equals("")
							|| !cmcTipoIns.getSelectedItem().equals("") || !cmbSoft.getSelectedItem().equals("")
							|| !txtCantidad.getText().equals("") || !txtPrecio.getText().equals("")
							|| !txtDescr.getText().equals("")) {

						int codMayorCero = Integer.parseInt(txtCodigo.getText());
						int cantMayorCero = Integer.parseInt(txtCantidad.getText());
						float precioNoNegativo = Float.parseFloat(txtPrecio.getText());

						while (codMayorCero <= 0) {
							JOptionPane.showMessageDialog(null, "Codigo no puede ser cero o negativo :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
							break;
						}

						while (cantMayorCero <= 0) {
							JOptionPane.showMessageDialog(null, "Cantidad no puede ser cero o negativo :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
							break;
						}

						while (precioNoNegativo < 0) {
							JOptionPane.showMessageDialog(null, "Precio no puede ser  negativo :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
							break;
						}

						while (!txtCodigo.getText().equals("")) {

							// Fin de las validaciones
							try {

								if (Integer.parseInt(txtCodigo.getText()) > 0) {

									// Fin de las validaciones

									// Se guarda dentro de una variable las cajas

									ins_Codigo = Integer.parseInt(txtCodigo.getText());
									ins_Nombre = txtNombre.getText();
									ins_Tipo = (String) cmcTipoIns.getSelectedItem();
									ins_Soft = (String) cmbSoft.getSelectedItem();
									ins_Cantidad = Integer.parseInt(txtCantidad.getText());
									ins_Precio = Float.parseFloat(txtPrecio.getText());
									ins_Desc = txtDescr.getText();

									// Se crea un objeto de insumos y se envia al constructor
									objInsumos = new L_Insumos(ins_Codigo, ins_Nombre, ins_Cantidad, ins_Desc,
											ins_Precio);

									// Valida si el campo nombre y numero de insumos estan vacios.
									if (!objInsumos.nombreVacio(objInsumos.getIns_Nombre())
											&& !objInsumos.idVacio(objInsumos.getIns_Codigo())) {

										// Si no estan vacios se crea un objeto de la clase d_insumo para enviar los
										// datos a la BDD
										d_Insumo di = new d_Insumo("jdbc:mysql://localhost/MantenimientoInformatico",
												"root", "", ins_Codigo, ins_Nombre, ins_Cantidad, ins_Desc, ins_Precio);
										di.getConnection();

										// Se invoca el metodo modificar registro de la clase datos insumos
										if (di.modificarRegistro(di.getIns_Codigo(), di.getIns_Nombre(),
												di.getIns_Cantidad(), di.getIns_Desc(), di.getIns_Precio(),
												di.getStatement())) {

											JOptionPane.showMessageDialog(null, "Registro modificado con exito.",
													"MODIFICAR", JOptionPane.INFORMATION_MESSAGE);
											limpiarCajas();

											// Actualiza Tabla
											Object[][] registros;

											String[] columnas = { "N_INSUMO", "NOMBRE_INSUMO", "CANTIDAD_STOCK",
													"DESCRIPCION", "PRECIO" };

											registros = di.listarInsumos();
											DefaultTableModel datos = new DefaultTableModel(registros, columnas);

											tableInsumos = new JTable();
											tableInsumos.setBounds(33, 344, 831, 183);

											contentPane.add(tableInsumos);

											JScrollPane scroll = new JScrollPane(tableInsumos,
													ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
													ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
											scroll.setBounds(33, 344, 831, 183);
											contentPane.add(scroll);
											tableInsumos.setModel(datos);
										} else {
											JOptionPane.showMessageDialog(null, "Ups! No se pudo modificar :(", "ERROR",
													JOptionPane.ERROR_MESSAGE);
										}

									} else {
										JOptionPane.showMessageDialog(null, "Ups! Debe completar todos los campos",
												"ERROR", JOptionPane.ERROR_MESSAGE);
									}
								}

							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				} else {

					JOptionPane.showMessageDialog(null, "Ingrese datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {
			// Buscar en la base de datos-
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * ******************************************************** BUSCAR REGISTRO
				 * (CONSULTA)
				 *********************************************************/
				// Se guarda en una variable el contenido de la caja buscar
				ins_Codigo_Buscar = txtBuscarIns.getText();

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

					// executeQuery() solo permite realizar consultas de recuperacion: SELECT..

					// Realiza la busqueda del codigo ingresado en la tabla insumo
					resultSet = statement.executeQuery("SELECT * FROM INSUMO WHERE N_INSUMO=" + ins_Codigo_Buscar);

					// executeUpdate() permite realizar consultas unicamente de modificacion

					// Se procesa el resultado

					// Si encuentra el codigo, todos los demas campos se autocompletan
					while (resultSet.next()) {

						int cod = resultSet.getInt("N_INSUMO");
						String nombreCodigo = resultSet.getString("NOMBRE_INSUMO");
						int cantidad = resultSet.getInt("CANTIDAD_STOCK");
						String descripcion = resultSet.getString("DESCRIPCION");
						float precio = resultSet.getFloat("PRECIO");
						txtCodigo.setText(Integer.toString(cod));
						txtNombre.setText(nombreCodigo);
						txtCantidad.setText(Integer.toString(cantidad));
						txtPrecio.setText(Float.toString(precio));
						txtDescr.setText(descripcion);

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

		btn_Buscar.setForeground(Color.BLACK);
		btn_Buscar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_Buscar.setBackground(new Color(255, 102, 153));
		btn_Buscar.setBounds(748, 307, 114, 25);
		panel.add(btn_Buscar);

		JLabel lbl_iconSearch = new JLabel("");
		lbl_iconSearch.setIcon(new ImageIcon(Insumos.class.getResource("/Presentacion/buscar.png")));
		lbl_iconSearch.setBounds(659, 270, 20, 20);
		panel.add(lbl_iconSearch);

		txtBuscarIns = new JTextField();
		txtBuscarIns.setHorizontalAlignment(SwingConstants.LEFT);
		txtBuscarIns.setColumns(10);
		txtBuscarIns.setBounds(684, 270, 183, 25);
		panel.add(txtBuscarIns);
		btn_Limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCajas();
			}
		});
		btn_Limpiar.setForeground(Color.BLACK);
		btn_Limpiar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_Limpiar.setBackground(Color.ORANGE);
		btn_Limpiar.setBounds(738, 556, 124, 25);

		panel.add(btn_Limpiar);

		btnEliminar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				/*
				 * ******************************************************** ELIMINAR REGISTRO
				 * (ELIMINAR)
				 *********************************************************/

				int conteo = 0;

				while (txtCodigo.getText().equals("") || txtNombre.getText().equals("")
						|| cmcTipoIns.getSelectedItem().equals("") || cmbSoft.getSelectedItem().equals("")
						|| txtCantidad.getText().equals("") || txtPrecio.getText().equals("")
						|| txtDescr.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;

				}

				if (conteo != 1) {

					if ((!txtCodigo.getText().matches("^[0-9]+$")) || (!txtCantidad.getText().matches("^[0-9]+$"))
							|| (!txtPrecio.getText().matches("[-+]?[0-9]*\\.?[0-9]+"))) {
						JOptionPane.showMessageDialog(null, " Revise los campos numericos!!!!! ");

					} else if (!txtCodigo.getText().equals("") || !txtNombre.getText().equals("")
							|| !cmcTipoIns.getSelectedItem().equals("") || !cmbSoft.getSelectedItem().equals("")
							|| !txtCantidad.getText().equals("") || !txtPrecio.getText().equals("")
							|| !txtDescr.getText().equals("")) {

						int codMayorCero = Integer.parseInt(txtCodigo.getText());
						int cantMayorCero = Integer.parseInt(txtCantidad.getText());
						float precioNoNegativo = Float.parseFloat(txtPrecio.getText());

						while (codMayorCero <= 0) {
							JOptionPane.showMessageDialog(null, "Codigo no puede ser cero o negativo :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
							break;
						}

						while (cantMayorCero <= 0) {
							JOptionPane.showMessageDialog(null, "Cantidad no puede ser cero o negativo :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
							break;
						}

						while (precioNoNegativo < 0) {
							JOptionPane.showMessageDialog(null, "Precio no puede ser  negativo :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
							break;
						}

						while (!txtCodigo.getText().equals("")) {

							ins_Codigo = Integer.parseInt(txtCodigo.getText());

							L_Insumos li = new L_Insumos(ins_Codigo);

							try {
								// create the mysql database connection
								String myDriver = "com.mysql.jdbc.Driver";

								Class.forName(myDriver);
								java.sql.Connection conn = DriverManager
										.getConnection("jdbc:mysql://localhost/MantenimientoInformatico", "root", "");

								String query = "delete from INSUMO where N_INSUMO = ?";
								java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
								preparedStmt.setInt(1, Integer.parseInt(txtCodigo.getText()));

								// execute the preparedstatement
								preparedStmt.execute();
								JOptionPane.showMessageDialog(null, "Registro elimiando con exito.", "ELIMINAR",
										JOptionPane.INFORMATION_MESSAGE);
								limpiarCajas();

								conn.close();
							} catch (Exception e) {
								System.err.println("Got an exception! ");
								System.err.println(e.getMessage());
							}

						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEliminar.setBackground(Color.ORANGE);
		btnEliminar.setBounds(486, 556, 124, 25);

		panel.add(btnEliminar);

		// Codigo Boton redondeado
		JButton btn_Ingresar = new JButton("Insertar");
		btn_Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		// Evento insertar
		btn_Ingresar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				/*
				 * ******************************************************** INSERTAR NUEVO
				 * REGISTRO (ALTA)
				 *********************************************************/

				//////////////////////////
				// *VALIDACIONES/////////
				/////////////////////////

				int conteo = 0;

				while (txtCodigo.getText().equals("") || txtNombre.getText().equals("")
						|| cmcTipoIns.getSelectedItem().equals("") || cmbSoft.getSelectedItem().equals("")
						|| txtCantidad.getText().equals("") || txtPrecio.getText().equals("")
						|| txtDescr.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
					conteo = 1;
					break;

				}

				if (conteo != 1) {

					if ((!txtCodigo.getText().matches("^[0-9]+$")) || (!txtCantidad.getText().matches("^[0-9]+$"))
							|| (!txtPrecio.getText().matches("[-+]?[0-9]*\\.?[0-9]+"))) {
						JOptionPane.showMessageDialog(null, " Revise los campos numericos!!!!! ");

					} else if (!txtCodigo.getText().equals("") || !txtNombre.getText().equals("")
							|| !cmcTipoIns.getSelectedItem().equals("") || !cmbSoft.getSelectedItem().equals("")
							|| !txtCantidad.getText().equals("") || !txtPrecio.getText().equals("")
							|| !txtDescr.getText().equals("")) {

						int codMayorCero = Integer.parseInt(txtCodigo.getText());
						int cantMayorCero = Integer.parseInt(txtCantidad.getText());
						float precioNoNegativo = Float.parseFloat(txtPrecio.getText());

						while (codMayorCero <= 0) {
							JOptionPane.showMessageDialog(null, "Codigo no puede ser cero o negativo :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
							break;
						}

						while (cantMayorCero <= 0) {
							JOptionPane.showMessageDialog(null, "Cantidad no puede ser cero o negativo :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
							break;
						}

						while (precioNoNegativo < 0) {
							JOptionPane.showMessageDialog(null, "Precio no puede ser  negativo :(", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							limpiarCajas();
							break;
						}

						while (!txtCodigo.getText().equals("")) {

							// Fin de las validaciones
							try {
								if (Integer.parseInt(txtCodigo.getText()) > 0) {

									ins_Codigo = Integer.parseInt(txtCodigo.getText());
									ins_Nombre = txtNombre.getText();
									ins_Tipo = (String) cmcTipoIns.getSelectedItem();
									ins_Soft = (String) cmbSoft.getSelectedItem();
									ins_Cantidad = Integer.parseInt(txtCantidad.getText());
									ins_Precio = Float.parseFloat(txtPrecio.getText());
									ins_Desc = txtDescr.getText();

									objInsumos = new L_Insumos(ins_Codigo, ins_Nombre, ins_Cantidad, ins_Desc,
											ins_Precio);

									if (!objInsumos.nombreVacio(objInsumos.getIns_Nombre())) {

										d_Insumo di = new d_Insumo("jdbc:mysql://localhost/MantenimientoInformatico",
												"root", "", ins_Codigo, ins_Nombre, ins_Cantidad, ins_Desc, ins_Precio);
										di.getConnection();

										if (di.nuevoRegistro(di.getIns_Codigo(), di.getIns_Nombre(),
												di.getIns_Cantidad(), di.getIns_Desc(), di.getIns_Precio(),
												di.getStatement())) {

											JOptionPane.showMessageDialog(null, "Registro guardado con exito.", "ALTA",
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

								}
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "", "ERROR", JOptionPane.ERROR_MESSAGE);

							}
						}
					}

				}
				JOptionPane.showMessageDialog(null, "Ingrese datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});

		// Estilo del boton insertar
		btn_Ingresar.setBounds(29, 556, 124, 25);
		btn_Ingresar.setBackground(Color.ORANGE);
		panel.add(btn_Ingresar);
		btn_Ingresar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_Ingresar.setForeground(Color.black);
		btn_Modificar.setBounds(268, 556, 114, 25);
		btn_Modificar.setFont(new Font("Dialog", Font.BOLD, 12));
		btn_Modificar.setBackground(Color.ORANGE);
		btn_Modificar.setForeground(Color.black);

		panel.add(btn_Modificar);

		txtPrecio.setColumns(10);
		txtPrecio.setBounds(161, 234, 124, 25);

		panel.add(txtPrecio);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(29, 234, 114, 25);

		panel.add(txtCantidad);

		cmbSoft.setBackground(Color.WHITE);
		cmbSoft.setBounds(758, 178, 104, 24);
		cmbSoft.addItem("");
		cmbSoft.addItem("Gratis");
		cmbSoft.addItem("Pago");
		panel.add(cmbSoft);
		lblSoft.setBounds(762, 151, 66, 15);

		panel.add(lblSoft);

		cmcTipoIns.addItem("");
		cmcTipoIns.addItem("Hardware");
		cmcTipoIns.addItem("Software");
		cmcTipoIns.setBackground(Color.WHITE);
		cmcTipoIns.setBounds(593, 180, 114, 25);
		// Anulo borde de tipo
		cmcTipoIns.setBorder(null);
		panel.add(cmcTipoIns);

		txtDescr = new JTextField();
		txtDescr.setColumns(10);
		txtDescr.setBounds(301, 233, 566, 25);

		panel.add(txtDescr);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(312, 179, 238, 25);

		panel.add(txtNombre);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(29, 179, 256, 25);

		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		lblTipo.setBounds(593, 151, 66, 15);

		panel.add(lblTipo);
		lblPrecio.setBounds(162, 216, 66, 15);

		panel.add(lblPrecio);
		lblCantidad.setBounds(29, 216, 66, 15);

		panel.add(lblCantidad);
		lblDescripcion.setBounds(307, 216, 136, 15);

		panel.add(lblDescripcion);
		lblNewLabel.setBounds(316, 151, 66, 15);
		panel.add(lblNewLabel);
		lblCodigo.setBounds(29, 151, 66, 15);

		panel.add(lblCodigo);
		lblInsumos.setForeground(Color.WHITE);
		lblInsumos.setFont(new Font("Dialog", Font.BOLD, 17));
		lblInsumos.setBounds(72, 50, 190, 31);

		panel.add(lblInsumos);

		JLabel lblImagenInsumos = new JLabel("");
		lblImagenInsumos.setIcon(new ImageIcon(Insumos.class.getResource("/Imagenes/Insumos.png")));
		lblImagenInsumos.setBounds(0, 0, 900, 606);
		panel.add(lblImagenInsumos);

	}
}
