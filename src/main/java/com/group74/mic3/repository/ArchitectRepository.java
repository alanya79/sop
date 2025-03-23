package com.group74.mic3.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group74.mic3.model.Architect;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArchitectRepository {
    private static final String FILE_PATH = "src/main/resources/Architects.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Architect> getArchitects() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();
            return objectMapper.readValue(file, new TypeReference<List<Architect>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error reading Architects.json", e);
        }
    }

    public void saveArchitects(List<Architect> architects) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), architects);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to Architects.json", e);
        }
    }
}

