package de.evaspringbuch.eva11chatapp.post.service;

import de.evaspringbuch.eva11chatapp.post.service.dto.PayActionResponseDTO;

public interface SmmpService {
    PayActionResponseDTO doPayAction(String from, String to, String pcontent);
}
