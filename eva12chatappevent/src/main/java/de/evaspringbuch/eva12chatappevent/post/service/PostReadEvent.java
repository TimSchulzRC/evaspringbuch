package de.evaspringbuch.eva12chatappevent.post.service;

public class PostReadEvent {

	private String from;
    private String to;
    
	public PostReadEvent(String to, String from) {
		this.to = to;
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	@Override
	public String toString() {
		return "PostReadEvent [to=" + to + "from=" + from + "]";
	}
}
