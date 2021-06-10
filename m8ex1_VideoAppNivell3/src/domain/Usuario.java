package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private static int counter = 0;
	private int id;
	private String nombre;
	private String apellido;
	private String usuario;
	private String password;
	private LocalDateTime fecha;
	private List<Video> videos = new ArrayList<Video>();
	
	public Usuario(String nombre, String apellido, String usuario, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.password = password;
		this.fecha = LocalDateTime.now();
		this.id = counter++;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.usuario;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getName() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public List<Video> getVideos() {
		return this.videos;
	}
	
	public Video getVideo(int videoId) {
		try {
			return this.videos.get(videoId);
		} catch(Exception e) {
			return null;
		}
	}
	
	public void addVideo(Video video) {
		this.videos.add(video);
	}
	
	public Boolean reproduceVideo(int id) {
		try {
			if(this.videos.get(id).isReproducing()) {
				return false;
			} else {
				try {
					this.videos.get(id).reproduceVideo();
					return true;
				} catch(Exception e) {
					return false;
				}
			}		
		} catch(Exception n) {
			return false;
		}
	}
	
	public Boolean pauseVideo(int id) {
		try {
			this.videos.get(id).pauseVideo();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public Boolean stopVideo(int id) {
		try {
			this.videos.get(id).stopVideo();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
