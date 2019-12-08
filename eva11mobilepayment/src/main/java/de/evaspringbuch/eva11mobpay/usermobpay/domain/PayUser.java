package de.evaspringbuch.eva11mobpay.usermobpay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import org.springframework.hateoas.ResourceSupport;

import de.evaspringbuch.eva11mobpay.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PayUser extends BaseEntity<Long> {
	
    private String name;

    @Enumerated(EnumType.STRING)
    private State state;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    public PayUser() {
        account = new Account();
    }

    public PayUser(String name) {
        account = new Account();
        this.name = name;
        this.state = State.doesNotExist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Account getAccount() {
        return account;
    }


    @Override
    public String toString() {
        return " [ " +
                getId() + " , " +
        name + " , " +
        account.toString() + " , " +
                state + " ]"
                ;
    }
}


