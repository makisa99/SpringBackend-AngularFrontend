package com.metropolitan.studentlist.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "korisnik_id")
    private Long id;
    private String ime;
    private String lozinka;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "korisnik_rola",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "rola_id", referencedColumnName = "rola_id"))
    private Set<Rola> role;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "profesor_predmet",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "predmet_id", referencedColumnName = "predmet_id"))
    private Set<Predmet> predmeti;
    @OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ispit> ispiti;

    public Korisnik() {
    }

    public Korisnik(String ime, String lozinka) {
        this.ime = ime;
        this.lozinka = lozinka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Set<Rola> getRole() {
        return role;
    }

    public void setRole(Set<Rola> role) {
        this.role = role;
    }

    public Set<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(Set<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    public Set<Ispit> getIspiti() {
        return ispiti;
    }

    public void setIspiti(Set<Ispit> ispiti) {
        this.ispiti = ispiti;
    }
}