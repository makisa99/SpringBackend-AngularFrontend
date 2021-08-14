package com.metropolitan.studentlist.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "predmet")
public class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "predmet_id")
    private Long id;
    private String sifra;
    private String naziv;
    private int espb;
    @OneToMany(mappedBy = "predmet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ispit> ispiti;

    public Predmet() {
    }

    public Predmet(String sifra, String naziv, int espb) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.espb = espb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

}