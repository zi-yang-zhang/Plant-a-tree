package com.plantatree.plantatree.fragment;

import android.app.DialogFragment;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class AbstractDialogFragment extends DialogFragment {

//	@Inject
//	protected EventBus mEventBus;
	@Override
	public void onResume() {
		super.onResume();
//		mEventBus.register(this);
	}

	@Override
	public void onPause() {
		super.onPause();
//		mEventBus.unregister(this);
	}
}
