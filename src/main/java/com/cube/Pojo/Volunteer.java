package com.cube.Pojo;

public class Volunteer {
    private int id;
    private String name;
    private String account;
    private String password;
    private String Serve;
    private Project project;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getServe() {
        return Serve;
    }

    public void setServe(String serve) {
        Serve = serve;
    }
}
