package de.evaspringbuch.eva11chatapp.post.service.dto;

import java.io.Serializable;

public class TransferDTO implements Serializable{

    String to;
    int amount;

    public TransferDTO() {
    }

    public TransferDTO(String to, int amount) {
        this.to = to;
        this.amount = amount;
    }

    public String getTo() {
        return to;
    }

    public int getAmount() {
        return amount;
    }
}
