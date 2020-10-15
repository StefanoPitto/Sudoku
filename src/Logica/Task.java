package Logica;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Task extends TimerTask {
	Timer timer;
	int cont;
	int contMinutos=0;
	JLabel [] reloj;
	ImageIcon [] imagenes;
	public Task(Timer t,JLabel [] r){
		timer=t;
		cont=0;
		reloj=r;
		imagenes= new ImageIcon [10];
		inicializarArreglo();
	}
	private void inicializarArreglo() {
		imagenes[0]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/0.png")));
		imagenes[1]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/1.png")));
		imagenes[2]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/2.png")));
		imagenes[3]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/3.png")));
		imagenes[4]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/4.png")));
		imagenes[5]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/5.png")));
		imagenes[6]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/6.png")));
		imagenes[7]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/7.png")));
		imagenes[8]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/8.png")));
		imagenes[9]=reDimensionar(reloj[0],new ImageIcon(this.getClass().getResource("/Numeros/9.png")));
	}
	public void run(){
		if (cont==60) {
			 cont=0;
			 contMinutos++;
		}else {
			cont++;			
		}
		int contMinutosAux=contMinutos;
		int contAux=cont;
		reloj[4].setIcon(imagenes[contAux%10]);
		reloj[3].setIcon(imagenes[contAux/10]);
		reloj[2].setText(":");
		reloj[1].setIcon(imagenes[contMinutosAux]);
		reloj[0].setIcon(imagenes[contMinutosAux/10]);
	}
	
	private  ImageIcon reDimensionar(JLabel label, ImageIcon grafico) {
		ImageIcon toReturn=grafico;
		Image image = toReturn.getImage();
		if (image != null) {  
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(),  java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.repaint();
		}
		return toReturn;
	}
}