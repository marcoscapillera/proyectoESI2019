package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Datos.d_Insumo;
import Datos.d_Solicitar;
import Logica.L_Insumos;
import Logica.L_Solicitar;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;
import javax.swing.JTable;

public class MenuPpal extends JFrame {

	private JPanel contentPane;
	private final JLabel label = new JLabel("");
	private JPanel btn_Clientes;
	private JPanel btn_decCLientes;
	private JLabel lblClientes;
	private JLabel label_1;
	private JPanel btn_Insumos;
	private JPanel btn_decInsumos;
	private JLabel lblInsumos;
	private JPanel btn_Proveedor = new JPanel();
	private JPanel btn_Solicita = new JPanel();
	private JPanel btn_Tecnicos = new JPanel();
	private JTable tblListado;

	// Objeto
	L_Solicitar lSolicitar;
	private JTable tableSolicitar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPpal frame = new MenuPpal();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setColor(JPanel pane) {
		pane.setBackground(new Color(44, 21, 158));
	}

	private void resetColor(JPanel pane) {
		pane.setBackground(new Color(23, 12, 36));
	}

	/**
	 * Create the frame.
	 */
	public MenuPpal() {
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 636);

		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tableSolicitar = new JTable();
		tableSolicitar.setBounds(166, 177, 735, 223);

		// Listando INSUMOS EN JTABLE
		contentPane.add(tableSolicitar);

		JScrollPane scroll_1 = new JScrollPane(tableSolicitar, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll_1.setBounds(166, 177, 735, 223);
		contentPane.add(scroll_1);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 636);
		contentPane.add(panel);

		JPanel btn_Paquetes = new JPanel();
		btn_Paquetes.setBounds(0, 223, 165, 47);

		/*
		 * ******************************************************* Creamos objeto de la
		 * clase d_Insumos() para poder invocar al m�todo que listar� los insumos en el
		 * JTable. Luego creamos un nuevo m�todo para ser invocado
		 *********************************************************/

		d_Solicitar tb = new d_Solicitar();

		Object[][] registros;

		String[] columnas = { "N_SERVICIO", "CI", "FECHA_PRESUPUESTO", "FECHA_INICIO", "FECHA_FIN", "CANTIDAD_HORAS",
				"ESTADO", "CAUSA", "PRESUPUESTO" };

		//registros = tb.listarInsumos();
		//DefaultTableModel datos = new DefaultTableModel(registros, columnas);
		//tableSolicitar.setModel(datos);

