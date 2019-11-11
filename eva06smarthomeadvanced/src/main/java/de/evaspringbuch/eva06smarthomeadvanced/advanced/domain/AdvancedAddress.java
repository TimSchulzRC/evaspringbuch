package de.evaspringbuch.eva06smarthomeadvanced.advanced.domain;

import javax.persistence.Embeddable;

@Embeddable
public class AdvancedAddress {

    private String zipcode;
    private String street;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
