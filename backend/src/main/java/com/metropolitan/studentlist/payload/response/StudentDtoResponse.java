package com.metropolitan.studentlist.payload.response;

public class StudentDtoResponse {

    private long id;
    private String ime;
    private String slikaUrl;
    private String nazivFakulteta;

    public StudentDtoResponse() {
    }

    public StudentDtoResponse(long id, String ime, String slikaUrl, String nazivFakulteta) {
        this.id = id;
        this.ime = ime;
        this.slikaUrl = slikaUrl;
        this.nazivFakulteta = nazivFakulteta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getNazivFakulteta() {
        return nazivFakulteta;
    }

    public void setNazivFakulteta(String nazivFakulteta) {
        this.nazivFakulteta = nazivFakulteta;
    }

}