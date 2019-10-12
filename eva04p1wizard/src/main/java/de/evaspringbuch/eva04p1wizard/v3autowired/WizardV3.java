package de.evaspringbuch.eva04p1wizard.v3autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class WizardV3 {

    @Autowired Assistant myAssistant;

    public void performMagicTrick() {
        myAssistant.assistMagicTrick();
    }
}
