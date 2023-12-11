package com.example.tbptbpart2;


public class DataClass {

    private String dataTitle;
    private String dataDesc;
    private String dataDue;
    private String dataImage;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public String getDataDue() {
        return dataDue;
    }

    public String getDataImage() {
        return dataImage;
    }

    public DataClass(String dataTitle, String dataDesc, String dataDue, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataDue = dataDue;
        this.dataImage = dataImage;
    }
    public DataClass(){

    }
}