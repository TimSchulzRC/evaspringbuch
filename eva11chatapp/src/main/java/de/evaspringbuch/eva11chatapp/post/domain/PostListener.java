package de.evaspringbuch.eva11chatapp.post.domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.persistence.PrePersist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostListener {
	
	private static final Logger log = LoggerFactory.getLogger(PostListener.class);
	 
	@PrePersist
	public void methodInvokedBeforePersist(Post post) {
//		log.debug("   >>>   Before persist operation on post with id = {}", post.getId());
		DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);
        String s = LocalTime.now().format(germanFormatter);
        post.setTimestamp(s);
	}
 
//	@PostPersist
//	public void methodInvokedAfterPersist(Post post) {
//		log.debug("   >>>   After persist operation on post with id = {}", post.getId());
//	}
// 
//	@PreUpdate
//	public void methodInvokedBeforeUpdate(Post post) {
//		log.debug("   >>>   Before update  operation on post with id = {}", post.getId());
//	}
// 
//	@PostUpdate
//	public void methodInvokedAfterUpdate(Post post) {
//		log.debug("   >>>   After update operation on post with id = {}", post.getId());
//	}
// 
//	@PreRemove
//	private void methodInvokedBeforeRemove(Post post) {
//		log.debug("   >>>   Before remove operation on  post with id = {}", post.getId());
//	}
// 
//	@PostRemove
//	public void methodInvokedAfterRemove(Post post) {
//		log.debug("   >>>   After remove operation on  post with id = {}", post.getId());
//	}
}
