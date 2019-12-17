package de.evaspringbuch.eva12chatappeventJS.post.service;

public class PostReadEvent {

	private String from;
    private String to;
    
	public PostReadEvent(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "PostReadEvent [from=" + from + ", to=" + to + "]";
	}
	
}
