package com.plantatree.plantatree.manager.dagger;

import com.squareup.otto.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by robertzhang on 2015-08-21.
 */

@Module(library = true, complete = false)
public class BusModule {

	@Provides
	@Singleton
	EventBus provideEventBus(){
		return new EventBus();
	}
}
