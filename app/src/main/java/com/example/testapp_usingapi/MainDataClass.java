package com.example.testapp_usingapi;

import java.util.List;

public class MainDataClass {

    private List<ObjectData> data;

    public MainDataClass() {
    }

    public MainDataClass(List<ObjectData> data) {
        this.data = data;
    }

    public List<ObjectData> getData() {
        return data;
    }

    public void setData(List<ObjectData> data) {
        this.data = data;
    }
}
