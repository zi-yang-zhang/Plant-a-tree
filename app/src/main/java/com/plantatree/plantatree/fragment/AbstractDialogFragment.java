package com.plantatree.plantatree.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;

import com.squareup.otto.EventBus;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class AbstractDialogFragment extends DialogFragment {

//	@Inject
protected EventBus mEventBus;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mEventBus = EventBus.newInstance();
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(this.getClass().getName(), "registered bus");
		mEventBus.register(this);
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d(this.getClass().getName(), "unregistered bus");
		mEventBus.unregister(this);
	}
}
