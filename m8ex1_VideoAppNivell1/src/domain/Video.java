package domain;

import java.util.ArrayList;
import java.util.List;

public class Video {
	private String URL;
	private String titulo;
	private List<Tag> tags = new ArrayList<Tag>();
	
	public Video(String url, String titulo, String tags) {
		this.URL = url;
		this.titulo = titulo;
		this.tags = Tag.tagsFromString(tags);
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
	
	
}
