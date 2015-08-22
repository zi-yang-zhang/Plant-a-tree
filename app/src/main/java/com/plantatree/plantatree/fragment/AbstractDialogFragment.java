package com.plantatree.plantatree.fragment;

import android.app.DialogFragment;

import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class AbstractDialogFragment extends DialogFragment {

	@Inject
	protected Bus mEventBus;
	@Override
	public void onResume() {
		super.onResume();
		mEventBus.register(this);
	}

	@Override
	public void onPause() {
		super.onPause();
		mEventBus.unregister(this);
	}
}
