package com.plantatree.plantatree.manager.dagger;

import com.plantatree.plantatree.manager.IManager;
import com.plantatree.plantatree.manager.MainIntentService;
import com.squareup.otto.EventBus;

import dagger.Module;

/**
 * Created by robertzhang on 2015-08-21.
 */

@Module(
		injects = {
				IManager.class,
				MainIntentService.class,
				EventBus.class
		},
		complete = false

)
public class ManagerModule {
}
