package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import Logica.Task;
import javax.swing.border.LineBorder;
import Logica.Casillero;
import Logica.Sudoku;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Label;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private Sudoku juego;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonInicio = new JButton("Presione para comenzar");
		botonInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iniciarJuego();
				botonInicio.setVisible(false);
				botonInicio.setEnabled(false);
			}
		});
		botonInicio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		botonInicio.setForeground(Color.CYAN);
		botonInicio.setBackground(Color.WHITE);
		botonInicio.setBounds(400, 300, 254, 50);
		contentPane.add(botonInicio);
		
	}
	private void iniciarJuego() {
		JPanel panelReloj = new JPanel();
		panelReloj.setBounds(0, 0, 774, 75);
		contentPane.add(panelReloj);
	
		JPanel panelSudoku = new JPanel();
		panelSudoku.setBounds(0, 80, 774, 481);
		contentPane.add(panelSudoku);
		panelSudoku.setLayout(new GridLayout(9, 9, 0, 0));
		juego = new Sudoku();
		
		//Timer t=new Timer();
		//JLabel [] reloj= new JLabel[5];
		//for(int i=0;i<reloj.length;i++) {
		//	reloj[i]= new JLabel();
		//	panelReloj.add(reloj[i]);
		//}
		//TimerTask task=new Task(t,reloj);
		//t.schedule(task,0,1000);	
		for (int i = 0; i <juego.getCantFilas(); i++) {
			for(int j =0; j<juego.getCantFilas(); j++) {
				Casillero c = juego.getCasillero(i,j);
				ImageIcon grafico = c.getGrafico().getImg();
				JLabel label = new JLabel();
				label.setBorder(new LineBorder(Color.black));
				panelSudoku.add(label);				
				label.addComponentListener(new ComponentAdapter() {
					@Override
					public void componentResized(ComponentEvent e) {
						reDimensionar(label, grafico);
						label.setIcon(grafico);
					}
				});
			
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						juego.actualizar(c);
						reDimensionar(label,grafico);
					}
				});
			}
		}
	}
	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image=null;
		if(grafico!=null) {
			 image = grafico.getImage();
		}
		if (image != null) {  
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(),  java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
		}
		label.repaint();
	}
}
