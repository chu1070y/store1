package org.zerock.domain;

import java.util.Date;

public class MenuVO {
    //메뉴정보 설정
    private int mno,sno;
    private String mname;
    private int price;
    private Date regdate;

    @Override
    public String toString() {
        return "MenoVO{" +
                "mno=" + mno +
                ", sno=" + sno +
                ", mname='" + mname + '\'' +
                ", price=" + price +
                ", regdate=" + regdate +
                '}';
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
