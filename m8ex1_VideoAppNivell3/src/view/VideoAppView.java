package view;

import java.util.HashMap;

public class VideoAppView {
	private MyScanner myScanner = new MyScanner();
	
	public VideoAppView() {}
	
	public void init() {
		System.out.println("Iniciando aplicación...");
	}
	
	public Integer loginMenuHandler() {
		String MENU = "¿Qué desea hacer?\n1. Login\n2. Crear usuario\n9. Salir\n=> ";
		
		int[] OPTIONS = {1,2,9};
		
		return myScanner.handlerGenericMenu(MENU, OPTIONS);
	}
	
	public Integer appMenuHandler() {
		String MENU = "¿Qué desea hacer?\n1. Crear video\n2. Mostrar videos\n3. Reproducir video\n4. Pausar video\n5. Parar video\n9. Salir\n=> ";
		
		int[] OPTIONS = {1, 2, 3, 4, 5, 9};
		
		return myScanner.handlerGenericMenu(MENU, OPTIONS);
	}
	
	public HashMap<String, String> userInputUserData() {
		HashMap<String, String> userData = new HashMap<String, String>();
		
		String usuario = myScanner.userInputTextLoop("Ingresar el usuario\n=> ", 16, false, null);
		userData.put("usuario", usuario);
		
		String nombre = myScanner.userInputTextLoop("Ingresar el nombre\n=> ", 16, false, null);
		userData.put("nombre", nombre);
		
		String apellido = myScanner.userInputTextLoop("Ingresar el apellido\n=> ", 16, false, null);
		userData.put("apellido", apellido);
		
		String password = myScanner.userInputTextLoop("Ingresar la contraseña\n=> ", 16, false, null);
		userData.put("password", password);
		
		return userData;
	}
	
	public HashMap<String, String> userInputLoginData() {
		HashMap<String, String> loginData = new HashMap<String, String>();
		
		String usuario = myScanner.userInputTextLoop("Ingresar el usuario\n=> ", 16, false, null);
		loginData.put("usuario", usuario);
		
		String password = myScanner.userInputTextLoop("Ingresar el password\n=> ", 16, false, null);
		loginData.put("password", password);
		
		return loginData;
	}
	
	public HashMap<String, String> userInputVideoData() {
		HashMap<String, String> videoData = new HashMap<String, String>();
		
		String URL = myScanner.userInputTextLoop("Ingresar el URL\n=> ", 16, false, null);
		videoData.put("URL", URL);
		String titulo = myScanner.userInputTextLoop("Ingresar el titulo\n=> ", 16, false, null);
		videoData.put("titulo", titulo);
		
		Boolean execution = true;
		Boolean firstRep = true;
		String tags = "";
		while(execution) {
			if(myScanner.userInputBooleanLoop("Desea añadir un tag?")) {
				if(!firstRep) {
					tags += ",";
				}
				tags += myScanner.userInputTextLoop("Ingresar el tag\n=> ", 16, false, "[A-z]{0,16}");
			} else {
				execution = false;
			}
			
			firstRep = false;
		}
		
		videoData.put("tags", tags);
		
		Integer duration = myScanner.userInputPositiveIntLoop("Ingrese la duración del clip en segundos\n=> ");
		videoData.put("duration", duration.toString());
		
		return videoData;
	}
	
	public Integer userInputVideoId() {
		return myScanner.userInputPositiveIntLoop("Insertar el Id del video\n=> ");
	}
	
	public void printVideos(String[][] videos) {
		String status = "";
		
		for(int i = 0; i < videos.length; i++) {
			if(videos[i][6].equals("0")) {
				status = "Stopped";
			} else if(videos[i][6].equals("1")) {
				status = "Paused";
			} else {
				status = "Reproducing";
			}
				System.out.println("\nVideo: " + videos[i][1] + "\nVideo ID: " + videos[i][5] + "\nStatus: " + videos[i][3] + "\nURL: " 
						+ videos[i][0] + "\nTags: " + videos[i][2] + "\nReproducer Status: " + status +  "\nTimer: " + videos[i][4]);
		}
		System.out.println();
	}
	
	public void printHello(String nombre) {
		System.out.println("Hola " + nombre);
	}
}
