package rockets;

public class Propeller {
	private int potenciaActual = 0;
	private int potenciaObjetivo = 0;
	private int potenciaMaxima;
	private boolean isMoving;
	
	public Propeller(int potenciaMaxima) {
		this.potenciaMaxima = potenciaMaxima;
		isMoving = false;
	}
	
	public int getPotenciaMaxima() {
		return this.potenciaMaxima;
	}
	
	public int getPotenciaActual() {
		return potenciaActual;
	}
	
	public void setPotenciaActual(int qty) {
		potenciaActual = qty;
	}
	
	public int getPotenciaObjetivo() {
		return potenciaObjetivo;
	}
	
	public void setPotenciaObjetivo(int qty) {
		
		potenciaObjetivo = potenciaActual + qty;
	}
	
	public void setMoving(boolean mv) {
		isMoving = mv;
	}
	
	public boolean isMoving() {
		return isMoving;
	}
	
}
