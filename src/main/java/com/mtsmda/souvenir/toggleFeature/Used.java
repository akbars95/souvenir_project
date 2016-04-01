package com.mtsmda.souvenir.toggleFeature;

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

        /*PropertiesFileEditor fileManipulation = new PropertiesFileEditor("features.properties");
        System.out.println(fileManipulation.getFile().getAbsoluteFile());
        sout();
        *//*My2Feature my2Feature1 = fileManipulation.getMy2Feature();
        My2Feature[] values = my2Feature1.values();*//*
        System.out.println("");
        fileManipulation.enableAll();
        sout();
        fileManipulation.disableAll();
        sout();
        fileManipulation.enable(My2Feature.FEATURE_ONE);
        sout();
*/
        PropertiesFileEditor fileManipulation = new PropertiesFileEditor("features.properties");
        sout();
        fileManipulation.enable(My3Feature.FEATURE_ONE);
        sout();
        fileManipulation.disableAll();
        sout();
        fileManipulation.push();
    }

    private static void sout(){
        for(My3Feature my3Feature : My3Feature.values()){
            System.out.println(my3Feature.name() + " = " + my3Feature.isActive());
        }
        System.out.println("******************************");
    }

}