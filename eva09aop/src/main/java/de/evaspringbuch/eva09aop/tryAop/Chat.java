package de.evaspringbuch.eva09aop.tryAop;

public class Chat {

	    private Integer id;
	    private String chatWith;

	    public Chat() {
	    	this.chatWith = "puh";
	    }

	    public Integer getId() {
	        return id;
	    }

	    public String getChatWith() {
	        return chatWith;
	    }

	    public void setChatWith(String chatWith) {
	        this.chatWith = chatWith;
	    }

}
