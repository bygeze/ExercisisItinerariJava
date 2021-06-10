package domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Video {
	private String URL;
	private String titulo;
	private LocalDateTime fecha;
	private List<Tag> tags = new ArrayList<Tag>();
	
	public Video(String url, String titulo, String tags) {
		this.URL = url;
		this.titulo = titulo;
		this.tags = Tag.tagsFromString(tags);
		this.fecha = LocalDateTime.now();
	}

	public String getUrl() {
		// TODO Auto-generated method stub
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
	
	
}
