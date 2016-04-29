package com.mtsmda.souvenir.tests;

/**
 * Created by dminzat on 4/25/2016.
 */
public class Auto extends Car implements MoveAble {

    private Integer id;
    private String model;
    private String marka;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void go() {


    }
}