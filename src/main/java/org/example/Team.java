package org.example;

import java.util.List;

public class Team {

    private List<Sewer> sewers;

    public Team(List<Sewer> sewers) {
        this.sewers = sewers;
    }

    public List<Sewer> getSewers() {
        return sewers;
    }
}