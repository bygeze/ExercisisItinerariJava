package domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Video {
	private static int counter = 0;
	private int id;
	private String URL;
	private String titulo;
	private int durationInSecs;
	private LocalDateTime fecha;
	// 0 parado, 1 pausa, 2 reproduciendo
	private int reproducerStatus = 0;
	private int reproducerTimer = 0;
	private ReproduceThread reproduceThread;
	
	private List<Tag> tags = new ArrayList<Tag>();
	
	public Video(String url, String titulo, String tags, int durationInSecs) {
		this.URL = url;
		this.titulo = titulo;
		this.durationInSecs = durationInSecs;
		this.tags = Tag.tagsFromString(tags);
		this.fecha = LocalDateTime.now();
		this.id = counter++;
		this.reproduceThread = new ReproduceThread();
	}

	public String getUrl() {
		return this.URL;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getTagsString() {
		String str = "";
		
		for(int i = 0; i < tags.size(); i++) {
			String tag = tags.get(i).getTag();
			if(i == tags.size() - 1) {
				str += tag;
			} else {
				str += tag + ", ";
			}
		}
		
		return str;
	}
	
	public int getDuration() {
		return this.durationInSecs;
	}
	
	public String getStatus() {
		LocalDateTime now = LocalDateTime.now();
		
		Duration duration = Duration.between(now, this.fecha);
		
		double diff = Math.abs(duration.toSeconds());
		
		if(diff <= 20) {
			return "Uploading";
		} else if(diff > 20 && diff < 40) {
			return "Verifying";
		} else {
			return "Public";
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getReproducerTimer() {
		if(reproducerStatus == 0) {
			this.reproducerTimer = 0;
		} else {
			this.reproducerTimer = this.reproduceThread.getValue();
		}
		
		return this.reproducerTimer;
	}
	
	public int reproduceVideo() {
		// el video esta en el final en cuanto a tiempo, lo volvemos al inicio;
		if(this.reproducerTimer == this.durationInSecs) {
			this.reproducerTimer = 0;
		}
		
		try {
			if(this.getStatus() == "Public") {
				this.reproduceThread.start(this.reproducerTimer, this.durationInSecs);
				this.reproducerStatus = 2;
				return 1;
			} else {
				return 0;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void stopVideo() {
		this.reproduceThread.stop();
		this.reproducerTimer = 0;
		this.reproducerStatus = 0;
	}
	
	public void pauseVideo() {
		this.reproduceThread.stop();
		this.reproducerStatus = 1;
		
	}
	
	public Boolean isReproducing() {
		if(this.reproducerStatus == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getReproducerStatus() {
		return this.reproducerStatus;
	}
	
}
