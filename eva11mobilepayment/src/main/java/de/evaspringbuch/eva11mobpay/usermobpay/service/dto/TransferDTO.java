package de.evaspringbuch.eva11mobpay.usermobpay.service.dto;

public class TransferDTO {

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
