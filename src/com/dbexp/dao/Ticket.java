package com.dbexp.dao;

import java.util.Date;

/**
 * @Author: Steph
 * @Date: 2019/5/13
 */
public class Ticket {
    private String fid, oplace, tplace, fdate, otime, ttime, remainder, price, dcnt, drate, comp;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getOplace() {
        return oplace;
    }

    public void setOplace(String oplace) {
        this.oplace = oplace;
    }

    public String getTplace() {
        return tplace;
    }

    public void setTplace(String tplace) {
        this.tplace = tplace;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDcnt() {
        return dcnt;
    }

    public void setDcnt(String dcnt) {
        this.dcnt = dcnt;
    }

    public String getDrate() {
        return drate;
    }

    public void setDrate(String drate) {
        this.drate = drate;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getFdate() {
        return fdate;
    }

    public void setFdate(String fdate) {
        this.fdate = fdate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "fid='" + fid + '\'' +
                ", oplace='" + oplace + '\'' +
                ", tplace='" + tplace + '\'' +
                ", fdate='" + fdate + '\'' +
                ", otime='" + otime + '\'' +
                ", ttime='" + ttime + '\'' +
                ", remainder='" + remainder + '\'' +
                ", price='" + price + '\'' +
                ", dcnt='" + dcnt + '\'' +
                ", drate='" + drate + '\'' +
                ", comp='" + comp + '\'' +
                '}';
    }
}
