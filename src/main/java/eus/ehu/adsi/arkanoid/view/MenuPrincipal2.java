package eus.ehu.adsi.arkanoid.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eus.ehu.adsi.arkanoid.App;
import eus.ehu.adsi.arkanoid.Arkanoid;
import eus.ehu.adsi.arkanoid.core.Game;

public class MenuPrincipal2 extends JFrame{
	private static MenuPrincipal2 miMenu;
	private JPanel contentPane;
	private JPanel fondo;
    private JLabel titulo;
    private JButton salir;
    private JButton jugar;
    private JButton premios;
    private JButton ajustes;
    private JButton ranking;
	private JButton cambiarPass;
    private String usuarioAct;
    //Prueba
    //Controlador
    private Controlador controlador = null;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal2 frame = new MenuPrincipal2();
					frame.setTitle("Menu Principal");
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static MenuPrincipal2 getMiMenuPrincipal2() {
		if(MenuPrincipal2.miMenu==null) {
			MenuPrincipal2.miMenu = new MenuPrincipal2();
		}
		return MenuPrincipal2.miMenu;
	}

	private MenuPrincipal2() {				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));  //1x1
		contentPane.setBackground(Color.black);
		
		titulo = new JLabel();
		titulo.setText("Menu Principal");
		titulo.setFont(new Font("Impact", Font.PLAIN, 40));
		titulo.setForeground(Color.YELLOW);
		contentPane.add(titulo, BorderLayout.NORTH);
		
		
		fondo = new JPanel();
		fondo.setLayout(new GridLayout(6,1));
		fondo.setOpaque(false);
		contentPane.add(fondo, BorderLayout.CENTER);
		
		jugar = new JButton();
		jugar.addActionListener(getControlador());
		jugar.setText("JUGAR");
		jugar.setPreferredSize(new Dimension(150, 20));
		fondo.add(jugar);
		
		ajustes = new JButton();
		ajustes.addActionListener(getControlador());
		ajustes.setText("AJUSTES");
		ajustes.setPreferredSize(new Dimension(150, 20));
		fondo.add(ajustes);
		
		premios = new JButton();
		premios.addActionListener(getControlador());
		premios.setText("PREMIOS");
		premios.setPreferredSize(new Dimension(150, 20));
		fondo.add(premios);
		
		ranking = new JButton();
		ranking.addActionListener(getControlador());
		ranking.setText("RANKING");
		ranking.setPreferredSize(new Dimension(150, 20));
		fondo.add(ranking);

		cambiarPass = new JButton();
		cambiarPass.addActionListener(getControlador());
		cambiarPass.setText("CAMBIAR CONTRASEÑA");
		cambiarPass.setPreferredSize(new Dimension(150, 20));
		fondo.add(cambiarPass);

		salir = new JButton();
		salir.addActionListener(getControlador());
		salir.setText("SALIR");
		salir.setPreferredSize(new Dimension(150, 20));
		fondo.add(salir);
	}	
	
	//Controlador
	private Controlador getControlador() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}
		
	private class Controlador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("JUGAR")) {
				String datos = Arkanoid.obtenerAjustes(Arkanoid.getUsuarioIniciado());
				String[] datos2 = datos.split(" ");
				String fondo = datos2[0];
				System.out.println(fondo);
				String ladrillo = datos2[1];
				System.out.println(fondo);
				String bola = datos2[2];
				System.out.println(fondo);
				String paddle = datos2[3];
				System.out.println(fondo);
				Arkanoid.cambiarColores(Arkanoid.getUsuarioIniciado(), fondo, ladrillo, bola, paddle);
				
				MenuPrincipal2.this.dispose();
				try {
					new Arkanoid().run();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(btn.getText().equals("AJUSTES")) {
				MenuPrincipal2.this.dispose();
				Ajustes.getMisAjustes().main(null);
			}
			else if(btn.getText().equals("PREMIOS")) {
				MenuPrincipal2.this.dispose();
				Premios.getMiPremios().main(null);
			}
			else if(btn.getText().equals("RANKING")) {
				MenuPrincipal2.this.dispose();
				EleccionRnkng.main(null);
			}
			else if(btn.getText().equals("CAMBIAR CONTRASEÑA")) {
				MenuPrincipal2.this.dispose();
				CambiarContrasena.main(null);
			}
			else if(btn.getText().equals("SALIR")) {
				MenuPrincipal2.this.dispose();	
			}
		}
	}
}
