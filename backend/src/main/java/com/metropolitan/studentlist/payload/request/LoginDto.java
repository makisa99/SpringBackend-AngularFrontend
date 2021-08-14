package com.metropolitan.studentlist.payload.request;

public class LoginDto {

    private String ime;
    private String lozinka;

    public LoginDto() {
    }

    public LoginDto(String ime, String lozinka) {
        this.ime = ime;
        this.lozinka = lozinka;
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

}