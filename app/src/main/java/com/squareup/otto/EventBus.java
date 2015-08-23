package com.squareup.otto;

import android.util.Log;

/**
 * Created by robertzhang on 2015-08-21.
 */
public class EventBus extends Bus{
	private static final String  TAG = EventBus.class.getName();
	private static EventBus instance;
	public static EventBus newInstance(){
		if(instance == null){
			instance = new EventBus();
		}
		return instance;
	}
	@Override
	public void post(Object event) {
		Exception ex = new Exception();
		Log.i(TAG, "<== Posting event:" + event + " by " + ex.getStackTrace()[1].getClassName() + "." + ex.getStackTrace()[1].getMethodName() + " - line " + ex.getStackTrace()[1].getLineNumber());
		super.post(event);
	}

	protected void dispatch(Object event, EventHandler wrapper) {
		Log.i(TAG, "==> Handling event:" + event);
		super.dispatch(event, wrapper);
	}
}
