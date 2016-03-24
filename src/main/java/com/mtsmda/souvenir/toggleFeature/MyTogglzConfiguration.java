package com.mtsmda.souvenir.toggleFeature;

import org.springframework.stereotype.Component;
import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.user.UserProvider;
import org.togglz.servlet.user.ServletUserProvider;

import java.io.File;

/**
 * Created by dminzat on 3/21/2016.
 */
@Component
public class MyTogglzConfiguration implements TogglzConfig {

    public Class<? extends Feature> getFeatureClass() {
        return MyFeatures.class;
    }

    public StateRepository getStateRepository() {
        File file = new File("features.properties");
        System.out.println(file.getAbsoluteFile());
        return new FileBasedStateRepository(file);
    }

    public UserProvider getUserProvider() {
        return new ServletUserProvider(null);
    }

}