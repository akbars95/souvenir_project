package com.mtsmda.souvenir.toggleFeature;

import java.util.Properties;

/**
 * Created by dminzat on 4/1/2016.
 */
public interface Editor {

    public static final Integer ENABLE_ALL = 0;
    public static final Integer DISABLE_ALL = 1;

    public void push();
    public void pull();

}