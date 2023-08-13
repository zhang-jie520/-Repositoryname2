package com.example.demo.entry;


public class Zb {
    private int id;
    private String zbname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZbname() {
        return zbname;
    }

    public void setZbname(String zbname) {
        this.zbname = zbname;
    }

    @Override
    public String toString() {
        return "Zb{" +
                "id=" + id +
                ", zbname='" + zbname + '\'' +
                '}';
    }
}
