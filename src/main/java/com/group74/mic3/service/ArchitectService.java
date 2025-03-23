package com.group74.mic3.service;

import com.group74.mic3.model.Architect;
import com.group74.mic3.model.ProjectNumber;
import com.group74.mic3.repository.ArchitectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchitectService {

    private final ArchitectRepository repository;

    public ArchitectService(ArchitectRepository repository) {
        this.repository = repository;
    }

    public String registerArchitect(int id) {
        List<Architect> architects = repository.getArchitects();
        for (Architect a : architects) {
            if (a.getId() == id) {
                return "Architect with ID " + id + " already exists!";
            }
        }
        architects.add(new Architect(id));
        repository.saveArchitects(architects);
        return "Architect registered successfully!";
    }

    public String assignProject(int id, ProjectNumber project) {
        List<Architect> architects = repository.getArchitects();
        for (Architect a : architects) {
            if (a.getId() == id) {
                if (a.getProjects().size() >= 2) {
                    return "Architect cannot take more projects!";
                }
                a.getProjects().add(project);
                repository.saveArchitects(architects);
                return "Project assigned successfully!";
            }
        }
        return "Architect not found!";
        
        
    }
    public boolean checkProject(int id, ProjectNumber project) {
        List<Architect> architects = repository.getArchitects();
        for (Architect a : architects) {
            if (a.getId() == id) {
                return a.getProjects().contains(project);
            }
        }
        return false;
    }

}
