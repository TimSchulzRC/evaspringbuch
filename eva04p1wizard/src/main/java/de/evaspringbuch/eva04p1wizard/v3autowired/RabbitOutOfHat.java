package de.evaspringbuch.eva04p1wizard.v3autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
//@Qualifier("useTheRabbit")
public class RabbitOutOfHat implements MagicTrick {

	private static final Logger log = LoggerFactory.getLogger(PackOfCards.class);
	
    String rabbitAndHat = "Hase und Hut";

    @Override
    public void sayMagicSpellAndEditUtensil() {
        log.info("     zeigeLeerenHut und zieheHaseAusHut");
    }
}
