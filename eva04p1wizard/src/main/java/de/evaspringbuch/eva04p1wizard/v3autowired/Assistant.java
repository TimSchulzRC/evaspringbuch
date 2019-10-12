package de.evaspringbuch.eva04p1wizard.v3autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Assistant {

//	@Qualifier("useTheRabbit") 
    @Autowired MagicTrick myMagicTrick;

    void assistMagicTrick() {
    	myMagicTrick.sayMagicSpellAndEditUtensil();
    }
}
