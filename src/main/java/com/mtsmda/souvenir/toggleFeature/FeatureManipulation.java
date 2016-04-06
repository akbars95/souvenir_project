package com.mtsmda.souvenir.toggleFeature;

/**
 * Created by dminzat on 4/1/2016.
 */
public interface FeatureManipulation {

    public void enable(My3Feature my3Feature);
    public void enableAll();
    public void disable(My3Feature my3Feature);
    public void disableAll();

    public void setState(My3Feature my3Feature, boolean value);

}