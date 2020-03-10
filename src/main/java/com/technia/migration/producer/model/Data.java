package com.technia.migration.producer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    @JsonProperty
    private String message;
    @JsonProperty
    private int id;

    public Data(){
        this.id = 0;
        this.message = null;
    }

    public Data(int id, String message){
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }
}
