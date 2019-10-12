package de.evaspringbuch.eva04p1wizard.v2setter;

public class WizardV2 {

    Assistant myAssistant;

    public void set(Assistant myAssistant, MagicTrick magicTrick) {
        this.myAssistant = myAssistant;
        this.myAssistant.set(magicTrick);
    }

    public void performMagicTrick() {
        myAssistant.assistMagicTrick();
    }
}
