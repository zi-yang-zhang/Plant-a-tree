package com.plantatree.plantatree.manager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.plantatree.gcmbackend.registration.Registration;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class MainIntentService extends IntentService {

	private static final String ACTION_REGISTER_GCM = "register_gcm";
	private static final String SENDER_ID = "820234133273";
	private static Registration regService = null;
	private GoogleCloudMessaging gcm;
	private Context context;

	/**
	 * Creates an IntentService.  Invoked by your subclass's constructor.
	 *
	 * @param name
	 * 		Used to name the worker thread, important only for debugging.
	 */
	public MainIntentService(String name) {
		super(name);
	}

	public static void registerGcm(Context context){
		Intent intent = new Intent(context, MainIntentService.class);
		intent.setAction(ACTION_REGISTER_GCM);
		context.startService(intent);

	}
	@Override
	protected void onHandleIntent(Intent intent) {
		if(intent.getAction() != null){
			String action = intent.getAction();
			switch (action){
				case ACTION_REGISTER_GCM:
					registerGcm();
					break;
			}
		}

	}


	private void registerGcm(){

	}
}
