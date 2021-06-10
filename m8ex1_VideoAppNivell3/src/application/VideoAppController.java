package application;

import java.util.HashMap;

import domain.VideoAppModel;
import view.VideoAppView;

public class VideoAppController {
	private static VideoAppView view = new VideoAppView();
	private static VideoAppModel model = new VideoAppModel();
	private int userLogged = -1;
	
	public VideoAppController() {}
	
	public void init() {
		view.init();
		
		boolean execution = true;
		while(execution) {
			Integer selectedOption = view.loginMenuHandler();
			switch(selectedOption) {
				case 1:
					userLogged = authenticate();
					
					if(isLogged()) {
						view.printHello(model.getUserFullName(userLogged));
						mainMenu();
					} else {
						System.out.println("Credenciales incorrectas");
					}
				break;
				case 2:
					if(!createUser()) {
						System.out.println("Ya existe un usuario con ese nombre.\nNo se ha creado el usuario.");
					}
					break;
				case 9:
					System.out.println("Salir");
					execution = false;
				break;
			}
		}
	}
	
	public Boolean createUser() {
		HashMap<String, String> userData = view.userInputUserData();
		
		return model.addUsuario(userData);
	}
	
	public void createVideo() {
		HashMap<String, String> videoData = view.userInputVideoData();
		
		model.addVideo(videoData, userLogged);
	}
	
	public void showVideos() {
		String[][] videos = model.getAllVideos(userLogged);
		
		if(videos.length > 0) {
			view.printVideos(videos);
		} else {
			System.out.println("No hay videos.");
		}
	}
	
	public void reproduceVideo() {
		Integer videoId = view.userInputVideoId();
		
		if(!model.reproduceVideo(userLogged, videoId)) {
			System.out.println("No existe ese video");
		}
		
		String[] video = model.getVideo(userLogged, videoId);
		
		if(video != null) {
			if(video[3] != "Public") {
				System.out.println("El video no es publico todavía");
			}
		}
	}
	
	public String[] getVideo(int videoId) {
		return model.getVideo(userLogged, videoId);
	}
	
	public void pauseVideo() {
		Integer videoId = view.userInputVideoId();
		
		if(!model.pauseVideo(userLogged, videoId) ) {
			System.out.println("No existe ese video");
		}
	}
	
	public void stopVideo() {
		Integer videoId = view.userInputVideoId();
		
		if(!model.stopVideo(userLogged, videoId) ) {
			System.out.println("No existe ese video");
		}
	}
	
	public void mainMenu() {
		boolean execution = true;
		while(execution) {
			Integer selectedOption = view.appMenuHandler();
			switch(selectedOption) {
				case 1:
					createVideo();
					break;
				case 2:
					showVideos();
					break;
				case 3:
					reproduceVideo();
					break;
				case 4:
					pauseVideo();
					break;
				case 5:
					stopVideo();
					break;
				case 9:
					System.out.println("Saliendo..");
					execution = false;
				break;
			}
		}	
	}
	
	public int authenticate() {
		HashMap<String, String> loginData = view.userInputLoginData();
		
		return model.authenticate(loginData);
	}
	
	private boolean isLogged() {
		if(userLogged >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
