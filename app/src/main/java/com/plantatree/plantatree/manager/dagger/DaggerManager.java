package com.plantatree.plantatree.manager.dagger;

import java.util.Arrays;
import java.util.List;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class DaggerManager {

	public static List<Object> getDaggerModules(){
		return Arrays.asList(
				new ManagerModule(),
				new ControllerModule()
		);
	}
}
