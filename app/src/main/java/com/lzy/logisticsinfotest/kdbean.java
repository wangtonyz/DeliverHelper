package com.lzy.logisticsinfotest;

import org.litepal.crud.LitePalSupport;

public class kdbean extends LitePalSupport {
    private String kdnum;
    private String kdname;

    public kdbean(){}

    public kdbean(String kdnum, String kdname) {
        this.kdnum = kdnum;
        this.kdname = kdname;
    }

    public String getKdnum() {
        return kdnum;
    }

    public void setKdnum(String kdnum) {
        this.kdnum = kdnum;
    }

    public String getKdname() {
        return kdname;
    }

    public void setKdname(String kdname) {
        this.kdname = kdname;
    }
}
