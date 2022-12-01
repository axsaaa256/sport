package com.cube.Pojo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class Project {
    private String name;
    private String detail;
    private Timestamp startTime;
    private Timestamp endTime;

    private Map<Athlete,Integer> athletes;
    private Map<Volunteer,String> volunteers;
    private List<Refee> refees;

}
