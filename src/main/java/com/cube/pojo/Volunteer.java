package com.cube.pojo;

public class Volunteer {
    private int id;
    private String name;
    private String account;
    private String password;
    private String server;
    private Project project;

    public Volunteer() {
    }

    public Volunteer(String name, String account, String password) {
        this.name = name;
        this.account = account;
        this.password = password;
    }

    public Volunteer(String name, String account, String password, String server) {
        this.name = name;
        this.account = account;
        this.password = password;
        server = server;
    }

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

    public String getServer() {
        return server;
    }

    public void setServer(String serve) {
        this.server = serve;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", Serve='" + server + '\'' +
                ", project=" + project +
                '}';
    }
}
