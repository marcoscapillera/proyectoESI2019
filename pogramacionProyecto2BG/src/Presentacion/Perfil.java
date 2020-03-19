package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Perfil extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
	public Perfil() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 636);
		contentPane = new JPanel();
		setTitle("Perfil");
		
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 900, 636);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 900, 682);
		panel_1.add(panel_2);
		
		JButton button = new JButton("Eliminar");
		button.setBackground(new Color(255, 102, 153));
		button.setBounds(506, 555, 221, 25);
		panel_2.add(button);
		
		JButton button_1 = new JButton("Guardar");
		button_1.setBackground(new Color(153, 204, 204));
		button_1.setBounds(147, 555, 221, 25);
		panel_2.add(button_1);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBackground(Color.WHITE);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClientes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Cliente ventcliente = new Cliente();
						ventcliente.setVisible(true);
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						dispose();
					}
				});
			}
		});
		btnClientes.setHorizontalAlignment(SwingConstants.LEADING);
		btnClientes.setForeground(Color.BLACK);
		btnClientes.setFont(new Font("Dialog", Font.BOLD, 12));
		btnClientes.setBounds(775, 0, 89, 25);
		panel_2.add(btnClientes);
		
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(29, 179, 256, 25);
		panel_2.add(textField_4);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(29, 270, 96, 15);
		panel_2.add(lblDescuento);
		
		JLabel lblNombreperfil = new JLabel("Nombre Perfil");
		lblNombreperfil.setBounds(29, 216, 114, 15);
		panel_2.add(lblNombreperfil);
		
		JLabel lblIdperfil = new JLabel("ID_Perfil");
		lblIdperfil.setBounds(29, 151, 66, 15);
		panel_2.add(lblIdperfil);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPerfil.setBounds(29, 40, 256, 56);
		panel_2.add(lblPerfil);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Perfil.class.getResource("/Imagenes/Insumos.png")));
		label_10.setForeground(Color.WHITE);
		label_10.setBackground(Color.BLUE);
		label_10.setBounds(0, 0, 890, 606);
		panel_2.add(label_10);
	}

}
