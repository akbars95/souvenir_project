package com.mtsmda.souvenir.toggleFeature;

import org.apache.commons.lang3.StringUtils;
import org.togglz.core.util.IOUtils;

import java.io.*;
import java.util.Properties;

/**
 * Created by dminzat on 3/31/2016.
 */
public class FileManipulation {

    private String fileName;

    private File file;

    private My2Feature my2Feature;

    public FileManipulation() {

    }

    /**
     * "features.properties"
     */
    public FileManipulation(String fileName) {
        this.fileName = fileName;
        file = new File(this.getClass().getClassLoader().getResource(this.fileName).getFile());
    }

    public void readPropertiesFile(Properties properties) {
        try (FileInputStream stream = new FileInputStream(file);) {
            properties.load(stream);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public void writePropertiesFile(Properties properties) {
        try (FileOutputStream outputStream = new FileOutputStream(this.file);) {
            properties.store(outputStream, null);
            outputStream.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Failed to write new values", e);
        }
    }

    public void setFeatures() {
        Properties properties = new Properties();
        readPropertiesFile(properties);
        if (properties != null && !properties.isEmpty()) {
            for (My2Feature my2Feature : this.my2Feature.values()) {
                if (StringUtils.isNotBlank(my2Feature.getName())) {
                    String property = properties.getProperty(my2Feature.getName());
                    if (StringUtils.isNotBlank(property)) {
                        boolean b = Boolean.parseBoolean(property);
                        my2Feature.setValue(b);
                    }
                }
            }
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public My2Feature getMy2Feature() {
        return my2Feature;
    }

    public void setMy2Feature(My2Feature my2Feature) {
        this.my2Feature = my2Feature;
    }
}