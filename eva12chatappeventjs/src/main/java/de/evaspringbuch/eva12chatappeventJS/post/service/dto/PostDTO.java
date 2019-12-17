package de.evaspringbuch.eva12chatappeventJS.post.service.dto;

public class PostDTO {
	
	private String content;
	
	private String timestamp;

	private String type;
	
	private String read;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

}
