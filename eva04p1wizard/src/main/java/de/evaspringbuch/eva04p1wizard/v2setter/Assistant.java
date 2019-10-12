package de.evaspringbuch.eva04p1wizard.v2setter;

public class Assistant {

    MagicTrick myMagicTrick;

    public Assistant set(MagicTrick myMagicTrick) {
        this.myMagicTrick = myMagicTrick;
        return this;
    }

    void assistMagicTrick() {
    	myMagicTrick.sayMagicSpellAndEditUtensil();
    }
}
