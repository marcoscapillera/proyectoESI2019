package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class LOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsu;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**LOGIN2
	 * Create the frame.
	 */
	public LOGIN() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 720, 509);
		this.setSize(720,509);
		setTitle("Login");
		setLocation(500,300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 720, 479);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnSesion = new JButton("INICIAR SESION");
		btnSesion.setBounds(218, 400, 318, 25);
		panel.add(btnSesion);
		btnSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSesion.setBackground(new Color(153, 204, 204));
		btnSesion.addMouseListener(new MouseAdapter() {
			@Override
			
			
			public void mouseClicked(MouseEvent e) {
				
				MenuPpal ventMenu = new MenuPpal();
				LOGIN ventLogin = new LOGIN();
				
				String usuarioCorrecto = "pepe";
				String passCorrecto = "123456";
				
				if(usuarioCorrecto.equals(txtUsu.getText())) {
					String pass="";
					
					for( int i =0; i < passwordField.getPassword().length; i++ ) {
						pass += passwordField.getPassword() [i];
					}
					
						if(passCorrecto.equals(pass)){
							JOptionPane.showMessageDialog(null, "BIENVENIDO");
									
							ventMenu.setVisible(true);
							ventLogin.setVisible(false);
							dispose();
							
						} else {
							JOptionPane.showMessageDialog(null, "Constraseña incorrecta");
						}
						
					
				}
			}
			
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 334, 318, 23);
		panel.add(passwordField);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(104, 338, 96, 15);
		panel.add(lblPassword);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(218, 299, 318, 23);
		panel.add(txtUsu);
		txtUsu.setColumns(10);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(113, 303, 70, 15);
		panel.add(lblUsuario);
		lblX.setFont(new Font("Dialog", Font.BOLD, 15));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(679, 12, 29, 33);
		panel.add(lblX);
		
		JLabel lbl_iMAGEN = new JLabel("");
		lbl_iMAGEN.setBounds(0, -19, 720, 498);
		lbl_iMAGEN.setIcon(new ImageIcon(LOGIN.class.getResource("/Imagenes/Login.png")));
		panel.add(lbl_iMAGEN);
	}
}
