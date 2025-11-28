package com.dreamjuicebar.service;

import com.dreamjuicebar.model.Juice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Business service for menu CRUD operations. */
public class MenuService {
    private final List<Juice> juices = new ArrayList<>();

    public List<Juice> getAll() {
        return Collections.unmodifiableList(juices);
    }

    public void add(Juice juice) {
        juices.add(juice);
    }

    public Juice findById(String id) {
        String key = id.trim();
        for (Juice j : juices) {
            if (j.getId().equalsIgnoreCase(key)) return j;
        }
        return null;
    }

    public boolean deleteById(String id) {
        String key = id.trim();
        return juices.removeIf(j -> j.getId().equalsIgnoreCase(key));
    }
}
