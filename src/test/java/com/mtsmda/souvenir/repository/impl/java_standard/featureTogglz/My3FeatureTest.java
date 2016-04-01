package com.mtsmda.souvenir.repository.impl.java_standard.featureTogglz;

import com.mtsmda.souvenir.toggleFeature.My2Feature;
import com.mtsmda.souvenir.toggleFeature.My3Feature;
import com.mtsmda.souvenir.toggleFeature.MyComponent;
import com.mtsmda.souvenir.toggleFeature.PropertiesFileEditor;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by dminzat on 4/1/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:text-mvc-dispatcher-servlet.xml"})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class My3FeatureTest {

    @Autowired
    private PropertiesFileEditor propertiesFileEditor;

    @Autowired
    private MyComponent myComponent;

    @Test
    public void test1000My2FeatureIsNotNull() {
        assertNotNull(propertiesFileEditor);
        sout();
//        propertiesFileEditor.init();
        propertiesFileEditor.enableAll();
        sout();
        propertiesFileEditor.disable(My3Feature.FEATURE_ONE);
        sout();
        propertiesFileEditor.disableAll();
        sout();
        propertiesFileEditor.push();
        System.out.println();
    }

    private static void sout(){
        for(My3Feature my3Feature : My3Feature.values()){
            System.out.println(my3Feature.name() + " = " + my3Feature.isActive());
        }
        System.out.println("******************************");
    }

    @Test
    public void test1001(){
        assertNotNull(myComponent);
        assertFalse(myComponent.testF1());
        assertFalse(myComponent.testF2());
    }

}
