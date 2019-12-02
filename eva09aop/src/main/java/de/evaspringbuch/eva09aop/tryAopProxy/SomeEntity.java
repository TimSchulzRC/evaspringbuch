package de.evaspringbuch.eva09aop.tryAopProxy;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SomeEntity implements Serializable {

    @Id @GeneratedValue
    private int id;

    public SomeEntity() {
    }

}
