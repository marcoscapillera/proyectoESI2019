package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Datos.d_Insumo;

import Datos.d_cliente;
import Logica.L_Cliente;
import Logica.L_Insumos;
import Logica.L_Persona;


import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ApPat_Cli;
	private JTextField txt_NombreCli;
	private JTextField txt_ApeMat_Cli;
	private JTextField txt_NoPuerta;
	private JTextField txt_CI;
	private JTextField txt_Calle_Cli;
	private JTextField txt_Telefono_Cli;
	private final JPanel panelTable = new JPanel();
	
	
	//atributos de cliente
		private String CI;
		private String nombre;
		private String apellido_paterno;
		private String apellido_materno;
		private String calle;
		private String numero_puerta;
		private String telefono;
		private String localidad;
	
	L_Cliente objCliente;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					//frame.setUndecorated(true);
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
	public Cliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 636);
		this.setSize(900,636);
		contentPane = new JPanel();
		setTitle("Cliente");
		
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 900, 636);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 900, 610);
		panel.add(panel_1);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBackground(new Color(255, 105, 180));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPerfil.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Perfil ventperfil = new Perfil();
						ventperfil.setVisible(true);
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						dispose();
					}
				});
			}
		});
		
		table = new JTable();
		table.setBackground(SystemColor.window);
		table.setBounds(29, 381, 696, 140);
		panel_1.add(table);
		
		//Casillero localidad
		JComboBox cmbLocalidad = new JComboBox();
		cmbLocalidad.setBackground(Color.WHITE);
		cmbLocalidad.setBounds(297, 290, 256, 24);
		panel_1.add(cmbLocalidad);
		cmbLocalidad.addItem("Seleccione una Localidad");
		cmbLocalidad.addItem("Salto");
		cmbLocalidad.addItem("Tacuarembo");
		cmbLocalidad.addItem("Rivera");
		cmbLocalidad.addItem("Paysandu");
		cmbLocalidad.addItem("Durazno");
		cmbLocalidad.addItem("Colonia");
		cmbLocalidad.addItem("San Jose");
		cmbLocalidad.addItem("Flores");
		cmbLocalidad.addItem("Florida");
		cmbLocalidad.addItem("Lavalleja");
		cmbLocalidad.addItem("Maldonado");
		cmbLocalidad.addItem("Rocha");
		cmbLocalidad.addItem("Treinta y Tres");
		cmbLocalidad.addItem("Rio Negro");
		cmbLocalidad.addItem("Cerro Largo");
		cmbLocalidad.addItem("Montevideo");
		cmbLocalidad.addItem("Soriano");
		cmbLocalidad.addItem("Canelones");
		cmbLocalidad.addItem("Artigas");
		
	
		JLabel lblIngreseUnPerfil = new JLabel("Ingrese un Perfil para Cliente");
		lblIngreseUnPerfil.setBounds(620, 261, 221, 15);
		panel_1.add(lblIngreseUnPerfil);
		btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPerfil.setBounds(662, 304, 89, 25);
		panel_1.add(btnPerfil);
		
		JButton btn_Mostrar = new JButton("Limpiar");
		btn_Mostrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				panelTable.setBounds(29, 390, 838, 150);
				
				panel.add(panelTable);
				panelTable.setLayout(null);
				DefaultTableModel modelo = new DefaultTableModel();		
				modelo.addColumn("Cedula Identidad");
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido Paterno");
				modelo.addColumn("Apellido Materno");
				modelo.addColumn("Calle");
				modelo.addColumn("Localidad");
				modelo.addColumn("Numero");
				modelo.addColumn("Telefono");
			
				JTable tabla = new JTable(modelo);		
				tabla.setBackground(Color.WHITE);
				tabla.setBounds(0, 0, 847, 300);
				panelTable.add(tabla);
				JScrollPane scroll = new JScrollPane(tabla,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setBounds(0, 0, 836, 150);
				panelTable.add(scroll);
				
				
				
				
				
			}
		});
		// alta
		btn_Mostrar.setBackground(Color.ORANGE);
		btn_Mostrar.setBounds(599, 555, 143, 25);
		panel_1.add(btn_Mostrar);
		
		JButton btn_Ingresar = new JButton("Insertar");
		btn_Ingresar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				

				 CI = (txt_CI.getText());
				nombre = txt_NombreCli.getText();
				apellido_paterno =  txt_ApPat_Cli.getText();
				apellido_materno =  txt_ApeMat_Cli.getText();
				calle = txt_Calle_Cli.getText();
				localidad = (String) cmbLocalidad.getSelectedItem();
				numero_puerta = txt_NoPuerta.getText();
				telefono = txt_Telefono_Cli.getText();
				//alta
			    L_Persona lp = new L_Persona(CI, nombre, apellido_paterno, apellido_materno, calle, localidad, numero_puerta, telefono);
				
				
				
				// Valida si el campo nombre y numero de insumos estan vacios.
				if (!lp.idVacio(lp.getCI())) {

					// Si no estan vacios se crea un objeto de la clase d_cliente para enviar los
					// datos a la BDD
					d_cliente dc = new d_cliente("jdbc:mysql://localhost/MantenimientoInformatico", "root", "",CI, nombre, apellido_paterno, apellido_materno, calle, localidad, numero_puerta, telefono);
					dc.getConnection();

					// Se invoca el metodo de alta registro de la clase datos clientes
					if (dc.nuevoRegistro(dc.getCI(), dc.getNombre(), dc.getApPat(), dc.getApeMat(), dc.getCalle(), dc.getNumero_Puerta(), dc.getTelefono(), dc.getLocalidad(), dc.getStatement())) {

						JOptionPane.showMessageDialog(null, "Registro guardado con �xito.", "ALTA", JOptionPane.INFORMATION_MESSAGE);
						/*
						//actualizar jtable
						Object[][] registros;
					    String[] columnas = {"CI", "Nombre", "Apellido_Paterno", "Apellido_Matern", "Calle", "Numero", "Localidado"};
					    registros = dc.listarPersonas(dc.getConnection(), dc.getStatement());	    
					    DefaultTableModel datos = new DefaultTableModel(registros,columnas);
					    table.setModel(datos);
					    */
						
					}else {
						JOptionPane.showMessageDialog(null, "Ups! No se pudo ingresar :(", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				}else {
					JOptionPane.showMessageDialog(null, "Ups! Debe completar todos los campos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			
				
			}				
		});
		btn_Ingresar.setBackground(Color.ORANGE);
		btn_Ingresar.setBounds(72, 555, 143, 25);
		panel_1.add(btn_Ingresar);
		//eliminar
		
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				 // ELIMINAR
				/* 
              int CI = Integer.parseInt(txt_CI.getText());
				
				L_Cliente lc = new L_Cliente(CI);			
				
				if(!lc.idVacio(lc.getCI())) {
				
					d_cliente dc = new d_cliente("jdbc:mysql://localhost/", "root", "", "jdbcjava", CI);
					dc.getConnection();
					
					if(dc.eliminarRegistro(dc.getCli_CI(), dc.getStatement())) {						
						
						JOptionPane.showMessageDialog(null, "Registro elimiando con �xito.", "ELIMINAR", JOptionPane.INFORMATION_MESSAGE);
						txt_CI.setText("0");
						txt_NombreCli.setText("");	
						// actualizar jtable
						Object[][] registros;
					    String[] columnas = {"CI","Nombre"};
					    registros = dc.listarClientes(dc.getConnection(), dc.getStatement());	    
					    DefaultTableModel datos = new DefaultTableModel(registros,columnas);
					    table.setModel(datos);
					}else {						
						JOptionPane.showMessageDialog(null, "Ups! No se pudo eliminar :(", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}else {					
					JOptionPane.showMessageDialog(null, "Ups! Debe ingresar ID a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);					
				}
				

*/
			}
		});
		
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(244, 555, 143, 25);
		panel_1.add(btnNewButton);
		
		txt_ApPat_Cli = new JTextField();
		txt_ApPat_Cli.setColumns(10);
		txt_ApPat_Cli.setBounds(29, 234, 256, 25);
		panel_1.add(txt_ApPat_Cli);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//modificar
				
