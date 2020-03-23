package com.partTime.bean;

/**
 * Created by Administrator on 2019/6/18 0018.
 */

public class JobBean {
    public int id;
    public String company;
    public String addr;
    public String juli;
    public String joptype;
    public String phone;
    public String joptime;

    public JobBean(String company, String addr, String juli, String joptype, String phone, String joptime) {

        this.company = company;
        this.addr = addr;
        this.juli = juli;
        this.joptype = joptype;
        this.phone = phone;
        this.joptime = joptime;
    }
    public JobBean(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getJuli() {
        return juli;
    }

    public void setJuli(String juli) {
        this.juli = juli;
    }

    public String getJoptype() {
        return joptype;
    }

    public void setJoptype(String joptype) {
        this.joptype = joptype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJoptime() {
        return joptime;
    }

    public void setJoptime(String joptime) {
        this.joptime = joptime;
    }
}