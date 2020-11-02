package com.example.sonaraapp.commonclasses;

public class Complaint {
    String name,mobile,modelno,problem,enginnername,status,date,estimate,paid;

    public Complaint(String name, String mobile, String modelno, String problem, String enginnername, String status, String date, String estimate, String paid) {
        this.name = name;
        this.mobile = mobile;
        this.modelno = modelno;
        this.problem = problem;
        this.enginnername = enginnername;
        this.status = status;
        this.date = date;
        this.estimate = estimate;
        this.paid = paid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getEnginnername() {
        return enginnername;
    }

    public void setEnginnername(String enginnername) {
        this.enginnername = enginnername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}
