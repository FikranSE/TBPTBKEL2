package com.example.tbptbpart2;

public class DataClassUser {

    private String dataName;
    private String dataEmail;
    private String dataImage;
    private String key;

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataEmail() {
        return dataEmail;
    }

    public void setDataEmail(String dataEmail) {
        this.dataEmail = dataEmail;
    }

    public String getDataImage() {
        return dataImage;
    }

    public void setDataImage(String dataImage) {
        this.dataImage = dataImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DataClassUser(String dataName, String dataEmail, String dataImage, String key) {
        this.dataName = dataName;
        this.dataEmail = dataEmail;
        this.dataImage = dataImage;
        this.key = key;
    }

    public DataClassUser(){

    }
}
