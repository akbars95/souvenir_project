package com.mtsmda.souvenir.toggleFeature;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created by dminzat on 3/31/2016.
 */
@Component
public class PropertiesFileEditor implements Editor, FeatureManipulation {

    @Value("features.properties")
    private String filename;

    private static File file;

    private static Properties properties;

    private static boolean lastModifiedFile = false;

    private static Set<String> my3Features = new HashSet<>();

    public PropertiesFileEditor() {
        this.properties = new Properties();
    }

    /**
     * "features.properties"
     */
    public PropertiesFileEditor(String fileName) {
        this();
        this.filename = fileName;
        init();
    }

    @PostConstruct
    public void init() {
        file = new File(this.getClass().getClassLoader().getResource(this.getFilename()).getFile());
        file.lastModified();
        setFeatures();
    }

    public static Boolean isActive(My3Feature my3Feature) {
        if (lastModifiedFile) {
            readPropertiesFile();
        }
        return my3Features.contains(my3Feature.name());
    }

    private static void readPropertiesFile() {
        try (FileInputStream stream = new FileInputStream(file);) {
            properties.load(stream);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    private static void writePropertiesFile() {
        try (FileOutputStream outputStream = new FileOutputStream(file);) {
            properties.store(outputStream, null);
            outputStream.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Failed to write new values", e);
        }
    }

    public void push() {
        writePropertiesFile();
        lastModifiedFile = true;
    }

    public void pull() {
        readPropertiesFile();
    }

    private void setFeatures() {
        readPropertiesFile();
        if (properties != null && !properties.isEmpty()) {
            for (My3Feature my3Feature : My3Feature.class.getEnumConstants()) {
                String property = properties.getProperty(my3Feature.name());
                if (StringUtils.isNotBlank(property)) {
                    boolean b = Boolean.parseBoolean(property);
                    if (b) {
                        this.my3Features.add(my3Feature.name());
                    }
                }
            }
        }
    }

    public void enable(My3Feature my3Feature) {
        if (!my3Features.contains(my3Feature.name())) {
            my3Features.add(my3Feature.name());
            if (properties.containsKey(my3Feature.name())) {
                properties.put(my3Feature.name(), "true");
            }
        }
    }


    public void enableAll() {
        processAll(ENABLE_ALL);
    }

    public void disable(My3Feature my3Feature) {
        if (my3Features.contains(my3Feature.name())) {
            my3Features.remove(my3Feature.name());
            if (properties.containsKey(my3Feature.name())) {
                properties.put(my3Feature.name(), "false");
            }
        }
    }

    public void disableAll() {
        processAll(DISABLE_ALL);
    }

    @Override
    public void setState(My3Feature my3Feature, boolean value) {
        if(value){
            enable(my3Feature);
        }else{
            disable(my3Feature);
        }
    }

    private void processAll(Integer operation) {
        for (My3Feature my3Feature : My3Feature.class.getEnumConstants()) {
            if (operation.equals(ENABLE_ALL)) {
                enable(my3Feature);
            } else if (operation.equals(DISABLE_ALL)) {
                disable(my3Feature);
            }
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}