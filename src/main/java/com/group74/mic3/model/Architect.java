package com.group74.mic3.model;

import java.util.ArrayList;
import java.util.List;

public class Architect {
    private int id;
    private List<ProjectNumber> projects = new ArrayList<>();

    public Architect() {}

    public Architect(int id) {
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public List<ProjectNumber> getProjects() { return projects; }
    public void setProjects(List<ProjectNumber> projects) { this.projects = projects; }
}


