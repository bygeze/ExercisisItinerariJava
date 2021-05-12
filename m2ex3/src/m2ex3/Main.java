package m2ex3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour;
		int minutes;
		int seconds;
		
		hour = 0;
		minutes = 59;
		seconds = 50;
		
		boolean flag = true;
		
		while(flag) {	
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(seconds < 59) {
				seconds++;
			} else if(minutes < 59) {
				minutes++;
				seconds = 0;
			} else if(hour < 24) {
				hour++;
				minutes = 0;
			}
			
			System.out.println(generateString(hour, minutes, seconds));
		}
		
		
	}
	
	static String generateString(int h, int m, int s) {
		String aux = "";
		
		if(h < 10 ) {
			aux += "0";
		}
		
		aux += h + ":";
		
		if(m < 10) {
			aux +="0";
		}
		
		aux += m + ":";
		
		if(s < 10) {
			aux +="0";
		}
		
		aux += s;
		
		return aux;
	}

}
