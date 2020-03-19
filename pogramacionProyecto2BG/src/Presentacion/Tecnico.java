package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;



public class Tecnico extends JFrame  {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tecnico frame = new Tecnico();
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
	public Tecnico() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 636);
		contentPane = new JPanel();
		setTitle("Tecnico");
		
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 900, 606);
		contentPane.add(panel_2);
		
		JButton button = new JButton("Eliminar");
		button.setBackground(new Color(255, 102, 153));
		button.setBounds(506, 555, 221, 25);
		panel_2.add(button);
		
		JButton button_1 = new JButton("Guardar");
		button_1.setBackground(Color.ORANGE);
		button_1.setBounds(147, 555, 221, 25);
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(29, 374, 838, 155);
		panel_2.add(panel_3);
		
		table = new JTable((TableModel) null);
		table.setBackground(Color.WHITE);
		table.setBounds(0, 0, 834, 0);
		panel_3.add(table);
		
		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 170, 836, 89);
		panel_3.add(scrollPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(29, 288, 256, 25);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(29, 234, 256, 25);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(29, 338, 256, 25);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(312, 234, 253, 25);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(29, 179, 256, 25);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(312, 288, 256, 25);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(312, 179, 253, 25);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(312, 338, 253, 25);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(616, 179, 248, 25);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_1 = new JLabel("Apellido Paterno");
		label_1.setBounds(29, 270, 165, 15);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setBounds(29, 216, 66, 15);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Apellido Materno");
		label_3.setBounds(29, 324, 136, 15);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Calle");
		label_4.setBounds(312, 149, 90, 19);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Telefono");
		label_5.setBounds(312, 324, 74, 14);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Numero");
		label_6.setBounds(312, 216, 66, 15);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Localidad");
		label_7.setBounds(312, 270, 136, 14);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("C.I");
		label_8.setBounds(29, 151, 66, 15);
		panel_2.add(label_8);
		
		JLabel lblNewLabel = new JLabel("Fecha de ingreso");
		lblNewLabel.setBounds(621, 146, 122, 25);
		panel_2.add(lblNewLabel);
		
		JLabel lblTecnicos = new JLabel("Tecnicos");
		lblTecnicos.setForeground(Color.WHITE);
		lblTecnicos.setFont(new Font("Dialog", Font.BOLD, 17));
		lblTecnicos.setBounds(29, 40, 256, 56);
		panel_2.add(lblTecnicos);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Tecnico.class.getResource("/Imagenes/Insumos.png")));
		label_10.setBounds(0, 0, 890, 606);
		panel_2.add(label_10);
	}
}
