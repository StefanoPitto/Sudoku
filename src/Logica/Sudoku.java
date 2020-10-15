package Logica;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sudoku {

	private Casillero [][] matrizSudoku;
	private Logger logger;
	public Sudoku(){
		matrizSudoku= new Casillero [9][9];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				matrizSudoku[i][j]= new Casillero(i,j,0,true);
			}
		}
		Handler handler= new ConsoleHandler();
		handler.setLevel(Level.INFO);
		logger = Logger.getLogger(Sudoku.class.getName());
		logger.addHandler(handler);
		logger.setLevel(Level.INFO);
	}
	
	public void actualizar(Casillero c) {
			c.actualizar();
			logger.info("El casillero "+c.getFila()+"|"+c.getColumna()+" fue actualizado.");
			verificar(c.getElement(),c.getColumna(),c.getFila());
			
	}
	
	private void verificar(int n,int columna,int fila ) {
		boolean encontre=false;
		for(int i=0;i<matrizSudoku.length&&!encontre;i++) {
			if(matrizSudoku[i][columna].getElement()==n) {
				matrizSudoku[i][columna].setEsValida(false);// Si está repetido setea como falso posición válida.
				encontre=true;
				logger.info("El casillero "+fila+"|"+columna+" no es válido.");
			}
		}
		for(int i=0;i<matrizSudoku.length&&!encontre;i++) {
			if(matrizSudoku[fila][i].getElement()==n){
				matrizSudoku[fila][i].setEsValida(false);// Si está repetido setea como falso posición válida.
				encontre=true;
				logger.info("El casillero "+fila+"|"+columna+" no es válido.");
			}
		}
		int f=fila/3;
		int c=columna/3;
		for(int i=f*3;i<f+3&&!encontre;i++) {
			for(int j=c*3;j<c+3&&!encontre;j++){
				if(matrizSudoku[i][j].getElement()==n) {
					matrizSudoku[i][j].setEsValida(false); // Si está repetido setea como falso posición válida.
					encontre=true;
					logger.info("El casillero "+fila+"|"+columna+" no es válido.");
				}
			}
		}	
		if(!encontre) {
			matrizSudoku[fila][columna].setEsValida(true); // Si no está repetido setea como verdadero posición válida.
			logger.info("El casillero "+fila+"|"+columna+" es válido.");
		}
	}	
	public Casillero getCasillero(int f,int c) {
		return matrizSudoku[f][c];
	}
	
	public int getCantFilas() {
		return matrizSudoku.length;
	}
	
}
