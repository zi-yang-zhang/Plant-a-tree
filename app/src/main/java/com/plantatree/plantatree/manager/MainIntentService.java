package com.plantatree.plantatree.manager;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class MainIntentService extends IntentService {
	/**
	 * Creates an IntentService.  Invoked by your subclass's constructor.
	 *
	 * @param name
	 * 		Used to name the worker thread, important only for debugging.
	 */
	public MainIntentService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {

	}
}
