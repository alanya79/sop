package com.group74.mic3.controller;

import com.group74.mic3.model.ProjectNumber;
import com.group74.mic3.service.ArchitectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/architects")
public class ArchitectController {

    private final ArchitectService service;
    public ArchitectController(ArchitectService service) { this.service = service; }

    @GetMapping("/check")
    public boolean checkProject(@RequestParam int id, @RequestParam ProjectNumber project) {
        return service.checkProject(id, project);
    }
}

