package m3ex2;

public class Main {

	public static void main(String[] args) {
		int CANTIDAD_ALUMNOS = 5;
		int CANTIDAD_NOTAS = 3;
		
		// TODO Auto-generated method stub
		int[][] notasAlumnos = new int[CANTIDAD_ALUMNOS][CANTIDAD_NOTAS];
		
		// generar notas random
		for(int j = 0; j < CANTIDAD_ALUMNOS; j++) {
			for(int i = 0; i < CANTIDAD_NOTAS; i++) {
				notasAlumnos[j][i] = (int) (Math.floor(Math.random() * 10) + 1);
			}
		}
		
		for(int j = 0; j < CANTIDAD_ALUMNOS; j++) {
			
			System.out.println(notasAlumnos[j][0] + ", " + notasAlumnos[j][1] + ", " + notasAlumnos[j][2]);
			int mitjana = 0;
			for(int i = 0; i < CANTIDAD_NOTAS; i++) {
				mitjana += notasAlumnos[j][i];
			}
			mitjana = mitjana/3;
			System.out.println("Alumne " + (j + 1) + " | Mitjana: " + mitjana);
		}

	}

}
