package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Datos.d_Solicitar;
import Logica.L_Solicitar;

public class tableServicios extends JFrame {

	private JPanel contentPane;
	
	
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
					tableServicios frame = new tableServicios();
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
	public tableServicios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tableSolicitar = new JTable();
		tableSolicitar.setBounds(0, 0, 1000, 400);
		
		// Listando INSUMOS EN JTABLE
				contentPane.add(tableSolicitar);
				
						JScrollPane scroll_1 = new JScrollPane(tableSolicitar, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						scroll_1.setBounds(0, 0, 1000, 400);
						contentPane.add(scroll_1);
									
		
		
		JPanel pnlTable = new JPanel();
		pnlTable.setBounds(0, 0, 1000, 400);
		contentPane.add(pnlTable);
		
		
		
		/*
		 * *******************************************************
		 *Creamos objeto de la
		 * clase d_Insumos() para poder invocar al m�todo que listar� los insumos en
		 * el JTable. Luego creamos un nuevo m�todo para ser invocado
		 *********************************************************/
		
		d_Solicitar tb = new d_Solicitar();

		Object[][] registros;

		String[] columnas = { "N_SERVICIO", "CI", "FECHA_PRESUPUESTO", "FECHA_INICIO", "FECHA_FIN", "CANTIDAD_HORAS","ESTADO","CAUSA","PRESUPUESTO" };

		registros = tb.listarInsumos();
		DefaultTableModel datos = new DefaultTableModel(registros, columnas);
		tableSolicitar.setModel(datos);
		

		
	}

}
