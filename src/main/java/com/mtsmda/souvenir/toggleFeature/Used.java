package com.mtsmda.souvenir.toggleFeature;

import java.io.File;

/**
 * Created by dminzat on 3/31/2016.
 */
public class Used {

    public static void main(String[] args) {
        /*My2Feature my2Feature = My2Feature.FEATURE_ONE;
        System.out.println(my2Feature.getValue());
        my2Feature.setValue(true);
        System.out.println(my2Feature.getValue());
        System.out.println("-----------------------");*/

        FileManipulation fileManipulation = new FileManipulation("features.properties");
        fileManipulation.setFeatures();
        System.out.println(fileManipulation.getFile().getAbsoluteFile());
        My2Feature my2Feature1 = fileManipulation.getMy2Feature();
        My2Feature[] values = my2Feature1.values();
        System.out.println("");
        fileManipulation.enableAll();
        sout();
        fileManipulation.disableAll();
        sout();
        fileManipulation.enable(My2Feature.FEATURE_ONE);
        sout();

    }

    private static void sout(){
        for(My2Feature my2Feature : My2Feature.values()){
            System.out.println(my2Feature.name() + " = " + my2Feature.getValue());
        }
    }

}