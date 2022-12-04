package com.cube.pojo;

import java.sql.Timestamp;
import java.util.List;

public class Project {

    private int id;
    private String name;
    private String detail;
    private Timestamp startTime;
    private Timestamp endTime;

    private String postion;

    private List<Competition> competitions;
    private List<Volunteer> volunteers;
    private List<Referee> referees;

    public Project() {
    }

    public Project(String name, String detail, Timestamp startTime, Timestamp endTime, String postion) {
        this.name = name;
        this.detail = detail;
        this.startTime = startTime;
        this.endTime = endTime;
        this.postion = postion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    public List<Referee> getRefees() {
        return referees;
    }

    public void setRefees(List<Referee> referees) {
        this.referees = referees;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public List<Referee> getReferees() {
        return referees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReferees(List<Referee> referees) {
        this.referees = referees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", postion='" + postion + '\'' +
                ", competitions=" + competitions +
                ", volunteers=" + volunteers +
                ", referees=" + referees +
                '}';
    }
}
