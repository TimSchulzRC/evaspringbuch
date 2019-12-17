package de.evaspringbuch.eva12chatappeventJS.common;

import org.springframework.ui.Model;

import de.evaspringbuch.eva12chatappeventJS.security.domain.CurrentUser;

public class CurrentUserUtil {
	public static String getCurrentUser(Model model) {
        CurrentUser currentUser = (CurrentUser) model.asMap().get("currentUser");
        String from = currentUser.getNickname();
        model.addAttribute("fromUser", from);
        return from;
    }
}
