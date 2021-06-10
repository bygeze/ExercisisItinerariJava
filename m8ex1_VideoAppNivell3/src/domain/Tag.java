package domain;

import java.util.ArrayList;
import java.util.List;

public class Tag {
	private String tag;
	
	public Tag(String tag) {
		this.tag = tag;
	}
	
	public static List<Tag> tagsFromString(String tags) {
		List<Tag> tagsList = new ArrayList<Tag>();
		
		String[] tagsArray = tags.split(",");
		
		for(int i = 0; i < tagsArray.length; i++) {
			tagsList.add(new Tag(tagsArray[i]));
		}
		
		return tagsList;
	}
	
	public String getTag() {
		return this.tag;
	}
}
