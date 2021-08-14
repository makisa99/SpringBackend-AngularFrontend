package com.metropolitan.studentlist.models;

import javax.persistence.*;

@Entity
@Table(name = "rola")
public class Rola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rola_id")
    private Integer id;
    private String naziv;

    public Rola() {
    }

    public Rola(String naziv) {
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return naziv;
    }

    public void setIme(String naziv) {
        this.naziv = naziv;
    }

}