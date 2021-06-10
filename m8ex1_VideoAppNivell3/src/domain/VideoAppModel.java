package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VideoAppModel {
	private static List<Usuario> db_usuario = new ArrayList<Usuario>();
	
	public VideoAppModel() {
		Usuario usuario = new Usuario("Gustavo", "Martinez", "user", "pass");
		db_usuario.add(usuario);
	}
	
	public Boolean addUsuario(HashMap<String, String> userData) {
		if(findUserByUserName(userData.get("usuario")) == null) {
			Usuario usuario = new Usuario(userData.get("nombre"), userData.get("apellido"), userData.get("usuario"), userData.get("password"));
			db_usuario.add(usuario);
			return true;
		} else {
			return false;
		}

	}
	
	
	// solo se usan estando logeados
	
	// create
	public void addVideo(HashMap<String, String> videoData, int userID) {
		Usuario usuario = findUserByID(userID);
		
		Video video = new Video(videoData.get("URL"), videoData.get("titulo"), videoData.get("tags"), Integer.parseInt(videoData.get("duration")));
		
		usuario.addVideo(video);
	}
	
	public String[][] getAllVideos(int userId) {
		Usuario usuario = findUserByID(userId);
		
		List<Video> list = usuario.getVideos();
		
		String[][] toReturn = new String[list.size()][8];
		
		for(int i = 0; i < list.size(); i++) {
			toReturn[i][0] = list.get(i).getUrl();
			toReturn[i][1] = list.get(i).getTitulo();
			toReturn[i][2] = list.get(i).getTagsString();
			toReturn[i][7] = "" + list.get(i).getDuration();
			toReturn[i][3] = list.get(i).getStatus();
			toReturn[i][4] = "" + list.get(i).getReproducerTimer();
			toReturn[i][5] = "" + list.get(i).getId();
			toReturn[i][6] = "" + list.get(i).getReproducerStatus();
 		 }
		
		return toReturn; 
	}
	
	public String[] getVideo(int userId, int videoId) {
		Usuario usuario = findUserByID(userId);
		
		Video video = usuario.getVideo(videoId);
		
		if(video != null) {
			String[] toReturn = new String[7];
			
			toReturn[0] = video.getUrl();
			toReturn[1] = video.getTitulo();
			toReturn[2] = video.getTagsString();
			toReturn[3] = video.getStatus();
			toReturn[4] = "" + video.getReproducerTimer();
			toReturn[5] = "" + video.getId();
			toReturn[6] = "" + video.isReproducing();
			
			return toReturn;
			
		} else {
			return null;
		}
	}
	
	public boolean reproduceVideo(int userId, int videoId) {
		Usuario usuario = findUserByID(userId);
		
		return usuario.reproduceVideo(videoId);
	}
	
	public boolean pauseVideo(int userId, int videoId) {
		Usuario usuario = findUserByID(userId);
		
		return usuario.pauseVideo(videoId);
	}
	
	public boolean stopVideo(int userId, int videoId) {
		Usuario usuario = findUserByID(userId);
		
		return usuario.stopVideo(videoId);
	}

	public int authenticate(HashMap<String, String> loginData) {
		Usuario findUser = findUserByUserName(loginData.get("usuario"));
		
		if(findUser == null) {
			return -1;
		} else if(findUser.getPassword().equals(loginData.get("password"))) {
			return findUser.getId();
		} else {
			return -1;
		}
	}
	
	public String getUserFullName(int id) {
		Usuario usuario = findUserByID(id);
		
		if(usuario != null) {
			return usuario.getName() + " " + usuario.getApellido();
		} else {
			return null;
		}
		
	}
	
	public Usuario findUserByUserName(String username) {
		for(int i = 0; i < db_usuario.size(); i++) {
			if(username.equals(db_usuario.get(i).getUsername())) return db_usuario.get(i);
		}
		return null;
	}
	
	public Usuario findUserByID(int id) {
		for(int i = 0; i < db_usuario.size(); i++) {
			if(id == db_usuario.get(i).getId()) return db_usuario.get(i);
		}
		return null;
	}
}
