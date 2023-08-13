package com.example.demo.entry;


public class ZbGz {
    private int id;
    private String zbgzname;
    private String zbgztype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZbgzname() {
        return zbgzname;
    }

    public void setZbgzname(String zbgzname) {
        this.zbgzname = zbgzname;
    }

    public String getZbgztype() {
        return zbgztype;
    }

    public void setZbgztype(String zbgztype) {
        this.zbgztype = zbgztype;
    }

    @Override
    public String toString() {
        return "ZbGz{" +
                "id=" + id +
                ", zbgzname='" + zbgzname + '\'' +
                ", zbgztype='" + zbgztype + '\'' +
                '}';
    }
}
