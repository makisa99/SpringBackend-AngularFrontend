package com.metropolitan.studentlist.models;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    private String ime;
    private String slikaUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fakultet_id", nullable = false)
    private Fakultet fakultet;

    public Student() {
    }

    public Student(String ime, String slikaUrl) {
        this.ime = ime;
        this.slikaUrl = slikaUrl;
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

    public String getSlikaUrl() {
        return slikaUrl;
    }

    public void setSlikaUrl(String slikaUrl) {
        this.slikaUrl = slikaUrl;
    }

    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }
}