package com.example.trogon.First;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    private String name;

    private String language;


    private String type;


    public Model(String name, String language,  String type) {
        this.name = name;
        this.language = language;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}