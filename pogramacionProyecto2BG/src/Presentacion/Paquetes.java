package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class Paquetes extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdPaquete;
	private JTextField txtNomPaquete;
	private JTextField txtHsArmado;
	private JTextField txtCostoParcial;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paquetes frame = new Paquetes();
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
	public Paquetes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 636);
		setTitle("Paquetes");
		
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 610);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("Eliminar");
		button.setBackground(new Color(255, 102, 153));
		button.setBounds(502, 556, 221, 25);
		panel.add(button);
		
		JLabel lblPresupuesto = new JLabel("Presupuesto");
		lblPresupuesto.setBounds(26, 340, 180, 16);
		panel.add(lblPresupuesto);
		
		JLabel lblCantidad = new JLabel("Cantidad ");
		lblCantidad.setBounds(406, 249, 190, 16);
		panel.add(lblCantidad);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(406, 277, 235, 22);
		panel.add(textField);
		
		JLabel lblNDePaquete = new JLabel("N\u00B0 de Paquete");
		lblNDePaquete.setBounds(26, 178, 128, 25);
		panel.add(lblNDePaquete);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(166, 183, 180, 16);
		panel.add(label_1);
		
		JLabel lblCostoParcial = new JLabel("Costo Insumos");
		lblCostoParcial.setBounds(671, 178, 173, 26);
		panel.add(lblCostoParcial);
		
		JLabel lblHorasDeArmado = new JLabel("Horas de armado");
		lblHorasDeArmado.setBounds(406, 182, 190, 16);
		panel.add(lblHorasDeArmado);
		
		txtIdPaquete = new JTextField();
		txtIdPaquete.setBounds(22, 212, 111, 22);
		txtIdPaquete.setColumns(10);
		panel.add(txtIdPaquete);
		
		txtNomPaquete = new JTextField();
		txtNomPaquete.setBounds(159, 215, 225, 22);
		txtNomPaquete.setColumns(10);
		panel.add(txtNomPaquete);
		
		txtHsArmado = new JTextField();
		txtHsArmado.setBounds(406, 213, 235, 22);
		txtHsArmado.setColumns(10);
		panel.add(txtHsArmado);
		
		JLabel lblTipo = new JLabel("Tipo De Instalacion");
		lblTipo.setBounds(26, 247, 135, 16);
		panel.add(lblTipo);
		
		JComboBox cmcTipoPaquete = new JComboBox();
		cmcTipoPaquete.addItem("Seleccione Paquete");
		cmcTipoPaquete.addItem("Armado de PC");
		cmcTipoPaquete.addItem("Cableado Estructurado");
		cmcTipoPaquete.setBounds(26, 275, 358, 25);
		cmcTipoPaquete.setBackground(Color.WHITE);
		panel.add(cmcTipoPaquete);
		
		txtCostoParcial = new JTextField();
		txtCostoParcial.setBounds(664, 213, 207, 22);
		txtCostoParcial.setColumns(10);
		panel.add(txtCostoParcial);
		
		JLabel lblPaquetes = new JLabel("Paquetes");
		lblPaquetes.setBounds(33, 49, 190, 31);
		lblPaquetes.setForeground(Color.WHITE);
		lblPaquetes.setFont(new Font("Dialog", Font.BOLD, 17));
		panel.add(lblPaquetes);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setBounds(26, 368, 845, 166);
		panel.add(scrollPane_1);
		
		JButton btnAgregar = new JButton("Calcular");
		btnAgregar.setBackground(Color.ORANGE);
		btnAgregar.setBounds(179, 556, 190, 25);
		panel.add(btnAgregar);
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setBounds(0, 0, 900, 611);
		lblImagenFondo.setIcon(new ImageIcon(Paquetes.class.getResource("/Imagenes/Insumos.png")));
		panel.add(lblImagenFondo);
	}
}
