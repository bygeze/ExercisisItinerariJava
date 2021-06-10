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
		String MENU = "¿Qué desea hacer?\n1. Crear video\n2. Mostrar videos\n9. Salir\n=> ";
		
		int[] OPTIONS = {1,2,9};
		
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
		
		return videoData;
	}
	
	public void printVideos(String[][] videos) {
		for(int i = 0; i < videos.length; i++) {
				System.out.println("\nTitulo: " + videos[i][1] + "\nURL: " + videos[i][0] + "\nTags: " + videos[i][2]);
		}
		System.out.println();
	}
	
	public void printHello(String nombre) {
		System.out.println("Hola " + nombre);
	}
}
