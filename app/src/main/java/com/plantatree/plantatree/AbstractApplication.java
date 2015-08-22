package com.plantatree.plantatree;

import android.app.Application;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class AbstractApplication extends Application {
//	protected ObjectGraph mApplicationGraph;

	@Override
	public void onCreate() {
		super.onCreate();

//		// Initiates Dagger
//		mApplicationGraph = ObjectGraph.create(DaggerManager.getDaggerModules().toArray());
//		mApplicationGraph.inject(this);
	}

//	public ObjectGraph getApplicationGraph(){
//		return mApplicationGraph;
//	}
}
