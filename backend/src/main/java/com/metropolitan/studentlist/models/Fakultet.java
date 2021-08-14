package com.metropolitan.studentlist.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "fakultet")
public class Fakultet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fakultet_id")
    private Long id;
    private String naziv;
    private String adresa;
    @OneToMany(mappedBy = "fakultet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> studenti;

    public Fakultet() {
    }

    public Fakultet(String naziv, String adresa) {
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Set<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(Set<Student> studenti) {
        this.studenti = studenti;
    }
}