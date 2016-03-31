package com.mtsmda.souvenir.toggleFeature;

import org.springframework.stereotype.Component;

/**
 * Created by dminzat on 3/29/2016.
 */
@Deprecated
@Component(value = "togglzComponent")
public class TogglzComponent {

	public boolean example() {
		System.out.println(MyFeatures.FEATURE_ONE.isActive());
		return MyFeatures.FEATURE_ONE.isActive();
		// return false;
	}

}