		btn_Paquetes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				resetColor(btn_Paquetes); // Reseteo Color
				setColor(btn_Clientes);
				setColor(btn_Tecnicos);
				setColor(btn_Proveedor);
				setColor(btn_Insumos);
				setColor(btn_Solicita);
				Paquetes ventPaquetes = new Paquetes();
				ventPaquetes.setVisible(true);

			}
		});
		panel.setLayout(null);

		label_1 = new JLabel("X");
		label_1.setBounds(835, 12, 29, 33);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		LocalDate systemdate = LocalDate.now();

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(204, 102, 153));
		panel_7.setBounds(166, 107, 734, 25);
		panel.add(panel_7);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(102, 204, 153));
		panel_6.setBounds(166, 131, 734, 47);
		panel.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("LISTADO DE SERVICES");
		lblNewLabel_1.setBounds(245, 12, 266, 15);
		panel_6.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 400, 900, 260);
		panel_1.setBackground(new Color(44, 21, 158));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 153, 900, 13);
		panel_1.add(separator);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));

		panel.add(label_1);
		btn_Paquetes.setLayout(null);
		btn_Paquetes.setBackground(new Color(44, 21, 158));
		panel.add(btn_Paquetes);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(51, 102, 204));
		panel_5.setBounds(0, 0, 10, 47);
		btn_Paquetes.add(panel_5);

		JLabel lblPaquetes = new JLabel("         Paquetes");
		lblPaquetes.setForeground(Color.WHITE);
		lblPaquetes.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPaquetes.setBounds(12, 0, 153, 47);
		btn_Paquetes.add(lblPaquetes);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(MenuPpal.class.getResource("/Presentacion/paquetes.png")));
		label_3.setBounds(25, 12, 20, 20);
		btn_Paquetes.add(label_3);
		btn_Solicita.setBounds(0, 356, 165, 47);
		btn_Solicita.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Solicitar ventSolicita = new Solicitar();
				ventSolicita.setVisible(true);

				resetColor(btn_Solicita); // Reseteo Color
				setColor(btn_Clientes);
				setColor(btn_Paquetes);
				setColor(btn_Tecnicos);
				setColor(btn_Proveedor);
				setColor(btn_Insumos);

			}
		});

		btn_Solicita.setLayout(null);
		btn_Solicita.setBackground(new Color(44, 21, 158));
		panel.add(btn_Solicita);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 102, 204));
		panel_4.setBounds(0, 0, 10, 47);
		btn_Solicita.add(panel_4);

		JLabel lblSolicitar = new JLabel("         Solicitar");
		lblSolicitar.setForeground(Color.WHITE);
		lblSolicitar.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSolicitar.setBounds(12, 0, 153, 47);
		btn_Solicita.add(lblSolicitar);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(MenuPpal.class.getResource("/Presentacion/solicita.png")));
		label_4.setBounds(25, 12, 20, 20);
		btn_Solicita.add(label_4);
		btn_Proveedor.setBounds(0, 266, 165, 47);
		btn_Proveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Proveedor ventPaquetes = new Proveedor();
				ventPaquetes.setVisible(true);

				resetColor(btn_Proveedor); // Reseteo Color
				setColor(btn_Clientes);
				setColor(btn_Paquetes);
				setColor(btn_Tecnicos);
				setColor(btn_Insumos);
				setColor(btn_Solicita);

			}
		});

		btn_Proveedor.setLayout(null);
		btn_Proveedor.setBackground(new Color(44, 21, 158));
		panel.add(btn_Proveedor);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 102, 204));
		panel_3.setBounds(0, 0, 10, 47);
		btn_Proveedor.add(panel_3);

		JLabel lblProveedor = new JLabel("         Proveedor");
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Dialog", Font.BOLD, 15));
		lblProveedor.setBounds(12, 0, 153, 47);
		btn_Proveedor.add(lblProveedor);

		JLabel lbl_iconProvee = new JLabel("");
		lbl_iconProvee.setIcon(new ImageIcon(MenuPpal.class.getResource("/Presentacion/proveedor.png")));
		lbl_iconProvee.setBounds(25, 12, 20, 20);
		btn_Proveedor.add(lbl_iconProvee);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 165, 132);
		lblNewLabel.setIcon(new ImageIcon(MenuPpal.class.getResource("/Presentacion/logo.png")));
		panel.add(lblNewLabel);
		btn_Tecnicos.setBounds(0, 177, 165, 47);

		btn_Tecnicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Tecnico ventTecnico = new Tecnico();
				ventTecnico.setVisible(true);

				resetColor(btn_Tecnicos); // Reseteo Color
				setColor(btn_Clientes);
				setColor(btn_Paquetes);
				setColor(btn_Proveedor);
				setColor(btn_Insumos);
				setColor(btn_Solicita);

			}
		});

		btn_Tecnicos.setLayout(null);
		btn_Tecnicos.setBackground(new Color(44, 21, 158));
		panel.add(btn_Tecnicos);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 204));
		panel_2.setBounds(0, 0, 10, 47);
		btn_Tecnicos.add(panel_2);

		JLabel lblTecnicos = new JLabel("         Tecnicos");

		lblTecnicos.setForeground(Color.WHITE);
		lblTecnicos.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTecnicos.setBounds(12, 0, 153, 47);
		btn_Tecnicos.add(lblTecnicos);

		JLabel lbl_icon_tecnico = new JLabel("");
		lbl_icon_tecnico.setIcon(new ImageIcon(MenuPpal.class.getResource("/Imagenes/icons/tecnico.png")));
		lbl_icon_tecnico.setBounds(25, 12, 20, 20);
		btn_Tecnicos.add(lbl_icon_tecnico);

		JLabel lblMantenimientoInformatico = new JLabel("Gestión de Services");
		lblMantenimientoInformatico.setBounds(175, 36, 532, 47);
		lblMantenimientoInformatico.setForeground(UIManager.getColor("Button.background"));
		lblMantenimientoInformatico.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblMantenimientoInformatico);

		btn_Insumos = new JPanel();
		btn_Insumos.setBounds(0, 310, 165, 47);
		btn_Insumos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Insumos ventInsumos = new Insumos();
				ventInsumos.setVisible(true);
				resetColor(btn_Insumos); // Reseteo Color
				setColor(btn_Clientes);
				setColor(btn_Paquetes);
				setColor(btn_Tecnicos);
				setColor(btn_Proveedor);
				setColor(btn_Solicita);

			}
		});
		btn_Insumos.setLayout(null);
		btn_Insumos.setBackground(new Color(44, 21, 158));
		panel.add(btn_Insumos);

		JLabel lbl_iconInsumos = new JLabel("");
		lbl_iconInsumos.setIcon(new ImageIcon(MenuPpal.class.getResource("/Presentacion/insumos.png")));
		lbl_iconInsumos.setBounds(25, 12, 20, 20);
		btn_Insumos.add(lbl_iconInsumos);

		btn_decInsumos = new JPanel();
		btn_decInsumos.setBackground(new Color(51, 102, 204));
		btn_decInsumos.setBounds(0, 0, 10, 47);
		btn_Insumos.add(btn_decInsumos);

		lblInsumos = new JLabel("         Insumos");

		lblInsumos.setForeground(Color.WHITE);
		lblInsumos.setFont(new Font("Dialog", Font.BOLD, 15));
		lblInsumos.setBounds(12, 0, 153, 47);
		btn_Insumos.add(lblInsumos);

		btn_Clientes = new JPanel();
		btn_Clientes.setBounds(0, 131, 165, 47);
		btn_Clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Cambio de color de los botones
				resetColor(btn_Clientes);
				setColor(btn_Tecnicos);
				setColor(btn_Paquetes);
				setColor(btn_Proveedor);
				setColor(btn_Insumos);
				setColor(btn_Solicita);
				// Abre ventana Cliente
				Cliente ventCliente = new Cliente();
				ventCliente.setVisible(true);

			}
		});
		btn_Clientes.setBackground(new Color(44, 21, 158));
		panel.add(btn_Clientes);
		btn_Clientes.setLayout(null);

		btn_decCLientes = new JPanel();
		btn_decCLientes.setBackground(new Color(51, 102, 204));
		btn_decCLientes.setBounds(0, 0, 10, 47);
		btn_Clientes.add(btn_decCLientes);

		lblClientes = new JLabel("         Clientes");
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Dialog", Font.BOLD, 15));
		lblClientes.setBounds(12, 0, 153, 47);
		btn_Clientes.add(lblClientes);

		JLabel lbl_Cli_Icon = new JLabel("");
		lbl_Cli_Icon.setIcon(new ImageIcon(MenuPpal.class.getResource("/Imagenes/icons/group-16.png")));
		lbl_Cli_Icon.setBounds(25, 12, 20, 20);
		btn_Clientes.add(lbl_Cli_Icon);
		label.setBounds(0, 0, 900, 636);
		label.setIcon(new ImageIcon(MenuPpal.class.getResource("/Imagenes/Menu.png")));
		panel.add(label);
	}
}
