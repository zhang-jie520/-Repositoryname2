package com.example.demo.entry;


public class WeiXiuBuZhou {
    private int id;
    private String zhuangbei;
    private String gztype;
    private String buzhou;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZhuangbei() {
        return zhuangbei;
    }

    public void setZhuangbei(String zhuangbei) {
        this.zhuangbei = zhuangbei;
    }

    public String getGztype() {
        return gztype;
    }

    public void setGztype(String gztype) {
        this.gztype = gztype;
    }

    public String getBuzhou() {
        return buzhou;
    }

    public void setBuzhou(String buzhou) {
        this.buzhou = buzhou;
    }

    @Override
    public String toString() {
        return "WeiXiuBuZhou{" +
                "id=" + id +
                ", zhuangbei='" + zhuangbei + '\'' +
                ", gztype='" + gztype + '\'' +
                ", buzhou='" + buzhou + '\'' +
                '}';
    }
}
