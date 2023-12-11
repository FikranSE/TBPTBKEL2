package com.example.tbptbpart2;


public class DataClassAssisten {

    private String dataName;
    private String dataDesc;
    private String dataImage;
    private String key;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataName() {
        return dataName;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public String getDataImage() {
        return dataImage;
    }

    public DataClassAssisten(String name, String desc, String imageURL) {
        this.dataName = name;
        this.dataDesc = desc;
        this.dataImage = imageURL;
    }
    public DataClassAssisten(){

    }
}