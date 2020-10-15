package Logica;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

public class ComponenteGrafica {

	private String [] imagenes= new String[9];
	private int imagen;
	private ImageIcon image;
	private Logger logger;
	
	public ComponenteGrafica(){
		imagen=-1;
		image= null;
		inicializar();
		Handler handler= new ConsoleHandler();
		handler.setLevel(Level.INFO);
		logger = Logger.getLogger(ComponenteGrafica.class.getName());
		logger.addHandler(handler);
		logger.setLevel(Level.INFO);
		
	}
	
	private void inicializar() {
		imagenes[0]="/Numeros/1.png";
		imagenes[1]="/Numeros/2.png";
		imagenes[2]="/Numeros/3.png";
		imagenes[3]="/Numeros/4.png";
		imagenes[4]="/Numeros/5.png";
		imagenes[5]="/Numeros/6.png";
		imagenes[6]="/Numeros/7.png";
		imagenes[7]="/Numeros/8.png";
		imagenes[8]="/Numeros/9.png";
	}
	
	public void siguienteImg() {
		imagen=(imagen+1)%9;
		image= new ImageIcon(this.getClass().getResource(imagenes[imagen]));
		logger.info("La imagen se actualizo a la siguiente.");
	}
	
	public ImageIcon getImg() {
		return image;
	}
	
	
}
