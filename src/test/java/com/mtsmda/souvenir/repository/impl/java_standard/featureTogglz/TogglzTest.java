package com.mtsmda.souvenir.repository.impl.java_standard.featureTogglz;

import com.mtsmda.souvenir.repository.CaptchaRepository;
import com.mtsmda.souvenir.toggleFeature.AppConfig;
import com.mtsmda.souvenir.toggleFeature.MyFeatures;
import com.mtsmda.souvenir.toggleFeature.MyTogglzConfiguration;
import com.mtsmda.souvenir.toggleFeature.TogglzComponent;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
/*import org.togglz.core.repository.FeatureState;
import org.togglz.core.repository.StateRepository;
*//*import org.togglz.core.repository.FeatureState;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.junit.TogglzRule;*//*
import org.togglz.junit.TogglzRule;*/

import static org.junit.Assert.*;

/**
 * Created by dminzat on 3/22/2016.
 */
@Deprecated
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:text-mvc-dispatcher-servlet.xml"})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TogglzTest {

    /*@Autowired
    @Qualifier("appConfig")
    private AppConfig appConfig;*/

    /*@Autowired
    @Qualifier(value = "captchaRepositoryImplSPJavaStandard")
    private CaptchaRepository captchaRepository;*/

    /*@Autowired
    @Qualifier("togglzComponent")
    private TogglzComponent togglzComponent;

    @Rule
    public TogglzRule togglzRule = TogglzRule.allEnabled(MyFeatures.class);*/

    @Ignore
    @Test
    public void testToggleFeature() {

//         all features are active by default
        /*assertTrue(MyFeatures.FEATURE_ONE.isActive());

        // you can easily modify the feature state using the TogglzRule
        togglzRule.disable(MyFeatures.FEATURE_ONE);
        assertFalse(MyFeatures.FEATURE_ONE.isActive());
        assertNotNull(captchaRepository);

        System.out.println(MyFeatures.FEATURE_ONE.isActive());*/

    }

    @Ignore
    @Test
    public void testJavaTogglz() {
    	/*assertNotNull(togglzComponent);
        StateRepository stateRepository = new MyTogglzConfiguration().getStateRepository();
        stateRepository.setFeatureState(new FeatureState(MyFeatures.FEATURE_ONE, true));
        togglzRule.enableAll();
        stateRepository.setFeatureState(new FeatureState(MyFeatures.FEATURE_TWO, false));
        assertTrue(togglzComponent.example());
        togglzRule.disableAll();
        assertFalse(togglzComponent.example());*/
    }

    /*@Test
    public void verifySpringPropertyFile() {
        assertTrue(appConfig.isFeatureTwo());
        appConfig.setFeatureTwo(false);
        assertFalse(appConfig.isFeatureTwo());
    }*/

}