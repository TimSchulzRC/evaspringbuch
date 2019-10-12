package de.evaspringbuch.eva04p1wizard.v1instantiating;

import org.springframework.stereotype.Component;

@Component
public class WizardV1 {

    Assistant myAssistant = new Assistant();

    public void performMagicTrick() {
        myAssistant.assistMagicTrick();
    }
}
