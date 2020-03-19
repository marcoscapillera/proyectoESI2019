package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class Bienvenido extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenido frame = new Bienvenido();
					
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
	public Bienvenido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// setBounds(100, 100, 720, 509);
		this.setSize(720, 509);
		setTitle("Bienvenido");
		
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
				
						Button btn_Salir = new Button("SALIR");
						btn_Salir.setBounds(196, 368, 350, 23);
						panel.add(btn_Salir);
						btn_Salir.setFont(new Font("Dialog", Font.BOLD, 12));
						btn_Salir.setBackground(Color.WHITE);
						
								btn_Salir.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
									}
								});
								btn_Salir.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										System.exit(0);
									}
								});
								btn_Salir.setForeground(Color.BLACK);
		
				Button btn_Entrar = new Button("ENTRAR");
				btn_Entrar.setBounds(196, 322, 350, 23);
				panel.add(btn_Entrar);
				btn_Entrar.setFont(new Font("Dialog", Font.BOLD, 12));
				btn_Entrar.setBackground(Color.WHITE);
				btn_Entrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						LOGIN ventLogin = new LOGIN();
						ventLogin.setVisible(true);
						ventLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						dispose();
					}
				});
				btn_Entrar.setForeground(Color.BLACK);
				btn_Entrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

					}
				});

		JLabel lbl_iMAGEN = new JLabel("");
		lbl_iMAGEN.setIcon(new ImageIcon(Bienvenido.class.getResource("/Imagenes/WELCOME.png")));
		lbl_iMAGEN.setBounds(0, 0, 720, 481);
		panel.add(lbl_iMAGEN);
	}
}
