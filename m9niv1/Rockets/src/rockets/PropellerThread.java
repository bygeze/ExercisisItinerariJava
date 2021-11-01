package rockets;

public class PropellerThread implements Runnable {
	public PropellerThread(Propeller unPropulsor, String rocketId, int numProp) {
		propulsor = unPropulsor;
		this.rocketId = rocketId;
		this.numProp = numProp;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		boolean execution = true;
		
		propulsor.setMoving(true);
		
		while(execution) {
			
			if(propulsor.getPotenciaActual() < propulsor.getPotenciaObjetivo() && propulsor.getPotenciaActual() == propulsor.getPotenciaMaxima()) {
				System.out.println(rocketId + " - " + numProp + ": Ha llegado a su máximo de potencia");
				propulsor.setMoving(false);
				execution = false;
			}
			
			if(propulsor.getPotenciaActual() > propulsor.getPotenciaObjetivo() && propulsor.getPotenciaActual() == 0) {
				System.out.println(rocketId + " - " + numProp + ": Ha frenado por completo");
				propulsor.setMoving(false);
				execution = false;
			}
			
			if(propulsor.getPotenciaActual() == propulsor.getPotenciaObjetivo()) {
				System.out.println(rocketId + " - " + numProp + ": Ha llegado a su potencia objetivo");
				propulsor.setMoving(false);
				execution = false;
			}
			
			int r = (int) (Math.random() * (6 - 2)) + 2;
			waitHalfSeconds(r);
			
			if(propulsor.getPotenciaActual() < propulsor.getPotenciaObjetivo()) {
				propulsor.setPotenciaActual(propulsor.getPotenciaActual() + 1);
				System.out.println(rocketId + " - " + numProp + ": (" + propulsor.getPotenciaActual() + ", " + propulsor.getPotenciaObjetivo() + ", " + propulsor.getPotenciaMaxima() + ")");
			} else if(propulsor.getPotenciaActual() > propulsor.getPotenciaObjetivo()) {
				propulsor.setPotenciaActual(propulsor.getPotenciaActual() - 1);
				System.out.println(rocketId + " - " + numProp + ": (" + propulsor.getPotenciaActual() + ", " + propulsor.getPotenciaObjetivo() + ", " + propulsor.getPotenciaMaxima() + ")");
			}
		}
	}
	
	private void waitHalfSeconds(int multiplicador) {
		try {
			Thread.sleep(multiplicador * 500);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	private Propeller propulsor;
	private String rocketId;
	private int numProp;
	
}
