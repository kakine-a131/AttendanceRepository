package com.example.AttendanceManage.entity;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "attendances")
public class Attendance {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "begin_rest")
    private Date beginRest;

    @Column(name = "end_rest")
    private Date endRest;

    @Column(name = "status")
    private String status;

    @Column(name = "place")
    private String place;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBeginTime()
    {
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String time = formatter.format(beginTime);
        return time;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String time = null;
        if(endTime != null){
            time = formatter.format(endTime);
        }
        return time;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBeginRest() {
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String time = null;
        if(beginRest != null){
            time = formatter.format(beginRest);
        }
        return time;
    }

    public void setBeginRest(Date beginRest) {
        this.beginRest = beginRest;
    }

    public String getEndRest() {
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String time = null;
        if(endRest != null){
            time = formatter.format(endRest);
        }
        return time;
    }

    public void setEndRest(Date endRest) {
        this.endRest = endRest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
