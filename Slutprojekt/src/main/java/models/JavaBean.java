package models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class JavaBean implements Serializable {

    private List<String[]> data = null;
    private List<String[]> data1 = null;
    private String fname;

    public JavaBean(){};

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }
    public List<String[]> getData1() {
        return data1;
    }

    public void setData1(List<String[]> data1) {
        this.data1 = data1;
    }

}