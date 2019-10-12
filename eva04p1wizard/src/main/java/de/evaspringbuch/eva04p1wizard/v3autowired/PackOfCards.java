package de.evaspringbuch.eva04p1wizard.v3autowired;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
public class PackOfCards implements MagicTrick {
	
	private static final Logger log = LoggerFactory.getLogger(PackOfCards.class);

    List utensils = new LinkedList();

    public void sayMagicSpellAndEditUtensil() {
        log.info("     zieheKarteAusKartenspiel und merkeGezogeneKarte");
    }
}
