package de.evaspringbuch.eva10transaction.tryTransaction;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by wo on 19.04.2016.
 */
@Entity
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;
    private float balance;
    private String name;

    public Account() {
    }

    public Account(String st) {
        balance = 0;
        name = st;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setName(String st) {
        name = st;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public String getName() {
        return name;
    }
}

