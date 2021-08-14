package com.metropolitan.studentlist.payload.request;

public class StudentDtoRequest {

    private long fakultetId;
    private String ime;
    private String slikaUrl;

    public StudentDtoRequest() {
    }

    public StudentDtoRequest(long fakultetId, String ime, String slikaUrl) {
        this.fakultetId = fakultetId;
        this.ime = ime;
        this.slikaUrl = slikaUrl;
    }

    public long getFakultetId() {
        return fakultetId;
    }

    public void setFakultetId(long fakultetId) {
        this.fakultetId = fakultetId;
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
}