/*
				int CI = Integer.parseInt(txt_CI.getText());
				String Nombre = txt_NombreCli.getText();
				L_Cliente lc = new L_Cliente(CI, Nombre);			
				
				if(!lc.nombreVacio(lc.getNombre()) && !lc.idVacio(lc.getCI())) {
					
					d_cliente dc = new d_cliente("jdbc:mysql://localhost/", "root", "", "jdbcjava", CI, nombre);
					dc.getConnection();
					
					if(dc.modificarRegistro(dc.getCli_CI(), dc.getCli_Nombre(), dc.getStatement())) {						
						
						JOptionPane.showMessageDialog(null, "Registro modificado con �xito.", "MODIFICAR", JOptionPane.INFORMATION_MESSAGE);
						txt_CI.setText("0");
						txt_NombreCli.setText("");		
						//jtable actualizacion
						Object[][] registros;
					    String[] columnas = {"CI","Nombre"};
					    registros = dc.listarClientes(dc.getConnection(), dc.getStatement());	    
					    DefaultTableModel datos = new DefaultTableModel(registros,columnas);
					    table.setModel(datos);
					}else {						
						JOptionPane.showMessageDialog(null, "Ups! No se pudo modificar :(", "ERROR", JOptionPane.ERROR_MESSAGE);
					}	
					
				}else {					
					JOptionPane.showMessageDialog(null, "Ups! Debe completar todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);					
				}
				*/
			}
		});
		btnModificar.setBackground(Color.ORANGE);
		btnModificar.setBounds(410, 555, 143, 25);
		panel_1.add(btnModificar);
		
		txt_NombreCli = new JTextField();
		txt_NombreCli.setColumns(10);
		txt_NombreCli.setBounds(297, 178, 256, 25);
		panel_1.add(txt_NombreCli);
		
		JComboBox cmb_Tipo_Cliente = new JComboBox();
		cmb_Tipo_Cliente.addItem("seleccione una opcion");
		cmb_Tipo_Cliente.addItem("Empresa");
		cmb_Tipo_Cliente.addItem("Individuo");
		cmb_Tipo_Cliente.setBackground(Color.WHITE);
		cmb_Tipo_Cliente.setBounds(599, 178, 212, 25);
		panel_1.add(cmb_Tipo_Cliente);
		
		txt_ApeMat_Cli = new JTextField();
		txt_ApeMat_Cli.setColumns(10);
		txt_ApeMat_Cli.setBounds(297, 234, 256, 25);
		panel_1.add(txt_ApeMat_Cli);
		
		txt_NoPuerta = new JTextField();
		txt_NoPuerta.setColumns(10);
		txt_NoPuerta.setBounds(32, 338, 253, 25);
		panel_1.add(txt_NoPuerta);
		
		txt_CI = new JTextField();
		txt_CI.setColumns(10);
		txt_CI.setBounds(29, 179, 256, 25);
		panel_1.add(txt_CI);
		
		txt_Calle_Cli = new JTextField();
		txt_Calle_Cli.setBounds(32, 290, 253, 25);
		panel_1.add(txt_Calle_Cli);
		txt_Calle_Cli.setColumns(10);
		
		txt_Telefono_Cli = new JTextField();
		txt_Telefono_Cli.setBounds(297, 340, 258, 23);
		panel_1.add(txt_Telefono_Cli);
		txt_Telefono_Cli.setColumns(10);
		
		JLabel label_1 = new JLabel("Tipo");
		label_1.setBounds(601, 151, 66, 15);
		panel_1.add(label_1);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(29, 216, 166, 15);
		panel_1.add(lblApellidoPaterno);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(297, 160, 66, 15);
		panel_1.add(lblNombre);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(297, 215, 136, 15);
		panel_1.add(lblApellidoMaterno);
		
		JLabel lblNewLabel = new JLabel("Calle");
		lblNewLabel.setBounds(29, 268, 90, 19);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(294, 320, 74, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(32, 320, 66, 15);
		panel_1.add(lblNumero);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad");
		lblNewLabel_1.setBounds(297, 270, 160, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblCi = new JLabel("C.I");
		lblCi.setBounds(29, 160, 66, 15);
		panel_1.add(lblCi);
		
		JLabel lblPersonas = new JLabel("Clientes");
		lblPersonas.setForeground(Color.WHITE);
		lblPersonas.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPersonas.setBounds(29, 40, 256, 56);
		panel_1.add(lblPersonas);
		
		JLabel label_8 = new JLabel("");
		label_8.setBackground(Color.BLUE);
		label_8.setForeground(Color.WHITE);
		label_8.setIcon(new ImageIcon(Cliente.class.getResource("/Imagenes/Insumos.png")));
		label_8.setBounds(0, 0, 900, 607);
		panel_1.add(label_8);
	}
}
	
