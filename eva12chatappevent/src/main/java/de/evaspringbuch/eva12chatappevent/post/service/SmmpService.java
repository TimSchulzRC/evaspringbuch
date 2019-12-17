package de.evaspringbuch.eva12chatappevent.post.service;

import de.evaspringbuch.eva12chatappevent.post.service.dto.PayActionResponseDTO;

public interface SmmpService {
    PayActionResponseDTO doPayAction(String from, String to, String pcontent);
}
