package rockets;

import java.util.ArrayList;
import java.util.List;

public class Rocket {
	private String id;
	private List<Propeller> propulsors = new ArrayList<Propeller>();
	//private List<Thread> propThreads= new ArrayList<Thread>();
	
	public Rocket(String id, int[] potenciasMaxPropulsors) {
		this.id = id;
		
		for(int i = 0; i < potenciasMaxPropulsors.length; i++) {
			Propeller aux = new Propeller(potenciasMaxPropulsors[i]);
			this.propulsors.add(aux);
			
		}
	}
	
	public String toString() {
		String s = "";
		s += "Rocket ID: " + this.id + "\n";
		s += "Propulsors: " + this.propulsors.size() + "\n";
		s += "Potencias máximas: [";
		
		for(int i = 0; i < this.propulsors.size(); i++) {
			s += this.propulsors.get(i).getPotenciaMaxima();
			
			if(this.propulsors.size() - i != 1) {
				s += ",";
			}
		}
		
		s += "]";
		
		return s;
	}
	
	public String getId() {
		return id;
	}

	public void move(int qty) {
		if(!isMoving()) {
			for(int i = 0; i < propulsors.size(); i++) {
				Propeller prop = propulsors.get(i);
				
				prop.setPotenciaObjetivo(qty);
				
				Runnable r = new PropellerThread(propulsors.get(i), id, i);
				Thread t = new Thread(r);
				t.start();
			}	
		} else {
			System.out.println("Debe esperar a que acabe la orden anterior");
		}	
	}
	
	public boolean isMoving() {
		boolean ret = false;
		for(int i = 0; i < this.propulsors.size(); i++) {
			if(propulsors.get(i).isMoving()) {
				ret = true;
			}
		}
		
		return ret;
	}
	
}


// **podria manejar una excepcion para que no se añadan mas potencias de las que propulsores hay