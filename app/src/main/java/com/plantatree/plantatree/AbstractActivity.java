package com.plantatree.plantatree;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class AbstractActivity extends Activity {
//	private ObjectGraph mObjectGraph;

//	@Inject
//	protected EventBus mEventBus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		mObjectGraph = ObjectGraph.create(((AbstractApplication)getApplication()).getApplicationGraph());
//		mObjectGraph.inject(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
//		mEventBus.register(this);

	}

	@Override
	protected void onPause() {
		super.onPause();
//		mEventBus.unregister(this);
	}
}
