package com.technia.migration.producer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Relationship {
    @JsonProperty
    private String name;
    @JsonProperty
    private String relId;

    public Relationship() {
        this.name = null;
        this.relId = null;
    }

    public Relationship(String name, String relId) {
        this.name = name;
        this.relId = relId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "name='" + name + '\'' +
                ", relId='" + relId + '\'' +
                '}';
    }
}
