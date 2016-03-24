package com.mtsmda.souvenir.toggleFeature;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by dminzat on 3/22/2016.
 */
public class AppConfig {

    private boolean featureOne;

    private boolean featureTwo;

    public boolean isFeatureOne() {
        return featureOne;
    }

    public void setFeatureOne(boolean featureOne) {
        this.featureOne = featureOne;
    }

    public boolean isFeatureTwo() {
        return featureTwo;
    }

    public void setFeatureTwo(boolean featureTwo) {
        this.featureTwo = featureTwo;
    }
}