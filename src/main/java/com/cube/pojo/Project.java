package com.cube.pojo;

import java.sql.Timestamp;
import java.util.List;

public class Project {
    private String name;
    private String detail;
    private Timestamp startTime;
    private Timestamp endTime;

    private List<Competition> competitions;
    private List<Volunteer> volunteers;
    private List<Refee> refees;

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

    public List<Refee> getRefees() {
        return refees;
    }

    public void setRefees(List<Refee> refees) {
        this.refees = refees;
    }
}
