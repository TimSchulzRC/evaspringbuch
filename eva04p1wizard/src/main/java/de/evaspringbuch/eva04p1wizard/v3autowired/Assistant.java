package de.evaspringbuch.eva04p1wizard.v3autowired;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class Assistant {

//	@Qualifier("useTheRabbit") 
    @Autowired MagicTrick myMagicTrick;

    void assistMagicTrick() {
    	myMagicTrick.sayMagicSpellAndEditUtensil();
    }
}
